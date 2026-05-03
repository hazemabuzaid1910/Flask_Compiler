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

import java.util.*;
import java.io.IOException;
import java.nio.file.*;

public class Visitor extends FlaskParserBaseVisitor {

    private String templatesDir = "C:/Users/hazem/OneDrive/Desktop/4/minmax/Compiler/project/templates/";
    private String currentObjectName = null;
    private Stack<String> objectStack = new Stack<>();
    private String currentArrayContext = null;
    private Stack<String> objectNameStack = new Stack<>();

    private String basePath = "";


    @Override
    public Object visitProgram(FlaskParser.ProgramContext ctx) {
        Main.semanticError.getE2().insert();
        Main.semanticError.getE3().insert();
        List<Object> elements = new ArrayList<>();

        for (int i = 0; i < ctx.statement().size(); i++) {
            Statement stmt = (Statement) visit(ctx.statement(i));
            elements.add(stmt);
        }

        Main.semanticError.getE2().get();
        Main.semanticError.getE3().get();
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
        for (FlaskParser.ImportAliasContext aliasCtx : ctx.importAlias()) {
            ImportAlias importAlias = visitImportAlias(aliasCtx);
            aliases.add(importAlias);
        }
        DottedName dottedName = visitDottedName(ctx.dottedName());
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
        Expression expression = null;
        if (ctx.expression() != null) {
            expression = visitExpression(ctx.expression());

            RenderTemplateInfo renderInfo = extractRenderTemplateInfo(expression);

            if (renderInfo != null) {

                String fullPath = resolveTemplatePath(renderInfo.templatePath);
                String htmlContent = readHtmlFile(fullPath);

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

    private RenderTemplateInfo extractRenderTemplateInfo(Expression expr) {
        if (expr == null) return null;

        Comparison comparison = expr.getComparison();
        if (comparison == null) return null;

        return searchForRenderTemplate(comparison);
    }

    private RenderTemplateInfo searchForRenderTemplate(Comparison comparison) {
        LogicalOR firstOr = comparison.getFirst();
        if (firstOr == null) return null;

        List<LogicalAnd> orTerms = firstOr.getRest();
        if (orTerms.isEmpty()) return null;

        for (LogicalAnd logicalAnd : orTerms) {
            RenderTemplateInfo result = searchInLogicalAnd(logicalAnd);
            if (result != null) return result;
        }
        return null;
    }

    private RenderTemplateInfo searchInLogicalAnd(LogicalAnd logicalAnd) {
        List<Additive> additives = logicalAnd.getAdditives();
        if (additives == null || additives.isEmpty()) return null;

        for (Additive additive : additives) {
            RenderTemplateInfo result = searchInAdditive(additive);
            if (result != null) return result;
        }
        return null;
    }

    private RenderTemplateInfo searchInAdditive(Additive additive) {
        List<Multiplicative> multiplicatives = additive.getMultiplicatives();
        if (multiplicatives == null || multiplicatives.isEmpty()) return null;

        for (Multiplicative multi : multiplicatives) {
            RenderTemplateInfo result = searchInMultiplicative(multi);
            if (result != null) return result;
        }
        return null;
    }

    private RenderTemplateInfo searchInMultiplicative(Multiplicative multiplicative) {
        List<Unary> unaries = multiplicative.getUnaryList();
        if (unaries == null || unaries.isEmpty()) return null;

        for (Unary unary : unaries) {
            RenderTemplateInfo result = searchInUnary(unary);
            if (result != null) return result;
        }
        return null;
    }

    private RenderTemplateInfo searchInUnary(Unary unary) {
        Primary primary = unary.getPrimary();
        if (primary == null) return null;
        return searchInPrimary(primary);
    }

    private RenderTemplateInfo searchInPrimary(Primary primary) {
        Atom atom = primary.getAtom();
        List<Postfix> postfixes = primary.getPostfixes();

        if (!(atom instanceof IdentifierAtom)) return null;
        String functionName = ((IdentifierAtom) atom).getValue();
        if (!"render_template".equals(functionName)) return null;

        for (Postfix postfix : postfixes) {
            if (postfix instanceof Call) {
                Call call = (Call) postfix;
                return extractTemplatePathFromCall(call);
            }
        }

        return null;
    }

    private RenderTemplateInfo extractTemplatePathFromCall(Call call) {
        ArgumentList args = call.getArgumentList();
        if (args == null) return null;

        List<Argument> arguments = args.getArguments();
        if (arguments.isEmpty()) return null;

        Argument firstArg = arguments.get(0);
        if (!(firstArg instanceof ArgExpression)) return null;

        Expression argExpr = ((ArgExpression) firstArg).getExpression();
        String templatePath = extractStringFromExpression(argExpr);

        if (templatePath != null) {
            return new RenderTemplateInfo(templatePath);
        }

        return null;
    }

    private String extractStringFromExpression(Expression expr) {
        if (expr == null) return null;

        Comparison comparison = expr.getComparison();
        if (comparison == null) return null;

        LogicalOR firstOr = comparison.getFirst();
        if (firstOr == null) return null;

        List<LogicalAnd> orTerms = firstOr.getRest();
        if (orTerms.isEmpty()) return null;

        for (LogicalAnd logicalAnd : orTerms) {
            String result = extractStringFromLogicalAnd(logicalAnd);
            if (result != null) return result;
        }

        return null;
    }

    private String extractStringFromLogicalAnd(LogicalAnd logicalAnd) {
        List<Additive> additives = logicalAnd.getAdditives();
        if (additives == null || additives.isEmpty()) return null;

        for (Additive additive : additives) {
            String result = extractStringFromAdditive(additive);
            if (result != null) return result;
        }
        return null;
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

        return templatesDir + relativePath;
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
    private String extractArrayNameFromExpression(Expression expr) {
        if (expr == null) return null;
        Comparison comparison = expr.getComparison();
        if (comparison == null) return null;
        LogicalOR firstOr = comparison.getFirst();
        if (firstOr == null) return null;
        List<LogicalAnd> orTerms = firstOr.getRest();
        if (orTerms == null || orTerms.isEmpty()) return null;

        for (LogicalAnd logicalAnd : orTerms) {
            List<Additive> additives = logicalAnd.getAdditives();
            if (additives != null) {
                for (Additive additive : additives) {
                    List<Multiplicative> multiplicatives = additive.getMultiplicatives();
                    if (multiplicatives != null) {
                        for (Multiplicative multi : multiplicatives) {
                            List<Unary> unaries = multi.getUnaryList();
                            if (unaries != null) {
                                for (Unary unary : unaries) {
                                    Primary primary = unary.getPrimary();
                                    if (primary != null && primary.getAtom() instanceof IdentifierAtom) {
                                        return ((IdentifierAtom) primary.getAtom()).getValue();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
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
        Decorator decorator = visitDecorator(ctx.decorator());
        FunctionDef functionDef = visitFunctionDef(ctx.functionDef());
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

        Block block = visitBlock(ctx.block());
        if (ctx.parameterList() == null) {
            return new FunctionDef(fuctionName, null, block);
        }
        ParameterList parameterList = visitParameterList(ctx.parameterList());

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
        Comparison comparison = visitComparison(ctx.comparison());
        return new Expression(comparison);
    }

    @Override
    public Block visitBlock(FlaskParser.BlockContext ctx) {
        String previousObjectName = currentObjectName;
        int previousStackSize = objectNameStack.size();

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
    public Comparison visitComparison(FlaskParser.ComparisonContext ctx) {
        LogicalOR first = visitLogicalOr(ctx.logicalOr(0));
        List<CompOp> ops = new ArrayList<>();
        List<LogicalOR> rest = new ArrayList<>();
        for (int i = 0; i < ctx.compOp().size(); i++) {
            ops.add(visitCompOp(ctx.compOp(i)));
            rest.add(visitLogicalOr(ctx.logicalOr(i + 1)));
        }
        return new Comparison(first, ops, rest);
    }

    @Override
    public LogicalOR visitLogicalOr(FlaskParser.LogicalOrContext ctx) {
        List<LogicalAnd> terms = new ArrayList<>();
        for (int i = 0; i < ctx.logicalAnd().size(); i++) {
            terms.add(visitLogicalAnd(ctx.logicalAnd(i)));
        }
        return new LogicalOR(terms);
    }

    @Override
    public LogicalAnd visitLogicalAnd(FlaskParser.LogicalAndContext ctx) {
        ArrayList<Additive> additives = new ArrayList<>();
        for (FlaskParser.AdditiveContext additive : ctx.additive()) {
            additives.add(visitAdditive(additive));
        }
        return new LogicalAnd(additives);
    }

    @Override
    public Additive visitAdditive(FlaskParser.AdditiveContext ctx) {
        ArrayList<Multiplicative> multiplicatives = new ArrayList<>();
        List<String> operator = new ArrayList<>();
        for (int i = 0; i < ctx.multiplicative().size(); i++) {
            multiplicatives.add(visitMultiplicative(ctx.multiplicative(i)));
            if (i < ctx.multiplicative().size() - 1) {
                if (ctx.MINUS(i) != null) {
                    operator.add(ctx.MINUS(i).getText());
                } else {
                    operator.add(ctx.PLUS(i).getText());
                }
            }
        }
        return new Additive(multiplicatives, operator);
    }

    @Override
    public Multiplicative visitMultiplicative(FlaskParser.MultiplicativeContext ctx) {
        ArrayList<Unary> unaries = new ArrayList<>();
        List<String> operator = new ArrayList<>();
        for (int i = 0; i < ctx.unary().size(); i++) {
            unaries.add(visitUnary(ctx.unary(i)));
            if (i < ctx.unary().size() - 1) {
                if (ctx.DIV(i) != null) {
                    operator.add(ctx.DIV(i).getText());
                } else {
                    operator.add(ctx.MUL(i).getText());
                }
            }
        }
        return new Multiplicative(unaries, operator);
    }

    @Override
    public Unary visitUnary(FlaskParser.UnaryContext ctx) {
        Primary primary = visitPrimary(ctx.primary());
        return new Unary(primary);
    }

    @Override
    public Primary visitPrimary(FlaskParser.PrimaryContext ctx) {
        Atom atom = (Atom) visit(ctx.atom());
        List<Postfix> postfixes = new ArrayList<>();
        for (FlaskParser.PostfixContext postfixContext : ctx.postfix()) {
            postfixes.add((Postfix) visit(postfixContext));
        }
        return new Primary(atom, postfixes);
    }

    @Override
    public Atom visitIdentifierAtom(FlaskParser.IdentifierAtomContext ctx) {
        return new IdentifierAtom(ctx.IDENTIFIER().getText());
    }

    @Override
    public Atom visitLiteralAtom(FlaskParser.LiteralAtomContext ctx) {
        return visitLiteral(ctx.literal());
    }

    @Override
    public Atom visitParenAtom(FlaskParser.ParenAtomContext ctx) {
        return (Atom) visit(ctx.expression());
    }

    @Override
    public Atom visitObjectAtom(FlaskParser.ObjectAtomContext ctx) {
        return (Atom) visit(ctx.objectLiteral());
    }

    @Override
    public Atom visitArrayAtom(FlaskParser.ArrayAtomContext ctx) {
        return (Atom) visit(ctx.arrayLiteral());
    }

    @Override
    public Atom visitListComprehensionAtom(FlaskParser.ListComprehensionAtomContext ctx) {
        return (Atom) visit(ctx.listComprehension());
    }

    @Override
    public Postfix visitMemberAccess(FlaskParser.MemberAccessContext ctx) {
        return new MemberAccess(ctx.IDENTIFIER().getText());
    }

    @Override
    public Postfix visitIndexAccess(FlaskParser.IndexAccessContext ctx) {
        Expression indexExpression = visitExpression(ctx.expression());
        String propertyName = extractPropertyNameFromIndex(indexExpression);

        String objectName = objectNameStack.isEmpty() ? null : objectNameStack.peek();

        boolean isInsideObjectLiteral = isInsideObjectLiteralContext(ctx);

        if (objectName != null && propertyName != null && !isInsideObjectLiteral) {
            Main.semanticError.getE3().check_E3(objectName, propertyName, ctx.getStart().getLine());

        }

        return new IndexAccess(indexExpression);
    }
    private boolean isInsideObjectLiteralContext(FlaskParser.IndexAccessContext ctx) {
        // نبحث في الأباء إذا كنا داخل ObjectLiteral
        ParseTree parent = ctx.getParent();
        while (parent != null) {
            if (parent instanceof FlaskParser.ObjectLiteralContext) {
                return true;
            }
            if (parent instanceof FlaskParser.PairContext) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }
    private String extractPropertyNameFromIndex(Expression expr) {
        if (expr == null) {
            return null;
        }

        Comparison comparison = expr.getComparison();
        if (comparison == null) {
            return null;
        }

        LogicalOR firstOr = comparison.getFirst();
        if (firstOr == null) {
            return null;
        }

        List<LogicalAnd> orTerms = firstOr.getRest();
        if (orTerms == null || orTerms.isEmpty()) {
            return null;
        }

        for (LogicalAnd logicalAnd : orTerms) {
            String result = extractStringFromLogicalAnd(logicalAnd);
            if (result != null) {
                return result;
            }
        }

        return null;
    }

    @Override
    public Postfix visitCall(FlaskParser.CallContext ctx) {
        ArgumentList argumentList = null;
        if (ctx.argumentList() != null) {
            argumentList = (ArgumentList) visit(ctx.argumentList());
        }
        return new Call(argumentList);
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
    public AssignmentStatement visitAssignmentStatement(FlaskParser.AssignmentStatementContext ctx) {
        Primary left = visitPrimary(ctx.primary());
        String leftName = extractObjectNameFromPrimary(left);

        if (leftName != null) {
            objectStack.push(leftName);
        }

        Expression right = (Expression) visit(ctx.expression());

        if (leftName != null) {
            objectStack.pop();
        }

        String rightName = extractIdentifierFromExpression(right);
        if (leftName != null && rightName != null) {
            E3_symbolTable e3 = Main.semanticError.getE3();

            e3.copyProperties(rightName, leftName);

            objectNameStack.push(leftName);
            currentObjectName = leftName;
        }

        return new AssignmentStatement(left, right);
    }
    private String extractIdentifierFromExpression(Expression expr) {
        if (expr == null) return null;
        Comparison comparison = expr.getComparison();
        if (comparison == null) return null;
        LogicalOR firstOr = comparison.getFirst();
        if (firstOr == null) return null;
        List<LogicalAnd> orTerms = firstOr.getRest();
        if (orTerms == null || orTerms.isEmpty()) return null;

        for (LogicalAnd logicalAnd : orTerms) {
            List<Additive> additives = logicalAnd.getAdditives();
            if (additives != null) {
                for (Additive additive : additives) {
                    List<Multiplicative> multiplicatives = additive.getMultiplicatives();
                    if (multiplicatives != null) {
                        for (Multiplicative multi : multiplicatives) {
                            List<Unary> unaries = multi.getUnaryList();
                            if (unaries != null) {
                                for (Unary unary : unaries) {
                                    Primary primary = unary.getPrimary();
                                    if (primary != null && primary.getAtom() instanceof IdentifierAtom) {
                                        return ((IdentifierAtom) primary.getAtom()).getValue();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    private String extractObjectNameFromPrimary(Primary primary) {
        if (primary != null && primary.getAtom() instanceof IdentifierAtom) {
            return ((IdentifierAtom) primary.getAtom()).getValue();
        }
        return null;
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
    private ObjectLiteral findObjectLiteralInExpression(Expression expr) {
        if (expr == null) return null;
        Comparison comp = expr.getComparison();
        if (comp == null) return null;
        LogicalOR firstOr = comp.getFirst();
        if (firstOr == null) return null;
        List<LogicalAnd> orTerms = firstOr.getRest();
        if (orTerms == null) return null;

        for (LogicalAnd logicalAnd : orTerms) {
            List<Additive> additives = logicalAnd.getAdditives();
            if (additives != null) {
                for (Additive additive : additives) {
                    List<Multiplicative> multis = additive.getMultiplicatives();
                    if (multis != null) {
                        for (Multiplicative multi : multis) {
                            List<Unary> unaries = multi.getUnaryList();
                            if (unaries != null) {
                                for (Unary unary : unaries) {
                                    Primary primary = unary.getPrimary();
                                    if (primary != null && primary.getAtom() instanceof ObjectLiteral) {
                                        return (ObjectLiteral) primary.getAtom();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
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

    // ==================== كلاس مساعد ====================
    private static class RenderTemplateInfo {
        String templatePath;

        RenderTemplateInfo(String templatePath) {
            this.templatePath = templatePath;
        }
    }
}