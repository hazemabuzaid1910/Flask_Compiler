package generator;

import AST.flask.*;
import AST.html.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Generator {

    private final Path repoRoot = Path.of("").toAbsolutePath().normalize();
    private final Path projectDir = repoRoot.resolve("project");
    private final Path outputDir = repoRoot.resolve("output");
    private final Path templatesDir = outputDir.resolve("templates");
    private final Path compilerOutputDir = repoRoot.resolve("compiler_output");

    private final Map<String, Object> globalContext = new LinkedHashMap<>();
    private final Map<String, FunctionDef> functions = new LinkedHashMap<>();
    private final List<TemplateTask> generatedTemplates = new ArrayList<>();
    private final StringBuilder generationLog = new StringBuilder();

    public void generate(Program program) throws IOException {
        generationLog.setLength(0);
        generatedTemplates.clear();
        globalContext.clear();
        functions.clear();

        log("Generator started: " + LocalDateTime.now());

        collectProgramData(program);
        generateTemplatesFromFunctions();
        saveFiles(program);

        log("Generator finished.");
    }

    private void collectProgramData(Program program) {
        if (program == null || program.getElements() == null) {
            log("Program AST is empty.");
            return;
        }

        for (Object element : program.getElements()) {
            System.out.println(
                    "PROGRAM ELEMENT = " + element.getClass().getName()
            );
            if (!(element instanceof Statement stmt)) {
                continue;
            }

            if (stmt instanceof StmtAssign assignStmt) {
                AssignmentStatement assign = assignStmt.getAssignmentStatement();
                if (assign == null) continue;

                Expression leftExpression = assign.getLeft();

                Primary leftPrimary = null;

                if (leftExpression != null &&
                        leftExpression.getLeft() instanceof Primary p) {
                    leftPrimary = p;
                }

                String leftName = extractPrimaryIdentifier(leftPrimary);
                if (leftName == null) continue;

                Object value = evaluateExpression(assign.getRight(), globalContext);
                globalContext.put(leftName, value);
                log("Captured global variable: " + leftName);
            } else if (stmt instanceof StmtFunction fnStmt) {
                FunctionDef functionDef = fnStmt.getFunctionDef();
                if (functionDef != null && functionDef.getFunc_name() != null) {
                    functions.put(functionDef.getFunc_name(), functionDef);
                }
            } else if (stmt instanceof StmtDecorator decoratorStmt) {
                DecoratorStatement dec = decoratorStmt.getDecoratorStatement();
                if (dec != null && dec.getFunctionDef() != null && dec.getFunctionDef().getFunc_name() != null) {
                    functions.put(dec.getFunctionDef().getFunc_name(), dec.getFunctionDef());
                }
            }
        }

        log("Functions discovered: " + functions.keySet());
    }

    private void generateTemplatesFromFunctions() {
        for (Map.Entry<String, FunctionDef> entry : functions.entrySet()) {
            TemplateTask task = executeFunction(entry.getKey(), entry.getValue(), new LinkedHashMap<>(globalContext));
            if (task != null) {
                generatedTemplates.add(task);
                log("Template generation task created: " + task.templatePath + " from function " + entry.getKey());
            }
        }
    }

    private TemplateTask executeFunction(String functionName, FunctionDef functionDef, Map<String, Object> localContext) {
        if (functionDef == null || functionDef.getBlock() == null) return null;
        return executeBlock(functionName, functionDef.getBlock(), localContext);
    }

    private TemplateTask executeBlock(String functionName, Block block, Map<String, Object> localContext) {
        if (block == null || block.getStatements() == null) return null;

        for (Statement statement : block.getStatements()) {
            if (statement instanceof StmtAssign stmtAssign) {
                AssignmentStatement assignment = stmtAssign.getAssignmentStatement();
                if (assignment != null) {
                    Object value = evaluateExpression(assignment.getRight(), localContext);
                    applyAssignment(assignment.getLeft(), value, localContext);
                }
            } else if (statement instanceof StmtIf stmtIf) {
                AST.flask.IfStatement ifStatement = stmtIf.getIfStatement();
                if (ifStatement != null) {
                    Object condition = evaluateExpression(ifStatement.getExpression(), localContext);
                    if (isTruthy(condition)) {
                        TemplateTask nested = executeBlock(functionName, ifStatement.getBlock(), localContext);
                        if (nested != null) return nested;
                    } else if (ifStatement.getElseClause() != null) {
                        TemplateTask nested = executeBlock(functionName, ifStatement.getElseClause().getBlock(), localContext);
                        if (nested != null) return nested;
                    }
                }
            } else if (statement instanceof StmtFor stmtFor) {
                AST.flask.ForStatement forStatement = stmtFor.getForStatement();
                if (forStatement != null) {
                    Object iterable = evaluateExpression(forStatement.getExpression(), localContext);
                    if (iterable instanceof List<?> list) {
                        for (Object item : list) {
                            localContext.put(forStatement.getObjectName(), item);
                            TemplateTask nested = executeBlock(functionName, forStatement.getBlock(), localContext);
                            if (nested != null) return nested;
                        }
                    }
                }
            } else if (statement instanceof StmtReturn stmtReturn) {
                ReturnStatement returnStatement = stmtReturn.getReturnStatement();
                TemplateTask templateTask = buildTemplateTask(functionName, returnStatement, localContext);
                if (templateTask != null) return templateTask;
            }
        }

        return null;
    }

    private TemplateTask buildTemplateTask(String functionName,
                                           ReturnStatement returnStatement,
                                           Map<String, Object> localContext) {

        if (returnStatement == null || !returnStatement.hasHtmlTemplate()) {
            return null;
        }

        RenderCallInfo callInfo =
                extractRenderCallInfo(returnStatement.getExpression(), localContext);

        if (callInfo == null || callInfo.templatePath == null) {
            return null;
        }

        for (Map.Entry<String, Object> entry : callInfo.context.entrySet()) {

            if ("product".equals(entry.getKey()) && entry.getValue() == null) {

                Object products = localContext.get("products");

                if (!(products instanceof List<?>)) {
                    products = globalContext.get("products");
                }

                if (!(products instanceof List<?>)) {
                    products = globalContext.get("products_array");
                }

                if (products instanceof List<?> list && !list.isEmpty()) {
                    entry.setValue(list.get(0));
                }
            }
        }

        Map<String,Object> finalContext = new LinkedHashMap<>();

        finalContext.putAll(globalContext);
        finalContext.putAll(localContext);
        finalContext.putAll(callInfo.context);
        System.out.println("FINAL CONTEXT:");
        for (Map.Entry<String,Object> e : finalContext.entrySet()) {
            System.out.println(e.getKey() + " = " + e.getValue());
        }
        return new TemplateTask(
                functionName,
                callInfo.templatePath,
                returnStatement.getHtmlNode(),
                finalContext
        );
    }
    private RenderCallInfo extractRenderCallInfo(
            Expression expression,
            Map<String, Object> context
    ) {

        if (expression == null) {
            return null;
        }

        Object left = expression.getLeft();

        if (!(left instanceof Primary primary)) {
            return null;
        }


        if (!(primary.getAtom() instanceof IdentifierAtom idAtom)) {
            return null;
        }


        if (!"render_template".equals(idAtom.getValue())) {
            return null;
        }


        for (Postfix postfix : primary.getPostfixes()) {

            if (!(postfix instanceof Call call)) {
                continue;
            }


            ArgumentList args = call.getArgumentList();

            if (args == null ||
                    args.getArguments() == null ||
                    args.getArguments().isEmpty()) {

                return null;
            }


            RenderCallInfo info = new RenderCallInfo();

            List<Argument> arguments = args.getArguments();


            // أول argument هو اسم القالب
            Argument firstArg = arguments.get(0);

            if (firstArg instanceof ArgExpression argExpression) {

                Object value =
                        evaluateExpression(
                                argExpression.getExpression(),
                                context
                        );

                info.templatePath =
                        value == null ? null : value.toString();
            }


            // باقي arguments مثل product=...
            for (int i = 1; i < arguments.size(); i++) {

                Argument argument = arguments.get(i);


                if (argument instanceof ArgAssignment assignment) {

                    Object value =
                            evaluateExpression(
                                    assignment.getExpression(),
                                    context
                            );


                    info.context.put(
                            assignment.getIdentifier(),
                            value
                    );
                }
            }


            return info;
        }


        return null;
    }


    private Object evaluateExpression(
            Expression expression,
            Map<String, Object> context
    ) {

        if (expression == null) {
            return null;
        }


        Object leftValue =
                evaluateValue(
                        expression.getLeft(),
                        context
                );


        // تعبير بسيط مثل:
        // DATA_FILE
        // "hello"
        if (expression.getOperator() == null) {
            return leftValue;
        }


        Object rightValue =
                evaluateValue(
                        expression.getRight(),
                        context
                );


        String op = expression.getOperator();


        return switch (op) {

            case "==" ->
                    Objects.equals(leftValue, rightValue);

            case "!=" ->
                    !Objects.equals(leftValue, rightValue);

            case "+" ->
                    applyArithmetic(leftValue, rightValue, op);

            case "-" ->
                    applyArithmetic(leftValue, rightValue, op);

            case "*" ->
                    applyArithmetic(leftValue, rightValue, op);

            case "/" ->
                    applyArithmetic(leftValue, rightValue, op);

            default ->
                    null;
        };
    }


    private Object evaluateLogicalAnd(LogicalAnd logicalAnd, Map<String, Object> context) {
        if (logicalAnd == null || logicalAnd.getAdditives() == null || logicalAnd.getAdditives().isEmpty()) {
            return null;
        }

        Object result = evaluateAdditive(logicalAnd.getAdditives().get(0), context);
        for (int i = 1; i < logicalAnd.getAdditives().size(); i++) {
            result = isTruthy(result) && isTruthy(evaluateAdditive(logicalAnd.getAdditives().get(i), context));
        }

        return result;
    }

    private Object evaluateAdditive(Additive additive, Map<String, Object> context) {
        if (additive == null || additive.getMultiplicatives() == null || additive.getMultiplicatives().isEmpty()) {
            return null;
        }

        Object result = evaluateMultiplicative(additive.getMultiplicatives().get(0), context);
        List<String> operators = additive.getOperator();

        for (int i = 1; i < additive.getMultiplicatives().size(); i++) {
            Object right = evaluateMultiplicative(additive.getMultiplicatives().get(i), context);
            String op = (operators != null && i - 1 < operators.size()) ? operators.get(i - 1) : "+";
            result = applyArithmetic(result, right, op);
        }

        return result;
    }

    private Object evaluateMultiplicative(Multiplicative multiplicative, Map<String, Object> context) {
        if (multiplicative == null || multiplicative.getUnaryList() == null || multiplicative.getUnaryList().isEmpty()) {
            return null;
        }

        Object result = evaluateUnary(multiplicative.getUnaryList().get(0), context);
        List<String> operators = multiplicative.getOperator();

        for (int i = 1; i < multiplicative.getUnaryList().size(); i++) {
            Object right = evaluateUnary(multiplicative.getUnaryList().get(i), context);
            String op = (operators != null && i - 1 < operators.size()) ? operators.get(i - 1) : "*";
            result = applyArithmetic(result, right, op);
        }

        return result;
    }

    private Object evaluateUnary(Unary unary, Map<String, Object> context) {
        if (unary == null) return null;
        return evaluatePrimary(unary.getPrimary(), context);
    }

    private Object evaluatePrimary(Primary primary, Map<String, Object> context) {
        if (primary == null) return null;
        System.out.println(
                "ATOM = " + primary.getAtom()
        );

        System.out.println(
                "POSTFIXES = " + primary.getPostfixes()
        );
        Object currentValue = evaluateAtom(primary.getAtom(), context);
        System.out.println("PRIMARY ATOM = " + currentValue);

        System.out.println(
                "POSTFIX COUNT = " +
                        (primary.getPostfixes() == null ? "null" : primary.getPostfixes().size())
        );
        if (primary.getPostfixes() == null) {
            return currentValue;
        }

        for (Postfix postfix : primary.getPostfixes()) {
            System.out.println(
                    "POSTFIX CLASS = " + postfix.getClass().getName()
            );
            if (postfix instanceof MemberAccess memberAccess) {
                String member = memberAccess.getValue();
                if (currentValue instanceof SymbolName symbolName) {
                    currentValue = new SymbolName(symbolName.name + "." + member);
                } else if (currentValue instanceof Map<?, ?> map) {
                    currentValue = map.get(member);
                } else {
                    currentValue = null;
                }
            } else if (postfix instanceof IndexAccess indexAccess) {
                Object index = evaluateExpression(indexAccess.getIndexExpression(), context);
                currentValue = resolveIndex(currentValue, index);
            }else if (postfix instanceof Call call) {

                System.out.println("ENTER CALL BLOCK");

                System.out.println(
                        "CURRENT VALUE CLASS = " +
                                currentValue.getClass().getName()
                );

                if (currentValue instanceof SymbolName symbolName) {

                    System.out.println(
                            "FUNCTION = " + symbolName.name
                    );

                    currentValue = executeCall(
                            symbolName.name,
                            call,
                            context
                    );

                    System.out.println(
                            "CALL RESULT = " + currentValue
                    );

                } else {
                    System.out.println("NOT SYMBOL NAME");
                    currentValue = null;
                }
            }
        }

        return currentValue;
    }

    private Object evaluateAtom(Atom atom, Map<String, Object> context) {
        if (atom == null) return null;

        if (atom instanceof Literal literal) {
            if (literal.getType() == LiteralType.NONE) return null;
            return literal.getValue();
        }

        if (atom instanceof IdentifierAtom identifierAtom) {
            String name = identifierAtom.getValue();
            if (context.containsKey(name)) return context.get(name);
            if (globalContext.containsKey(name)) return globalContext.get(name);
            return new SymbolName(name);
        }

        if (atom instanceof ObjectLiteral objectLiteral) {
            Map<String, Object> map = new LinkedHashMap<>();
            if (objectLiteral.getPairList() != null) {
                for (Pair pair : objectLiteral.getPairList()) {
                    map.put(pair.getKey(), evaluateExpression(pair.getValue(), context));
                }
            }
            return map;
        }

        if (atom instanceof ArrayLiteral arrayLiteral) {
            List<Object> list = new ArrayList<>();
            if (arrayLiteral.getExpressions() != null) {
                for (Expression expression : arrayLiteral.getExpressions()) {
                    list.add(evaluateExpression(expression, context));
                }
            }
            return list;
        }

        if (atom instanceof Expression nestedExpression) {
            return evaluateExpression(nestedExpression, context);
        }

        return null;
    }

    private Object executeCall(String functionName, Call call, Map<String, Object> context) {
        List<Object> args = evaluateCallArguments(call, context);
        System.out.println("EXECUTE CALL = " + functionName);
        if ("len".equals(functionName)) {
            if (!args.isEmpty() && args.get(0) instanceof Collection<?> collection) {
                return collection.size();
            }
            if (!args.isEmpty() && args.get(0) instanceof Map<?, ?> map) {
                return map.size();
            }
            return 0;
        }

        if ("load_products".equals(functionName)) {
            Object productsArray = globalContext.get("products_array");
            if (productsArray != null) return productsArray;
            Object dataFile = globalContext.get("DATA_FILE");
            if (dataFile instanceof String path) {
                return loadJsonFromProject(path);
            }
            return null;
        }

        if ("open".equals(functionName)) {
            if (!args.isEmpty() && args.get(0) != null) {
                return new OpenFileHandle(args.get(0).toString());
            }
            return null;
        }

        if ("json.load".equals(functionName)) {
            if (!args.isEmpty() && args.get(0) instanceof OpenFileHandle handle) {
                return loadJsonFromProject(handle.path);
            }
            return null;
        }
        System.out.println("AVAILABLE FUNCTIONS = " + functions.keySet());
        FunctionDef functionDef = functions.get(functionName);
        if (functionDef != null) {
            Object direct = executeFunctionDirect(functionDef, new LinkedHashMap<>(context));
            if (direct != null) return direct;
        }

        return null;
    }

    private List<Object> evaluateCallArguments(Call call, Map<String, Object> context) {
        List<Object> args = new ArrayList<>();
        if (call == null || call.getArgumentList() == null || call.getArgumentList().getArguments() == null) {
            return args;
        }

        for (Argument argument : call.getArgumentList().getArguments()) {
            if (argument instanceof ArgExpression argExpression) {
                args.add(evaluateExpression(argExpression.getExpression(), context));
            } else if (argument instanceof ArgAssignment argAssignment) {
                args.add(evaluateExpression(argAssignment.getExpression(), context));
            }
        }

        return args;
    }

    private Object executeFunctionDirect(FunctionDef functionDef, Map<String, Object> localContext) {
        if (functionDef == null || functionDef.getBlock() == null || functionDef.getBlock().getStatements() == null) {
            return null;
        }

        for (Statement statement : functionDef.getBlock().getStatements()) {
            if (statement instanceof StmtAssign stmtAssign) {
                AssignmentStatement assignment = stmtAssign.getAssignmentStatement();
                if (assignment != null) {
                    Object value = evaluateExpression(assignment.getRight(), localContext);
                    applyAssignment(assignment.getLeft(), value, localContext);
                }
            } else if (statement instanceof StmtReturn stmtReturn) {
                ReturnStatement returnStatement = stmtReturn.getReturnStatement();
                if (returnStatement != null) {
                    return evaluateExpression(returnStatement.getExpression(), localContext);
                }
            }
            else if (statement instanceof StmtWith stmtWith) {

                WithStatement withStatement =
                        stmtWith.getWithStatement();

                if(withStatement != null){

                    TemplateTask ignored =
                            executeBlock(
                                    "",
                                    withStatement.getBlock(),
                                    localContext
                            );

                }
            }
        }

        return null;
    }

    private Object resolveIndex(Object value, Object index) {

        if (value instanceof Map<?, ?> map) {
            return map.get(index == null ? null : index.toString());
        }

        if (value instanceof List<?> list) {

            for(Object item : list){

                if(item instanceof Map<?,?> map){

                    Object objId = map.get("id");

                    if(objId != null && index != null &&
                            objId.toString().equals(index.toString())){
                        return item;
                    }
                }
            }


            if(index instanceof Number number){

                int i = number.intValue();

                if(i >=0 && i < list.size())
                    return list.get(i);
            }
        }

        return null;
    }

    private void applyAssignment(
            Expression left,
            Object value,
            Map<String,Object> localContext
    ) {

        if (left == null) {
            return;
        }


        Primary primary = null;

        if (left.getLeft() instanceof Primary p) {
            primary = p;
        }


        if (primary == null) {
            return;
        }


        String baseName = extractPrimaryIdentifier(primary);

        if (baseName == null) {
            return;
        }


        if (primary.getPostfixes() == null ||
                primary.getPostfixes().isEmpty()) {

            localContext.put(baseName, value);
            return;
        }


        Object container = localContext.get(baseName);

        if (container == null) {
            container = globalContext.get(baseName);
        }


        if (container == null) {
            localContext.put(baseName, value);
            return;
        }


        Object current = container;

        List<Postfix> postfixes = primary.getPostfixes();


        for (int i = 0; i < postfixes.size(); i++) {

            Postfix postfix = postfixes.get(i);

            boolean last = (i == postfixes.size() - 1);


            if (postfix instanceof MemberAccess memberAccess) {

                String key = memberAccess.getValue();


                if (current instanceof Map<?, ?> mapRaw) {

                    @SuppressWarnings("unchecked")
                    Map<String,Object> map =
                            (Map<String,Object>) mapRaw;


                    if (last) {
                        map.put(key, value);
                    }
                    else {
                        current = map.get(key);
                    }
                }

            }
            else if (postfix instanceof IndexAccess indexAccess) {

                Object keyOrIndex =
                        evaluateExpression(
                                indexAccess.getIndexExpression(),
                                localContext
                        );


                if (current instanceof Map<?, ?> mapRaw) {

                    @SuppressWarnings("unchecked")
                    Map<String,Object> map =
                            (Map<String,Object>) mapRaw;


                    String key =
                            keyOrIndex == null
                                    ? null
                                    : keyOrIndex.toString();


                    if (last) {
                        map.put(key, value);
                    }
                    else {
                        current = map.get(key);
                    }

                }
                else if (current instanceof List<?> listRaw &&
                        keyOrIndex instanceof Number number) {


                    @SuppressWarnings("unchecked")
                    List<Object> list =
                            (List<Object>) listRaw;


                    int idx = number.intValue();


                    if (idx >= 0 && idx < list.size()) {

                        if (last) {
                            list.set(idx, value);
                        }
                        else {
                            current = list.get(idx);
                        }
                    }
                }
            }
        }


        localContext.put(baseName, container);
    }

    private String extractPrimaryIdentifier(Primary primary) {

        if (primary == null) {
            return null;
        }

        if (primary.getAtom() instanceof IdentifierAtom identifierAtom) {
            return identifierAtom.getValue();
        }

        return null;
    }

    private boolean compareValues(Object left, Object right, CompOp op) {
        if (op == null) return false;
        return switch (op) {
            case EQUAL -> Objects.equals(left, right);
            case NOT_EQUAL -> !Objects.equals(left, right);
            case LESS -> asDouble(left) < asDouble(right);
            case GREATER -> asDouble(left) > asDouble(right);
        };
    }

    private Object applyArithmetic(Object left, Object right, String op) {
        if ("+".equals(op)) {
            if (left instanceof String || right instanceof String) {
                return String.valueOf(left) + String.valueOf(right);
            }
            if (left instanceof Number || right instanceof Number) {
                return asDouble(left) + asDouble(right);
            }
            return null;
        }

        if ("-".equals(op)) {
            return asDouble(left) - asDouble(right);
        }

        if ("*".equals(op)) {
            return asDouble(left) * asDouble(right);
        }

        if ("/".equals(op)) {
            double d = asDouble(right);
            if (d == 0) return null;
            return asDouble(left) / d;
        }

        return null;
    }

    private double asDouble(Object value) {
        if (value instanceof Number number) return number.doubleValue();
        if (value == null) return 0;
        try {
            return Double.parseDouble(value.toString());
        } catch (Exception ignored) {
            return 0;
        }
    }

    private boolean isTruthy(Object value) {
        if (value == null) return false;
        if (value instanceof Boolean b) return b;
        if (value instanceof Number n) return n.doubleValue() != 0;
        if (value instanceof String s) return !s.isEmpty() && !"false".equalsIgnoreCase(s) && !"none".equalsIgnoreCase(s);
        if (value instanceof Collection<?> c) return !c.isEmpty();
        if (value instanceof Map<?, ?> m) return !m.isEmpty();
        return true;
    }

    private Object loadJsonFromProject(String relativePath) {
        try {
            Path filePath = projectDir.resolve(relativePath).normalize();
            if (!Files.exists(filePath)) {
                log("JSON file not found: " + filePath);
                return null;
            }
            String content = Files.readString(filePath, StandardCharsets.UTF_8);
            return new JsonParser(content).parse();
        } catch (Exception e) {
            log("Failed to read JSON data: " + e.getMessage());
            return null;
        }
    }

    private void saveFiles(Program program) throws IOException {
        Files.createDirectories(outputDir);
        Files.createDirectories(templatesDir);
        Files.createDirectories(compilerOutputDir);

        writeGeneratedHtmlFiles();
        copySupportFiles();
        writeCompilerOutputFiles(program);
    }

    private void writeGeneratedHtmlFiles() throws IOException {
        Set<String> written = new HashSet<>();

        for (TemplateTask task : generatedTemplates) {
            if (task.htmlNode == null || task.templatePath == null) continue;

            String normalizedTemplateName = normalizeTemplateName(task.templatePath);
            if (written.contains(normalizedTemplateName)) continue;

            String rendered = renderHtmlNode(task.htmlNode, task.context);
            Files.writeString(templatesDir.resolve(normalizedTemplateName), rendered, StandardCharsets.UTF_8);
            written.add(normalizedTemplateName);
            log("Generated HTML: output/" + normalizedTemplateName);
        }
    }

    private void copySupportFiles() throws IOException {
        copyIfExists(projectDir.resolve("app.py"), outputDir.resolve("app.py"));
        copyIfExists(projectDir.resolve("style.css"), outputDir.resolve("style.css"));
        copyIfExists(projectDir.resolve("script.js"), outputDir.resolve("script.js"));
    }

    private void copyIfExists(Path source, Path destination) throws IOException {
        if (Files.exists(source)) {
            Files.copy(source, destination, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
            log("Copied support file: " + outputDir.relativize(destination));
        }
    }

    private void writeCompilerOutputFiles(Program program) throws IOException {


        List<Map<String, String>> jinjaAstEntries = new ArrayList<>();
        for (TemplateTask task : generatedTemplates) {
            Map<String, String> item = new LinkedHashMap<>();
            item.put("template", task.templatePath);
            item.put("ast", task.htmlNode == null ? "" : task.htmlNode.toString());
            jinjaAstEntries.add(item);
        }

        String jinjaAstJson = "{\n  \"ast_jinja\": " + toJson(jinjaAstEntries) + "\n}";

        String semanticContent = "No Semantic Error";
        Path semanticFile = repoRoot.resolve("Result").resolve("Semantic.txt");
        if (Files.exists(semanticFile)) {
            semanticContent = Files.readString(semanticFile, StandardCharsets.UTF_8);
        }

        Files.writeString(compilerOutputDir.resolve("ast_jinja.json"), jinjaAstJson, StandardCharsets.UTF_8);
        Files.writeString(compilerOutputDir.resolve("semantic_report.txt"), semanticContent, StandardCharsets.UTF_8);
        Files.writeString(compilerOutputDir.resolve("generation_log.txt"), generationLog.toString(), StandardCharsets.UTF_8);

        log("Compiler output files written.");
    }

    private String renderHtmlNode(HtmlNode node, Map<String, Object> context) {
        if (node == null || node.getHtmlContents() == null) return "";

        Deque<Map<String, Object>> scopes = new ArrayDeque<>();
        scopes.push(context == null ? new LinkedHashMap<>() : new LinkedHashMap<>(context));

        return renderContents(node.getHtmlContents(), scopes, 0);
    }

    private String renderContents(List<HtmlContent> contents,
                                  Deque<Map<String, Object>> scopes,
                                  int indent) {

        StringBuilder html = new StringBuilder();

        for (HtmlContent content : contents) {
            html.append(renderContent(content, scopes, indent));

            if (content instanceof HtmlElement) {
                html.append("\n");
            }
        }

        return html.toString();
    }

    private String renderContent(HtmlContent content,
                                 Deque<Map<String, Object>> scopes,
                                 int indent) {
        if (content == null) return "";

        if (content instanceof HtmlElement element) {
            return "\n" +
                    "    ".repeat(indent) +
                    renderHtmlTag(element.getHtmlTag(), scopes, indent);
        }
        if (content instanceof Text text) {
            if (text.getText() == null) return "";
            return String.join("", text.getText());
        }

        if (content instanceof IdentifierExpression identifierExpression) {
            return identifierExpression.getIdentifier();
        }

        if (content instanceof ExpressionJinja expressionJinja) {
            Object value = resolveDottedName(expressionJinja.getJinjaExpression().getDottedName(), scopes);
            return value == null ? "" : String.valueOf(value);
        }

        if (content instanceof ForBlock forBlock) {
            System.out.println(
                    "FOR VARIABLE = "
                            + forBlock.getIterableName()
            );
            Object iterable = resolveVariable(forBlock.getIterableName(), scopes);
            if (!(iterable instanceof List<?> list)) return "";
            StringBuilder out = new StringBuilder();
            for (Object item : list) {
                Map<String, Object> loopScope = new LinkedHashMap<>();
                loopScope.put(forBlock.getLoopVariable(), item);
                scopes.push(loopScope);
                out.append(renderContents(forBlock.getHtmlContents(), scopes, indent + 1));
                scopes.pop();
            }
            return out.toString();
        }

        if (content instanceof IfBlock ifBlock) {
            Object condition = resolveVariable(ifBlock.getConditionVariable(), scopes);
            if (isTruthy(condition)) {
                return renderContents(ifBlock.getHtmlContents(), scopes, indent + 1);            }
            return "";
        }

        if (content instanceof StatementJinja statementJinja) {
            return renderContent(statementJinja.getJinjaStatement(), scopes, indent);
        }

        return "";
    }

    private String renderHtmlTag(HtmlTag tag,
                                 Deque<Map<String, Object>> scopes,
                                 int indent) {
        if (tag instanceof HtmlPairTag pairTag) {
            String name = pairTag.getHtmlTag().getTagName();
            String attributes = renderAttributes(pairTag.getHtmlAttributes(), scopes);
            String body = renderContents(pairTag.getHtmlContents(), scopes, indent + 1);
            return "<" + name + attributes + ">" + body + "</" + name + ">";
        }

        if (tag instanceof HtmlSingleTagSelfClosing selfClosing) {
            String name = selfClosing.getTagName().getTagName();
            String attributes = renderAttributes(selfClosing.getHtmlAttributes(), scopes);
            return "<" + name + attributes + "/>";
        }

        if (tag instanceof HtmlSingleTagOpening opening) {
            String name = opening.getTagName().getTagName();
            String attributes = renderAttributes(opening.getHtmlAttributes(), scopes);
            return "<" + name + attributes + ">";
        }

        return "";
    }

    private String renderAttributes(List<HtmlAttribute> attributes, Deque<Map<String, Object>> scopes) {
        if (attributes == null || attributes.isEmpty()) return "";

        StringBuilder result = new StringBuilder();
        for (HtmlAttribute attribute : attributes) {
            if (attribute == null || attribute.getAttributeKey() == null || attribute.getAttributeValue() == null) continue;
            String key = attribute.getAttributeKey().getAttributeKey();
            String rawValue = attribute.getAttributeValue().getValue();
            String value = interpolateJinjaInText(rawValue, scopes);
            result.append(" ").append(key).append("=");
            if (value == null) {
                result.append("\"\"");
            } else if ((value.startsWith("\"") && value.endsWith("\"")) || (value.startsWith("'") && value.endsWith("'"))) {
                result.append(value);
            } else {
                result.append("\"").append(value).append("\"");
            }
            System.out.println("RAW  = " + rawValue);
            System.out.println("AFTER= " + value);
        }

        return result.toString();
    }

    private String interpolateJinjaInText(String rawText, Deque<Map<String, Object>> scopes) {
        if (rawText == null) return "";

        Pattern pattern = Pattern.compile("\\{\\{\\s*([a-zA-Z_][a-zA-Z0-9_\\.]*)\\s*}}");
        Matcher matcher = pattern.matcher(rawText);
        StringBuffer sb = new StringBuffer();

        while (matcher.find()) {
            String expression = matcher.group(1).trim();
            String[] parts = expression.split("\\.");
            AST.flask.DottedName dottedName = new AST.flask.DottedName(parts[0], parts.length > 1 ? Arrays.asList(parts).subList(1, parts.length) : List.of());
            Object value = resolveDottedName(dottedName, scopes);
            matcher.appendReplacement(sb, Matcher.quoteReplacement(value == null ? "" : String.valueOf(value)));
        }
        matcher.appendTail(sb);

        return sb.toString();
    }

    private Object resolveDottedName(AST.flask.DottedName dottedName, Deque<Map<String, Object>> scopes) {
        if (dottedName == null) return null;

        Object value = resolveVariable(dottedName.getFirst(), scopes);
        if (dottedName.getRest() == null) return value;

        for (String key : dottedName.getRest()) {
            if (value instanceof Map<?, ?> map) {
                value = map.get(key);
            } else {
                return null;
            }
        }
        return value;
    }

    private Object resolveVariable(String name, Deque<Map<String, Object>> scopes) {
        if (name == null) return null;

        for (Map<String, Object> scope : scopes) {
            if (scope.containsKey(name)) return scope.get(name);
        }

        return globalContext.get(name);
    }

    private String normalizeTemplateName(String templatePath) {
        String fileName = Path.of(templatePath).getFileName().toString();
        if (fileName.endsWith(".jinja")) {
            return fileName.substring(0, fileName.length() - 6) + ".html";
        }
        return fileName;
    }

    private String escapeJson(String input) {
        if (input == null) return "";
        return input
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r");
    }

    private String toJson(Object value) {
        return toJson(value, 0);
    }

    private String toJson(Object value, int indent) {
        String indentStr = "    ".repeat(indent);
        String nextIndentStr = "    ".repeat(indent + 1);

        if (value == null) {
            return "null";
        }

        if (value instanceof String s) {
            return "\"" + escapeJson(s) + "\"";
        }

        if (value instanceof Number || value instanceof Boolean) {
            return value.toString();
        }

        if (value instanceof Map<?, ?> map) {
            if (map.isEmpty()) {
                return "{}";
            }

            StringBuilder sb = new StringBuilder();
            sb.append("{\n");

            Iterator<? extends Map.Entry<?, ?>> iterator = map.entrySet().iterator();

            while (iterator.hasNext()) {
                Map.Entry<?, ?> entry = iterator.next();

                sb.append(nextIndentStr)
                        .append("\"")
                        .append(escapeJson(String.valueOf(entry.getKey())))
                        .append("\": ")
                        .append(toJson(entry.getValue(), indent + 1));

                if (iterator.hasNext()) {
                    sb.append(",");
                }

                sb.append("\n");
            }

            sb.append(indentStr).append("}");
            return sb.toString();
        }

        if (value instanceof Collection<?> collection) {
            if (collection.isEmpty()) {
                return "[]";
            }

            StringBuilder sb = new StringBuilder();
            sb.append("[\n");

            Iterator<?> iterator = collection.iterator();

            while (iterator.hasNext()) {
                Object item = iterator.next();

                sb.append(nextIndentStr)
                        .append(toJson(item, indent + 1));

                if (iterator.hasNext()) {
                    sb.append(",");
                }

                sb.append("\n");
            }

            sb.append(indentStr).append("]");
            return sb.toString();
        }

        return "\"" + escapeJson(String.valueOf(value)) + "\"";
    }

    private void log(String message) {
        generationLog.append(message).append(System.lineSeparator());
    }

    private static class TemplateTask {
        String functionName;
        String templatePath;
        HtmlNode htmlNode;
        Map<String, Object> context;

        TemplateTask(String functionName, String templatePath, HtmlNode htmlNode, Map<String, Object> context) {
            this.functionName = functionName;
            this.templatePath = templatePath;
            this.htmlNode = htmlNode;
            this.context = context == null ? new LinkedHashMap<>() : new LinkedHashMap<>(context);
        }
    }

    private static class RenderCallInfo {
        String templatePath;
        Map<String, Object> context = new LinkedHashMap<>();
    }

    private static class SymbolName {
        String name;

        SymbolName(String name) {
            this.name = name;
        }
    }

    private static class OpenFileHandle {
        String path;

        OpenFileHandle(String path) {
            this.path = path;
        }
    }

    private static class JsonParser {
        private final String input;
        private int index = 0;

        JsonParser(String input) {
            this.input = input;
        }

        Object parse() {
            skipWhitespace();
            Object value = parseValue();
            skipWhitespace();
            return value;
        }

        private Object parseValue() {
            skipWhitespace();
            if (index >= input.length()) return null;

            char ch = input.charAt(index);
            if (ch == '{') return parseObject();
            if (ch == '[') return parseArray();
            if (ch == '"') return parseString();
            if (ch == 't' || ch == 'f') return parseBoolean();
            if (ch == 'n') return parseNull();
            return parseNumber();
        }

        private Map<String, Object> parseObject() {
            Map<String, Object> map = new LinkedHashMap<>();
            index++; // {
            skipWhitespace();

            if (peek('}')) {
                index++;
                return map;
            }

            while (index < input.length()) {
                skipWhitespace();
                String key = parseString();
                skipWhitespace();
                expect(':');
                skipWhitespace();
                Object value = parseValue();
                map.put(key, value);
                skipWhitespace();

                if (peek(',')) {
                    index++;
                    continue;
                }
                if (peek('}')) {
                    index++;
                    break;
                }
            }

            return map;
        }

        private List<Object> parseArray() {
            List<Object> list = new ArrayList<>();
            index++; // [
            skipWhitespace();

            if (peek(']')) {
                index++;
                return list;
            }

            while (index < input.length()) {
                skipWhitespace();
                list.add(parseValue());
                skipWhitespace();

                if (peek(',')) {
                    index++;
                    continue;
                }
                if (peek(']')) {
                    index++;
                    break;
                }
            }

            return list;
        }

        private String parseString() {
            expect('"');
            StringBuilder sb = new StringBuilder();
            while (index < input.length()) {
                char ch = input.charAt(index++);
                if (ch == '"') break;
                if (ch == '\\') {
                    if (index >= input.length()) break;
                    char esc = input.charAt(index++);
                    switch (esc) {
                        case '"' -> sb.append('"');
                        case '\\' -> sb.append('\\');
                        case '/' -> sb.append('/');
                        case 'b' -> sb.append('\b');
                        case 'f' -> sb.append('\f');
                        case 'n' -> sb.append('\n');
                        case 'r' -> sb.append('\r');
                        case 't' -> sb.append('\t');
                        case 'u' -> {
                            if (index + 4 <= input.length()) {
                                String hex = input.substring(index, index + 4);
                                sb.append((char) Integer.parseInt(hex, 16));
                                index += 4;
                            }
                        }
                        default -> sb.append(esc);
                    }
                } else {
                    sb.append(ch);
                }
            }
            return sb.toString();
        }

        private Object parseBoolean() {
            if (input.startsWith("true", index)) {
                index += 4;
                return true;
            }
            if (input.startsWith("false", index)) {
                index += 5;
                return false;
            }
            return false;
        }

        private Object parseNull() {
            if (input.startsWith("null", index)) {
                index += 4;
            }
            return null;
        }

        private Number parseNumber() {
            int start = index;
            while (index < input.length()) {
                char ch = input.charAt(index);
                if ((ch >= '0' && ch <= '9') || ch == '-' || ch == '+' || ch == '.' || ch == 'e' || ch == 'E') {
                    index++;
                } else {
                    break;
                }
            }
            String number = input.substring(start, index);
            try {
                if (number.contains(".") || number.contains("e") || number.contains("E")) {
                    return Double.parseDouble(number);
                }
                return Long.parseLong(number);
            } catch (Exception e) {
                return 0;
            }
        }

        private void skipWhitespace() {
            while (index < input.length()) {
                char ch = input.charAt(index);
                if (ch == ' ' || ch == '\n' || ch == '\r' || ch == '\t') {
                    index++;
                } else {
                    break;
                }
            }
        }

        private void expect(char expected) {
            if (index < input.length() && input.charAt(index) == expected) {
                index++;
            }
        }

        private boolean peek(char expected) {
            return index < input.length() && input.charAt(index) == expected;
        }
    }
    private Object evaluateValue(
            Object value,
            Map<String,Object> context
    ) {

        if (value == null) {
            return null;
        }


        if (value instanceof Expression expression) {

            return evaluateExpression(
                    expression,
                    context
            );
        }


        if (value instanceof Primary primary) {

            return evaluatePrimary(
                    primary,
                    context
            );
        }


        return value;
    }
}
