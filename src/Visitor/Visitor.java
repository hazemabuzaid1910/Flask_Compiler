package Visitor;

import AST.flask.*;
import AST.flask.DottedName;
import AST.flask.ForStatement;
import AST.flask.IfStatement;
import AST.html.*;
import MainApp.Main;
import SymbolTable.E3_symbolTable;
import antler.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.function.Function;

public class Visitor extends FlaskParserBaseVisitor {

    private String templatesDir = Paths.get("project", "templates").toAbsolutePath().toString();
    private String currentObjectName = null;
    private Stack<String> objectStack = new Stack<>();
    private String currentArrayContext = null;
    private Map<String,Object> runtimeValues = new HashMap<>();
    private Stack<String> objectNameStack = new Stack<>();

    public void setTemplatesDir(String templatesDir) {
        this.templatesDir = templatesDir;
    }


    @Override
    public Object visitProgram(FlaskParser.ProgramContext ctx) {
        Main.semanticError.getE2().insert();
        Main.semanticError.getE3().insert();
        Main.semanticError.getE4().insert();
        Main.semanticError.getE6().insert();
        Main.semanticError
                .getE6()
                .addBuiltinFunction(
                        "json.load",
                        LiteralType.ARRAY
                );

        Main.semanticError
                .getE6()
                .addBuiltinFunction(
                        "open",
                        LiteralType.STRING
                );

        List<Object> elements = new ArrayList<>();

        for (int i = 0; i < ctx.statement().size(); i++) {
            Statement stmt = (Statement) visit(ctx.statement(i));
            elements.add(stmt);
        }

        Main.semanticError.getE2().get();
        Main.semanticError.getE3().get();
        Main.semanticError.getE4().get();
        Main.semanticError.getE6().get();

        return new Program(elements);
    }

    @Override
    public Statement visitStmtImport(FlaskParser.StmtImportContext ctx) {
        if (ctx.importStatement() instanceof FlaskParser.ImportSimpleContext) {
            return visitImportSimple((FlaskParser.ImportSimpleContext) ctx.importStatement());
        }
        if (ctx.importStatement() instanceof FlaskParser.ImportFromContext) {
            return visitImportFrom((FlaskParser.ImportFromContext) ctx.importStatement());
        }
        return null;
    }

    @Override
    public ImportSimple visitImportSimple(FlaskParser.ImportSimpleContext ctx) {
        String importKeyword = ctx.IMPORT().getText();
        List<ImportAlias> aliases = new ArrayList<>();
        for (FlaskParser.ImportAliasContext aliasCtx : ctx.importAlias()) {
            ImportAlias importAlias = visitImportAlias(aliasCtx);
            aliases.add(importAlias);
        }
        return new ImportSimple(importKeyword, aliases);
    }

    @Override
    public ImportStatement visitImportFrom(FlaskParser.ImportFromContext ctx) {
        List<ImportAlias> aliases = new ArrayList<>();
        DottedName dottedName = visitDottedName(ctx.dottedName());

        for (FlaskParser.ImportAliasContext aliasCtx : ctx.importAlias()) {
            ImportAlias importAlias = visitImportAlias(aliasCtx);
            aliases.add(importAlias);
            Main.semanticError.getE4().add(importAlias.getName(),dottedName.getFirst());
        }
        return new ImportFrom(dottedName, aliases);
    }

    @Override
    public DottedName visitDottedName(FlaskParser.DottedNameContext ctx) {
        String first = ctx.IDENTIFIER(0).getText();
        List<String> rest = new ArrayList<>();
        for (int i = 1; i < ctx.getChildCount(); i++) {
            String text = ctx.getChild(i).getText();
            if (text.equals(".")) continue;
            rest.add(text);
        }
        return new DottedName(first, rest);
    }

    @Override
    public ImportAlias visitImportAlias(FlaskParser.ImportAliasContext ctx) {
        String name = ctx.IDENTIFIER(0).getText();
        String asName = ctx.AS() != null ? ctx.IDENTIFIER(1).getText() : null;
        return new ImportAlias(name, asName);
    }

    @Override
    public Statement visitStmtReturn(FlaskParser.StmtReturnContext ctx) {
        ReturnStatement returnStmt = visitReturnStatement(ctx.returnStatement());
        return new StmtReturn(returnStmt);
    }

    @Override
    public ReturnStatement visitReturnStatement(FlaskParser.ReturnStatementContext ctx) {
        Main.semanticError.getE5().insert();
        Main.semanticError.getE4().insert();

        Expression expression = null;
        if (ctx.expression() != null) {
            expression = visitExpression(ctx.expression());

            RenderTemplateInfo renderInfo = extractRenderTemplateInfo(expression);

            if (renderInfo != null) {
                String fullPath = resolveTemplatePath(renderInfo.templatePath);
                String htmlContent = readHtmlFile(fullPath);
                for (String variable : renderInfo.passedVariables.keySet()) {

                    Main.semanticError.getE5().addPassed(
                            renderInfo.templatePath,
                            variable
                    );
                }
                if (htmlContent != null && !htmlContent.isEmpty()) {
                    try {
                        // بناء AST HTML
                        org.antlr.v4.runtime.CharStream input =
                                org.antlr.v4.runtime.CharStreams.fromFileName(fullPath);
                        HtmlLexer lexer = new HtmlLexer(input);
                        CommonTokenStream tokens = new CommonTokenStream(lexer);
                        HtmlParser parser = new HtmlParser(tokens);
                        ParseTree tree = parser.htmlNode();
                        htmlVisitor visitor = new htmlVisitor();
                        HtmlNode htmlNode = (HtmlNode) visitor.visit(tree);
                        if (renderInfo.passedVariables!=null){
                            Main.semanticError.getE5().check_E5();

                        }
                        Main.semanticError.getE4().get();
                        Main.semanticError.getE5().get();
                        return new ReturnStatement(expression, htmlNode, renderInfo.templatePath);

                    } catch (IOException e) {
                        System.err.println("Error reading HTML file: " + fullPath);
                        System.err.println("Exception: " + e.getMessage());
                        e.printStackTrace();
                    }
                }

            }
        }
        return new ReturnStatement(expression);
    }




    @Override
    public Statement visitStmtIf(FlaskParser.StmtIfContext ctx) {
        IfStatement ifStmt = visitIfStatement(ctx.ifStatement());
        return new StmtIf(ifStmt);
    }

    @Override
    public Statement visitStmtFor(FlaskParser.StmtForContext ctx) {
        ForStatement forStatement = visitForStatement(ctx.forStatement());
        return new StmtFor(forStatement);
    }
    @Override
    public ForStatement visitForStatement(FlaskParser.ForStatementContext ctx) {
        String loopVariable = ctx.IDENTIFIER().getText();
        Expression expression = visitExpression(ctx.expression());

        String arrayName = extractArrayNameFromExpression(expression);

        Main.semanticError.getE4().add(loopVariable,arrayName);
        Main.semanticError.getE4().check_E4(arrayName,ctx.getStart().getLine());

        if (arrayName != null) {
            String elementName = arrayName + "_element";

            // طباعة للتصحيح

            // الحصول على خصائص العنصر
            Set<String> elementProperties = Main.semanticError.getE3().getObjectProperties(elementName);

            if (elementProperties != null && !elementProperties.isEmpty()) {
                for (String prop : elementProperties) {
                    Main.semanticError.getE3().addProperty(loopVariable, prop);
                }
            } else {
                // محاولة بديلة: البحث عن خصائص المصفوفة نفسها
                Set<String> arrayProperties = Main.semanticError.getE3().getObjectProperties(arrayName);
                if (arrayProperties != null && !arrayProperties.isEmpty()) {
                    for (String prop : arrayProperties) {
                        Main.semanticError.getE3().addProperty(loopVariable, prop);
                    }
                }
            }

            Main.semanticError.getE3().addObjectReference(loopVariable, elementName);

            objectNameStack.push(loopVariable);
            currentObjectName = loopVariable;
        }

        Block block = visitBlock(ctx.block());

        if (arrayName != null) {
            objectNameStack.pop();
            currentObjectName = objectNameStack.isEmpty() ? null : objectNameStack.peek();
        }

        return new ForStatement(loopVariable, expression, block);
    }

    @Override
    public Statement visitStmtWith(FlaskParser.StmtWithContext ctx) {
        return visitWithStatement(ctx.withStatement());
    }

    @Override
    public WithStatement visitWithStatement(FlaskParser.WithStatementContext ctx) {
        Expression expression = visitExpression(ctx.expression());
        String name = ctx.IDENTIFIER() != null ? ctx.IDENTIFIER().getText() : null;
        Block block = visitBlock(ctx.block());
        return new WithStatement(expression, name, block);
    }

    @Override
    public IfStatement visitIfStatement(FlaskParser.IfStatementContext ctx) {
        Expression expression = visitExpression(ctx.expression());
        Block block = visitBlock(ctx.block());
        if (ctx.elseClause() == null) {
            return new IfStatement(expression, block, null);
        }
        ElseClause elseClause = visitElseClause(ctx.elseClause());
        return new IfStatement(expression, block, elseClause);
    }

    @Override
    public ElseClause visitElseClause(FlaskParser.ElseClauseContext ctx) {
        Block block = visitBlock(ctx.block());
        return new ElseClause(block);
    }

    @Override
    public Statement visitStmtFunction(FlaskParser.StmtFunctionContext ctx) {
        FunctionDef functionDef = visitFunctionDef(ctx.functionDef());
        return new StmtFunction(functionDef);
    }

    @Override
    public Statement visitStmtDecorator(FlaskParser.StmtDecoratorContext ctx) {

        return new StmtDecorator(visitDecoratedFunction(ctx.decoratedFunction()));

    }

    @Override
    public DecoratorStatement visitDecoratedFunction(FlaskParser.DecoratedFunctionContext ctx) {
        Main.semanticError.getE4().insert();
        Decorator decorator = visitDecorator(ctx.decorator());
        FunctionDef functionDef = visitFunctionDef(ctx.functionDef());
        Main.semanticError.getE4().get();
        return new DecoratorStatement(decorator, functionDef);
    }

    @Override
    public Decorator visitDecorator(FlaskParser.DecoratorContext ctx) {
        ArgumentList argumentList = visitArgumentList(ctx.argumentList());
        DottedName dottedName = visitDottedName(ctx.dottedName());
        return new Decorator(dottedName, argumentList);
    }

    @Override
    public ArgumentList visitArgumentList(FlaskParser.ArgumentListContext ctx) {
        List<Argument> arguments = ctx.argument().stream().map(a -> (Argument) visit(a)).toList();
        return new ArgumentList(arguments);
    }

    @Override
    public Argument visitArgExpression(FlaskParser.ArgExpressionContext ctx) {
        Expression expression = visitExpression(ctx.expression());
        return new ArgExpression(expression);
    }

    @Override
    public Argument visitArgAssignment(FlaskParser.ArgAssignmentContext ctx) {
        String left = ctx.IDENTIFIER().getText();
        Expression expression = visitExpression(ctx.expression());
        return new ArgAssignment(left, expression);
    }

    @Override
    public FunctionDef visitFunctionDef(FlaskParser.FunctionDefContext ctx) {

        String fuctionName = ctx.IDENTIFIER().getText();
        Main.semanticError.getE2().check_E2(ctx.IDENTIFIER().getText() , ctx.getStart().getLine());
        Main.semanticError.getE4().add(fuctionName,"");
        Main.semanticError.getE4().insert();
        Block block = visitBlock(ctx.block());
        if (ctx.parameterList() == null) {
            return new FunctionDef(fuctionName, null, block);
        }
        ParameterList parameterList = visitParameterList(ctx.parameterList());
        Main.semanticError.getE4().get();
        return new FunctionDef(fuctionName, parameterList, block);
    }

    @Override
    public ParameterList visitParameterList(FlaskParser.ParameterListContext ctx) {
        List<ParameterFunction> rest = ctx.parameterFunction()
                .stream()
                .map(p -> (ParameterFunction) visit(p))
                .toList();
        return new ParameterList(rest);
    }

    @Override
    public ParameterFunction visitParamIdentifier(FlaskParser.ParamIdentifierContext ctx) {
        String name = ctx.IDENTIFIER().getText();
        return new ParamIdentifier(name);
    }

    @Override
    public ParameterFunction visitParamExpression(FlaskParser.ParamExpressionContext ctx) {
        Expression expression = visitExpression(ctx.expression());
        return new ParamExpression(expression);
    }

    @Override
    public Expression visitExpression(FlaskParser.ExpressionContext ctx) {

        Expression result = visitPrimary(ctx.primary(0));


        for(int i = 0; i < ctx.compOp().size(); i++){

            String op =
                    ctx.compOp(i).getText();


            Expression right = visitPrimary(ctx.primary(i + 1));


            result = new Expression(result, op, right);
        }


        return result;
    }

    @Override
    public Block visitBlock(FlaskParser.BlockContext ctx) {
        String previousObjectName = currentObjectName;
        int previousStackSize = objectNameStack.size();
        if (ctx == null) {
            return new Block(new ArrayList<>());
        }
        List<Statement> statements = ctx.statement()
                .stream()
                .map(s -> (Statement) visit(s))
                .toList();

        currentObjectName = previousObjectName;
        while (objectNameStack.size() > previousStackSize) {
            objectNameStack.pop();
        }

        return new Block(statements);
    }

    @Override
    public Expression visitPrimary(FlaskParser.PrimaryContext ctx) {

        Atom atom = (Atom) visit(ctx.atom());

        Primary primary = new Primary(
                atom,
                new ArrayList<>()
        );

        for (FlaskParser.PostfixContext postfixCtx : ctx.postfix()) {

            if (postfixCtx instanceof FlaskParser.MemberAccessContext memberCtx) {

                primary.addPostfix(
                        new MemberAccess(
                                memberCtx.IDENTIFIER().getText()
                        )
                );
            }

            else if (postfixCtx instanceof FlaskParser.IndexAccessContext indexCtx) {

                primary.addPostfix(
                        new IndexAccess(
                                visitExpression(indexCtx.expression())
                        )
                );
            }

            else if (postfixCtx instanceof FlaskParser.CallContext callCtx) {

                primary.addPostfix(
                        new Call(
                                callCtx.argumentList() != null
                                        ? visitArgumentList(callCtx.argumentList())
                                        : null
                        )
                );
            }
        }

        return new Expression(primary);
    }
    @Override
    public Atom visitAtom(FlaskParser.AtomContext ctx) {


        if(ctx.IDENTIFIER()!=null){

            return new IdentifierAtom(
                    ctx.IDENTIFIER().getText()
            );

        }


        if(ctx.literal()!=null){

            return visitLiteral(ctx.literal());

        }


        if(ctx.expression()!=null){

            Expression expr =
                    visitExpression(ctx.expression());

            return (Atom) expr.getLeft();

        }


        return null;
    }



    @Override
    public Statement visitStmtAssign(FlaskParser.StmtAssignContext ctx) {
        AssignmentStatement assignmentStatement = visitAssignmentStatement(ctx.assignmentStatement());
        return new StmtAssign(assignmentStatement);
    }

    @Override
    public Statement visitStmtExpression(FlaskParser.StmtExpressionContext ctx) {
        Expression expression = (Expression) visit(ctx.expression());
        return new StmtExpression(expression);
    }

    @Override
    public AssignmentStatement visitAssignmentStatement(
            FlaskParser.AssignmentStatementContext ctx) {

        Expression left = visitPrimary(ctx.primary());

        String leftName =
                extractIdentifierFromExpression(left);

        if (leftName != null) {
            objectStack.push(leftName);
        }

        Expression right =
                visitExpression(ctx.expression());

        Object value =
                evaluateExpression(right);

        if (leftName != null && value != null) {
            runtimeValues.put(leftName, value);
        }

        String rightName =
                extractIdentifierFromExpression(right);

        LiteralType exprType =
                resolveExpressionType(right);

        if (leftName != null) {

            Main.semanticError
                    .getE4()
                    .add(leftName, "");

            if (exprType != null) {
                Main.semanticError
                        .getE6()
                        .addVariable(
                                leftName,
                                exprType
                        );
            }
        }

        if (leftName != null && rightName != null) {

            Main.semanticError
                    .getE4()
                    .check_E4(
                            rightName,
                            ctx.getStart().getLine()
                    );

            Main.semanticError
                    .getE3()
                    .copyProperties(
                            rightName,
                            leftName
                    );
        }

        if (leftName != null) {
            objectStack.pop();
        }

        return new AssignmentStatement(left, right);
    }
    @Override
    public CompOp visitCompOp(FlaskParser.CompOpContext ctx) {
        String op = ctx.getText();
        return switch (op) {
            case "==" -> CompOp.EQUAL;
            case "!=" -> CompOp.NOT_EQUAL;
            case "<" -> CompOp.LESS;
            case ">" -> CompOp.GREATER;
            default -> throw new RuntimeException("Unknown operator: " + op);
        };
    }

    @Override
    public Literal visitLiteral(FlaskParser.LiteralContext ctx) {
        if (ctx.STRING() != null) {
            String text = ctx.STRING().getText();
            String value = text.substring(1, text.length() - 1);
            return new Literal(LiteralType.STRING, value);
        }
        if (ctx.NUMBER() != null) {
            String numText = ctx.NUMBER().getText();
            Object value;
            if (numText.contains(".")) {
                value = Double.parseDouble(numText);
            } else {
                value = Integer.parseInt(numText);
            }
            return new Literal(LiteralType.NUMBER, value);
        }
        if (ctx.NONE() != null) {
            return new Literal(LiteralType.NONE, null);
        }
        if (ctx.TRUE() != null) {
            return new Literal(LiteralType.TRUE, true);
        }
        if (ctx.FALSE() != null) {
            return new Literal(LiteralType.FALSE, false);
        }
        throw new RuntimeException("Unknown literal: " + ctx.getText());
    }

    @Override
    public ObjectLiteral visitObjectLiteral(FlaskParser.ObjectLiteralContext ctx) {
        List<Pair> pairs = ctx.pair().stream().map(this::visitPair).toList();

        // استخدم الـ Stack لتسجيل الخصائص
        if (!objectStack.isEmpty() && !pairs.isEmpty()) {
            String objectName = objectStack.peek();
            for (Pair pair : pairs) {
                Main.semanticError.getE3().addProperty(objectName, pair.getKey());
            }
        }

        return new ObjectLiteral(pairs);
    }
    @Override
    public Pair visitPair(FlaskParser.PairContext ctx) {
        String key;
        boolean isStringKey = false;
        if (ctx.STRING() != null) {
            key = ctx.STRING().getText();
            key = key.substring(1, key.length() - 1);
            isStringKey = true;
        } else {
            key = ctx.IDENTIFIER().getText();
        }
        Expression expression = visitExpression(ctx.expression());
        return new Pair(key, isStringKey, expression);
    }

    @Override
    public ArrayLiteral visitArrayLiteral(FlaskParser.ArrayLiteralContext ctx) {
        String previousArrayContext = currentArrayContext;

        if (!objectStack.isEmpty()) {
            currentArrayContext = objectStack.peek();
            Main.semanticError.getE3().setObjectType(currentArrayContext, "array");
        }

        List<Expression> expressionList = ctx.expression().stream().map(this::visitExpression).toList();

        if (currentArrayContext != null) {
            String elementName = currentArrayContext + "_element";
            for (Expression expr : expressionList) {
                ObjectLiteral objLit = findObjectLiteralInExpression(expr);
                if (objLit != null) {
                    for (Pair pair : objLit.getPairList()) {
                        Main.semanticError.getE3().addProperty(elementName, pair.getKey());
                    }
                    Main.semanticError.getE3().setObjectType(elementName, "object");
                    break;
                }
            }
        }

        currentArrayContext = previousArrayContext;
        return new ArrayLiteral(expressionList);
    }



    @Override
    public ListComprehension visitListComprehension(FlaskParser.ListComprehensionContext ctx) {
        Expression target = (Expression) visit(ctx.expression(0));
        String loopVar = ctx.IDENTIFIER().getText();
        Expression iterable = (Expression) visit(ctx.expression(1));
        Expression condition = null;
        if (ctx.expression().size() == 3) {
            condition = (Expression) visit(ctx.expression(2));
        }
        return new ListComprehension(target, loopVar, iterable, condition);
    }

    // ====================  دوال مساعدة ====================
    private static class RenderTemplateInfo {
        String templatePath;
        Map<String, String> passedVariables;

        RenderTemplateInfo(String templatePath) {
            this.templatePath = templatePath;
            this.passedVariables = new HashMap<>();
        }

        public void addVariable(String key, String value) {
            passedVariables.put(key, value);
        }
    }
    private String extractIdentifierFromExpression(Expression expr) {

        return traverseExpression(expr, primary -> {

            if (primary.getAtom() instanceof IdentifierAtom identifier) {
                return identifier.getValue();
            }

            return null;
        });
    }

    private ObjectLiteral findObjectLiteralInExpression(
            Expression expr
    ) {

        return traverseExpression(expr, primary -> {

            if (primary.getAtom() instanceof ObjectLiteral obj) {
                return obj;
            }

            return null;
        });
    }

    private LiteralType resolveExpressionType(Expression expr) {

        if (expr == null) {
            return null;
        }

        Object value = expr.getLeft();

        if (value instanceof Literal literal) {
            return literal.getType();
        }

        if (value instanceof IdentifierAtom identifier) {

            return Main.semanticError
                    .getE6()
                    .getType(identifier.getValue());
        }

        if (value instanceof ArrayLiteral) {
            return LiteralType.ARRAY;
        }

        if (value instanceof ObjectLiteral) {
            return LiteralType.OBJECT;
        }

        return null;
    }
    private String resolveFullFunctionName(
            Primary primary
    ) {

        if (primary == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();

        if (primary.getAtom() instanceof IdentifierAtom id) {

            sb.append(id.getValue());

        } else {
            return null;
        }

        for (Postfix postfix : primary.getPostfixes()) {

            if (postfix instanceof MemberAccess member) {

                sb.append(".");
                sb.append(member.getValue());
            }

            if (postfix instanceof Call) {
                break;
            }
        }

        return sb.toString();
    }
    private <T> T traverseExpression(
            Expression expr,
            Function<Primary, T> extractor
    ) {

        if (expr == null) {
            return null;
        }

        if (expr.getLeft() instanceof Primary primary) {

            T result = extractor.apply(primary);

            if (result != null) {
                return result;
            }
        }

        if (expr.getRight() instanceof Expression rightExpr) {

            return traverseExpression(
                    rightExpr,
                    extractor
            );
        }

        return null;
    }
    private RenderTemplateInfo extractRenderTemplateInfo(
            Expression expr
    ) {

        return traverseExpression(expr, primary -> {

            Atom atom = primary.getAtom();

            if (!(atom instanceof IdentifierAtom identifier)) {
                return null;
            }

            if (!"render_template".equals(identifier.getValue())) {
                return null;
            }

            for (Postfix postfix : primary.getPostfixes()) {

                if (postfix instanceof Call call) {
                    return extractTemplatePathFromCall(call);
                }
            }

            return null;
        });
    }


    private RenderTemplateInfo extractTemplatePathFromCall(Call call) {
        ArgumentList args = call.getArgumentList();

        if (args == null) return null;

        List<Argument> arguments = args.getArguments();

        if (arguments.isEmpty()) return null;

        RenderTemplateInfo info = null;

        for (int i = 0; i < arguments.size(); i++) {

            Argument arg = arguments.get(i);

            // أول argument = اسم الملف
            if (i == 0 && arg instanceof ArgExpression) {

                Expression expr = ((ArgExpression) arg).getExpression();

                String templatePath = extractStringFromExpression(expr);

                if (templatePath != null) {
                    info = new RenderTemplateInfo(templatePath);
                }
            }

            // باقي arguments = variables
            else if (arg instanceof ArgAssignment && info != null) {

                ArgAssignment assign = (ArgAssignment) arg;

                String variableName = assign.getIdentifier();

                String variableValue =
                        extractIdentifierFromExpression(assign.getExpression());

                info.addVariable(variableName, variableValue);
            }
        }

        return info;
    }

    private String extractStringFromExpression(Expression expr) {

        return traverseExpression(expr, primary -> {

            Atom atom = primary.getAtom();

            if (atom instanceof Literal literal &&
                    literal.getType() == LiteralType.STRING) {

                return (String) literal.getValue();
            }

            return null;
        });
    }
    private String extractStringFromAdditive(Additive additive) {
        List<Multiplicative> multiplicatives = additive.getMultiplicatives();
        if (multiplicatives == null || multiplicatives.isEmpty()) return null;

        for (Multiplicative multi : multiplicatives) {
            String result = extractStringFromMultiplicative(multi);
            if (result != null) return result;
        }
        return null;
    }

    private String extractStringFromMultiplicative(Multiplicative multiplicative) {
        List<Unary> unaries = multiplicative.getUnaryList();
        if (unaries == null || unaries.isEmpty()) return null;

        for (Unary unary : unaries) {
            String result = extractStringFromUnary(unary);
            if (result != null) return result;
        }
        return null;
    }

    private String extractStringFromUnary(Unary unary) {
        Primary primary = unary.getPrimary();
        if (primary == null) return null;

        Atom atom = primary.getAtom();
        if (atom instanceof Literal) {
            Literal literal = (Literal) atom;
            if (literal.getType() == LiteralType.STRING) {
                return (String) literal.getValue();
            }
        }

        return null;
    }


    private String resolveTemplatePath(String relativePath) {
        if (relativePath.startsWith("\"") && relativePath.endsWith("\"")) {
            relativePath = relativePath.substring(1, relativePath.length() - 1);
        }
        if (relativePath.startsWith("'") && relativePath.endsWith("'")) {
            relativePath = relativePath.substring(1, relativePath.length() - 1);
        }

        return Paths.get(templatesDir, relativePath).toString();
    }

    private String readHtmlFile(String filePath) {
        try {
            Path path = Paths.get(filePath);
            if (!Files.exists(path)) {
                System.err.println("Template file not found: " + filePath);
                return null;
            }
            return new String(Files.readAllBytes(path));
        } catch (IOException e) {
            System.err.println("Error reading template file: " + filePath);
            e.printStackTrace();
            return null;
        }
    }

    private Object evaluateExpression(Expression expr){

        return traverseExpression(expr, primary -> {

            if(primary.getAtom() instanceof IdentifierAtom id){

                String name = id.getValue();


                if(name.equals("load_products")){

                    JsonArray array = readJsonArray("project/products.json");

                    System.out.println("Returned from load_products:");
                    System.out.println(array);

                    registerJsonArray("products", array);

                    return array;
                }


                if(runtimeValues.containsKey(name)){
                    return runtimeValues.get(name);
                }
            }

            return null;

        });
    }
    private JsonArray readJsonArray(String file){

        try{

            String content = Files.readString(Paths.get(file));

            System.out.println("JSON Content:");
            System.out.println(content);

            JsonArray array = JsonParser
                    .parseString(content)
                    .getAsJsonArray();

            System.out.println("JSON Array size = " + array.size());

            for(int i = 0; i < array.size(); i++){
                System.out.println("Element " + i + ": " + array.get(i));
            }

            return array;

        }catch(Exception e){

            e.printStackTrace();
            return null;
        }
    }
    private String extractArrayNameFromExpression(Expression expr) {

        if (expr == null) {
            return null;
        }

        Object value = expr.getLeft();

        if (value instanceof Primary primary &&
                primary.getAtom() instanceof IdentifierAtom identifier) {

            return identifier.getValue();
        }

        if (expr.getRight() instanceof Expression rightExpr) {
            return extractArrayNameFromExpression(rightExpr);
        }

        return null;
    }
    private void registerJsonArray(String name, JsonArray array){

        if(array == null || array.size()==0)
            return;


        if(array.get(0).isJsonObject()){

            String elementName = name + "_element";


            array.get(0)
                    .getAsJsonObject()
                    .keySet()
                    .forEach(property -> {

                        Main.semanticError
                                .getE3()
                                .addProperty(
                                        elementName,
                                        property
                                );

                    });


            Main.semanticError
                    .getE3()
                    .setObjectType(
                            elementName,
                            "object"
                    );
        }
    }
}