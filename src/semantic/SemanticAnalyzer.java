package semantic;

import AST.flask.ArgAssignment;
import AST.flask.ArgExpression;
import AST.flask.Argument;
import AST.flask.ArgumentList;
import AST.flask.ArrayLiteral;
import AST.flask.AssignmentStatement;
import AST.flask.Atom;
import AST.flask.Block;
import AST.flask.Call;
import AST.flask.Decorator;
import AST.flask.DecoratorStatement;
import AST.flask.Expression;
import AST.flask.ForStatement;
import AST.flask.FunctionDef;
import AST.flask.IdentifierAtom;
import AST.flask.IfStatement;
import AST.flask.IndexAccess;
import AST.flask.ImportAlias;
import AST.flask.ImportFrom;
import AST.flask.ImportSimple;
import AST.flask.MemberAccess;
import AST.flask.ObjectLiteral;
import AST.flask.Pair;
import AST.flask.ParamExpression;
import AST.flask.ParamIdentifier;
import AST.flask.ParameterFunction;
import AST.flask.ParameterList;
import AST.flask.Postfix;
import AST.flask.Primary;
import AST.flask.Program;
import AST.flask.ReturnStatement;
import AST.flask.Statement;
import AST.flask.StmtAssign;
import AST.flask.StmtDecorator;
import AST.flask.StmtExpression;
import AST.flask.StmtFor;
import AST.flask.StmtFunction;
import AST.flask.StmtIf;
import AST.flask.StmtReturn;
import AST.flask.StmtWith;
import AST.flask.WithStatement;
import AST.html.ExpressionJinja;
import AST.html.ForBlock;
import AST.html.HtmlAttribute;
import AST.html.HtmlContent;
import AST.html.HtmlElement;
import AST.html.HtmlNode;
import AST.html.HtmlPairTag;
import AST.html.HtmlSingleTagSelfClosing;
import AST.html.HtmlTag;
import AST.html.IfBlock;
import AST.html.StatementJinja;
import MainApp.Error_Type;
import MainApp.Main;
import MainApp.Symantic_Error;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SemanticAnalyzer {

    private static final String UNKNOWN_LOCATION = "unknown";
    private static final Pattern JINJA_VARIABLE = Pattern.compile("\\{\\{\\s*([a-zA-Z_][a-zA-Z0-9_\\.]*)\\s*}}", Pattern.DOTALL);

    private final Map<String, FunctionSignature> functionSignatures = new HashMap<>();
    private final Map<String, Integer> builtinSignatures = new HashMap<>();

    public SemanticAnalyzer() {
        builtinSignatures.put("print", -1);
        builtinSignatures.put("render_template", -1);
        builtinSignatures.put("open", -1);
        builtinSignatures.put("json.load", 1);
    }

    public void analyze(Program program) {
        if (program == null || program.getElements() == null) {
            return;
        }

        collectFunctionSignatures(program.getElements());

        Scope global = new Scope(null, false);
        for (Object element : program.getElements()) {
            if (element instanceof Statement statement) {
                analyzeStatement(statement, global);
            }
        }
    }

    private void collectFunctionSignatures(List<Object> elements) {
        for (Object element : elements) {
            if (!(element instanceof Statement statement)) {
                continue;
            }

            if (statement instanceof StmtFunction stmtFunction) {
                registerFunction(stmtFunction.getFunctionDef());
            } else if (statement instanceof StmtDecorator stmtDecorator) {
                registerFunction(stmtDecorator.getDecoratorStatement().getFunctionDef());
            }
        }
    }

    private void registerFunction(FunctionDef functionDef) {
        String name = functionDef.getFunc_name();
        int count = parameterCount(functionDef.getParameterList());

        if (functionSignatures.containsKey(name)) {
            addError(Error_Type.FUNCTION_DUPLICATION,
                    "Repeat function name " + name,
                    UNKNOWN_LOCATION);
            return;
        }

        functionSignatures.put(name, new FunctionSignature(count));
    }

    private int parameterCount(ParameterList parameterList) {
        if (parameterList == null || parameterList.getParameters() == null) {
            return 0;
        }

        int count = 0;
        for (ParameterFunction parameter : parameterList.getParameters()) {
            if (parameter instanceof ParamIdentifier) {
                count++;
            }
        }
        return count;
    }

    private void analyzeStatement(Statement statement, Scope scope) {
        if (statement instanceof ImportSimple importSimple) {
            if (importSimple.getImportAliases() != null) {
                for (ImportAlias alias : importSimple.getImportAliases()) {
                    declareVariable(scope, alias.getAlias() == null ? alias.getName() : alias.getAlias(), null);
                }
            }
            return;
        }

        if (statement instanceof ImportFrom importFrom) {
            if (importFrom.getImportAliases() != null) {
                for (ImportAlias alias : importFrom.getImportAliases()) {
                    declareVariable(scope, alias.getAlias() == null ? alias.getName() : alias.getAlias(), null);
                }
            }
            return;
        }

        if (statement instanceof StmtAssign stmtAssign) {
            analyzeAssignment(stmtAssign.getAssignmentStatement(), scope);
            return;
        }

        if (statement instanceof StmtExpression stmtExpression) {
            analyzeExpression(stmtExpression.getExpression(), scope, false);
            return;
        }

        if (statement instanceof StmtReturn stmtReturn) {
            analyzeReturn(stmtReturn.getReturnStatement(), scope);
            return;
        }

        if (statement instanceof StmtIf stmtIf) {
            IfStatement ifStatement = stmtIf.getIfStatement();
            analyzeExpression(ifStatement.getExpression(), scope, false);
            analyzeBlock(ifStatement.getBlock(), scope.child(false));
            if (ifStatement.getElseClause() != null) {
                analyzeBlock(ifStatement.getElseClause().getBlock(), scope.child(false));
            }
            return;
        }

        if (statement instanceof StmtFor stmtFor) {
            ForStatement forStatement = stmtFor.getForStatement();
            analyzeExpression(forStatement.getExpression(), scope, false);

            Scope loopScope = scope.child(false);
            VariableInfo loopInfo = new VariableInfo();
            String iterableName = extractReferenceName(forStatement.getExpression());
            if (iterableName != null) {
                VariableInfo iterableInfo = scope.resolveVariable(iterableName);
                if (iterableInfo != null) {
                    loopInfo.objectProperties.addAll(iterableInfo.elementProperties);
                }
            }
            declareVariable(loopScope, forStatement.getObjectName(), loopInfo);
            analyzeBlock(forStatement.getBlock(), loopScope);
            return;
        }

        if (statement instanceof StmtWith stmtWith) {
            WithStatement withStatement = stmtWith.getWithStatement();
            analyzeExpression(withStatement.getExpression(), scope, false);
            Scope withScope = scope.child(false);
            if (withStatement.getName() != null) {
                declareVariable(withScope, withStatement.getName(), null);
            }
            analyzeBlock(withStatement.getBlock(), withScope);
            return;
        }

        if (statement instanceof StmtFunction stmtFunction) {
            analyzeFunction(stmtFunction.getFunctionDef(), scope);
            return;
        }

        if (statement instanceof StmtDecorator stmtDecorator) {
            DecoratorStatement decorated = stmtDecorator.getDecoratorStatement();
            analyzeDecorator(decorated.getDecorators(), scope);
            analyzeFunction(decorated.getFunctionDef(), scope);
        }
    }

    private void analyzeFunction(FunctionDef functionDef, Scope parentScope) {
        Scope functionScope = parentScope.child(true);
        if (functionDef.getParameterList() != null && functionDef.getParameterList().getParameters() != null) {
            for (ParameterFunction parameter : functionDef.getParameterList().getParameters()) {
                if (parameter instanceof ParamIdentifier identifier) {
                    declareVariable(functionScope, identifier.getParameter(), null);
                } else if (parameter instanceof ParamExpression expressionParam) {
                    analyzeExpression(expressionParam.getExpression(), parentScope, false);
                }
            }
        }

        analyzeBlock(functionDef.getBlock(), functionScope);
    }

    private void analyzeDecorator(Decorator decorator, Scope scope) {
        if (decorator == null) {
            return;
        }

        String name = dottedName(decorator.getDottedName());
        if (!name.isEmpty() && !functionSignatures.containsKey(name) && !builtinSignatures.containsKey(name) && name.contains(".")) {
            String root = name.substring(0, name.indexOf('.'));
            if (scope.resolveVariable(root) == null) {
                addError(Error_Type.VAR_NOT_EXIST,
                        "The variable " + root + " is Undeclared",
                        UNKNOWN_LOCATION);
            }
        }

        analyzeArguments(decorator.getArgumentList(), scope);
    }

    private void analyzeAssignment(AssignmentStatement assignmentStatement, Scope scope) {
        String target = extractReferenceName(assignmentStatement.getLeft());
        analyzeExpression(assignmentStatement.getRight(), scope, false);

        VariableInfo rightInfo = inferVariableInfo(assignmentStatement.getRight(), scope);
        if (target == null) {
            return;
        }

        if (scope.isDeclaredInCurrentScope(target)) {
            addError(Error_Type.VARIABLE_DUPLICATION,
                    "Repeat variable name " + target,
                    UNKNOWN_LOCATION);
        }

        declareVariable(scope, target, rightInfo);
    }

    private void analyzeReturn(ReturnStatement returnStatement, Scope scope) {
        if (!scope.inFunction()) {
            addError(Error_Type.RETURN_OUTSIDE_FUNCTION,
                    "Return statement outside function",
                    UNKNOWN_LOCATION);
        }

        analyzeExpression(returnStatement.getExpression(), scope, false);
        if (returnStatement.hasHtmlTemplate()) {
            validateTemplateUsage(returnStatement, scope);
        }
    }

    private void analyzeBlock(Block block, Scope scope) {
        if (block == null || block.getStatements() == null) {
            return;
        }

        for (Statement inner : block.getStatements()) {
            analyzeStatement(inner, scope);
        }
    }

    private void analyzeExpression(Expression expression, Scope scope, boolean assignmentTarget) {
        if (expression == null) {
            return;
        }

        if (expression.getOperator() != null) {
            analyzeOperand(expression.getLeft(), scope, false);
            analyzeOperand(expression.getRight(), scope, false);
            return;
        }

        analyzeOperand(expression.getLeft(), scope, assignmentTarget);
    }

    private void analyzeOperand(Object operand, Scope scope, boolean assignmentTarget) {
        if (operand instanceof Expression nested) {
            analyzeExpression(nested, scope, assignmentTarget);
            return;
        }

        if (operand instanceof Primary primary) {
            analyzePrimary(primary, scope, assignmentTarget);
            return;
        }

        if (operand instanceof ObjectLiteral objectLiteral) {
            if (objectLiteral.getPairList() != null) {
                for (Pair pair : objectLiteral.getPairList()) {
                    analyzeExpression(pair.getValue(), scope, false);
                }
            }
            return;
        }

        if (operand instanceof ArrayLiteral arrayLiteral && arrayLiteral.getExpressions() != null) {
            for (Expression expression : arrayLiteral.getExpressions()) {
                analyzeExpression(expression, scope, false);
            }
        }
    }

    private void analyzePrimary(Primary primary, Scope scope, boolean assignmentTarget) {
        if (primary == null || primary.getAtom() == null) {
            return;
        }

        String chain = null;
        if (primary.getAtom() instanceof IdentifierAtom identifier) {
            chain = identifier.getValue();
            if (!assignmentTarget && scope.resolveVariable(chain) == null && !functionSignatures.containsKey(chain) && !builtinSignatures.containsKey(chain)) {
                addError(Error_Type.VAR_NOT_EXIST,
                        "The variable " + chain + " is Undeclared",
                        UNKNOWN_LOCATION);
            }
        } else {
            analyzeOperand(primary.getAtom(), scope, false);
        }

        if (primary.getPostfixes() == null) {
            return;
        }

        for (Postfix postfix : primary.getPostfixes()) {
            if (postfix instanceof MemberAccess member) {
                if (chain != null) {
                    chain += "." + member.getValue();
                }
                continue;
            }

            if (postfix instanceof IndexAccess indexAccess) {
                analyzeExpression(indexAccess.getIndexExpression(), scope, false);
                chain = null;
                continue;
            }

            if (postfix instanceof Call call) {
                verifyFunctionCall(chain, call, scope);
                chain = null;
            }
        }
    }

    private void verifyFunctionCall(String functionName, Call call, Scope scope) {
        analyzeArguments(call.getArgumentList(), scope);

        if (functionName == null || functionName.isBlank()) {
            return;
        }

        Integer expectedArity = null;
        if (functionSignatures.containsKey(functionName)) {
            expectedArity = functionSignatures.get(functionName).parameterCount;
        } else if (builtinSignatures.containsKey(functionName)) {
            expectedArity = builtinSignatures.get(functionName);
        }

        if (expectedArity == null) {
            addError(Error_Type.FUNCTION_NOT_EXIST,
                    "The function " + functionName + " is Undeclared",
                    UNKNOWN_LOCATION);
            return;
        }

        int actual = argumentCount(call.getArgumentList());
        if (expectedArity >= 0 && expectedArity != actual) {
            addError(Error_Type.INVALID_ARGUMENT_COUNT,
                    "Function " + functionName + " expects " + expectedArity + " args but got " + actual,
                    UNKNOWN_LOCATION);
        }
    }

    private void analyzeArguments(ArgumentList argumentList, Scope scope) {
        if (argumentList == null || argumentList.getArguments() == null) {
            return;
        }

        for (Argument argument : argumentList.getArguments()) {
            if (argument instanceof ArgExpression expression) {
                analyzeExpression(expression.getExpression(), scope, false);
            } else if (argument instanceof ArgAssignment assignment) {
                analyzeExpression(assignment.getExpression(), scope, false);
            }
        }
    }

    private int argumentCount(ArgumentList argumentList) {
        if (argumentList == null || argumentList.getArguments() == null) {
            return 0;
        }
        return argumentList.getArguments().size();
    }

    private VariableInfo inferVariableInfo(Expression expression, Scope scope) {
        VariableInfo info = new VariableInfo();
        if (expression == null) {
            return info;
        }

        if (expression.getOperator() != null) {
            return info;
        }

        Object left = expression.getLeft();
        if (!(left instanceof Primary primary)) {
            return info;
        }

        Atom atom = primary.getAtom();
        if (atom instanceof ObjectLiteral objectLiteral) {
            if (objectLiteral.getPairList() != null) {
                for (Pair pair : objectLiteral.getPairList()) {
                    info.objectProperties.add(pair.getKey());
                }
            }
            return info;
        }

        if (atom instanceof ArrayLiteral arrayLiteral) {
            if (arrayLiteral.getExpressions() != null) {
                for (Expression item : arrayLiteral.getExpressions()) {
                    Object nested = item.getLeft();
                    if (nested instanceof Primary itemPrimary && itemPrimary.getAtom() instanceof ObjectLiteral objectLiteral) {
                        if (objectLiteral.getPairList() != null) {
                            for (Pair pair : objectLiteral.getPairList()) {
                                info.elementProperties.add(pair.getKey());
                            }
                        }
                    }
                }
            }
            return info;
        }

        if (atom instanceof IdentifierAtom identifier) {
            VariableInfo source = scope.resolveVariable(identifier.getValue());
            if (source != null) {
                info.objectProperties.addAll(source.objectProperties);
                info.elementProperties.addAll(source.elementProperties);
            }
        }

        return info;
    }

    private String extractReferenceName(Expression expression) {
        if (expression == null || expression.getOperator() != null) {
            return null;
        }

        Object left = expression.getLeft();
        if (!(left instanceof Primary primary) || !(primary.getAtom() instanceof IdentifierAtom identifier)) {
            return null;
        }

        StringBuilder reference = new StringBuilder(identifier.getValue());
        if (primary.getPostfixes() != null) {
            for (Postfix postfix : primary.getPostfixes()) {
                if (postfix instanceof MemberAccess member) {
                    reference.append('.').append(member.getValue());
                } else {
                    break;
                }
            }
        }

        return reference.toString();
    }

    private void validateTemplateUsage(ReturnStatement returnStatement, Scope scope) {
        Set<String> passedVariables = extractRenderTemplatePassedVariables(returnStatement.getExpression());
        if (passedVariables.isEmpty()) {
            return;
        }

        TemplateScope templateScope = new TemplateScope(null);
        for (String variable : passedVariables) {
            templateScope.define(variable, variable);
        }

        HtmlNode htmlNode = returnStatement.getHtmlNode();
        if (htmlNode == null || htmlNode.getHtmlContents() == null) {
            return;
        }

        for (HtmlContent content : htmlNode.getHtmlContents()) {
            analyzeHtmlContent(content, templateScope, scope, returnStatement.getTemplatePath());
        }
    }

    private void analyzeHtmlContent(HtmlContent content,
                                    TemplateScope templateScope,
                                    Scope pythonScope,
                                    String templateName) {
        if (content == null) {
            return;
        }

        if (content instanceof HtmlElement element) {
            analyzeHtmlElement(element.getHtmlTag(), templateScope, pythonScope, templateName);
            return;
        }

        if (content instanceof ExpressionJinja expressionJinja) {
            validateTemplateReference(expressionJinja.getJinjaExpression().getDottedName(), templateScope, pythonScope, templateName);
            return;
        }

        if (content instanceof ForBlock forBlock) {
            String iterable = forBlock.getIterableName();
            if (!templateScope.isDefined(iterable)) {
                addError(Error_Type.MISSING_FLASK_VARIABLE,
                        "The variable " + iterable + " is Missing Flask Variable",
                        templateName);
            }

            TemplateScope child = templateScope.child();
            child.define(forBlock.getLoopVariable(), iterable);
            if (forBlock.getHtmlContents() != null) {
                for (HtmlContent nested : forBlock.getHtmlContents()) {
                    analyzeHtmlContent(nested, child, pythonScope, templateName);
                }
            }
            return;
        }

        if (content instanceof IfBlock ifBlock) {
            String condition = ifBlock.getConditionVariable();
            if (condition != null && !condition.isBlank() && !templateScope.isDefined(condition)) {
                addError(Error_Type.MISSING_FLASK_VARIABLE,
                        "The variable " + condition + " is Missing Flask Variable",
                        templateName);
            }

            TemplateScope child = templateScope.child();
            if (ifBlock.getHtmlContents() != null) {
                for (HtmlContent nested : ifBlock.getHtmlContents()) {
                    analyzeHtmlContent(nested, child, pythonScope, templateName);
                }
            }
            return;
        }

        if (content instanceof StatementJinja statementJinja) {
            analyzeHtmlContent(statementJinja.getJinjaStatement(), templateScope, pythonScope, templateName);
        }
    }

    private void analyzeHtmlElement(HtmlTag tag,
                                    TemplateScope templateScope,
                                    Scope pythonScope,
                                    String templateName) {
        if (tag instanceof HtmlPairTag pairTag) {
            analyzeAttributes(pairTag.getHtmlAttributes(), templateScope, pythonScope, templateName);
            if (pairTag.getHtmlContents() != null) {
                for (HtmlContent nested : pairTag.getHtmlContents()) {
                    analyzeHtmlContent(nested, templateScope, pythonScope, templateName);
                }
            }
            return;
        }

        if (tag instanceof HtmlSingleTagSelfClosing selfClosing) {
            analyzeAttributes(selfClosing.getHtmlAttributes(), templateScope, pythonScope, templateName);
        }
    }

    private void analyzeAttributes(List<HtmlAttribute> attributes,
                                   TemplateScope templateScope,
                                   Scope pythonScope,
                                   String templateName) {
        if (attributes == null) {
            return;
        }

        for (HtmlAttribute attribute : attributes) {
            String value = attribute.getAttributeValue().getValue();
            Matcher matcher = JINJA_VARIABLE.matcher(value);
            while (matcher.find()) {
                validateTemplateReference(toDottedName(matcher.group(1)), templateScope, pythonScope, templateName);
            }
        }
    }

    private void validateTemplateReference(AST.flask.DottedName dottedName,
                                           TemplateScope templateScope,
                                           Scope pythonScope,
                                           String templateName) {
        if (dottedName == null || dottedName.getFirst() == null) {
            return;
        }

        String base = dottedName.getFirst();
        if (!templateScope.isDefined(base)) {
            addError(Error_Type.MISSING_FLASK_VARIABLE,
                    "The variable " + base + " is Missing Flask Variable",
                    templateName);
            return;
        }

        if (dottedName.getRest() == null || dottedName.getRest().isEmpty()) {
            return;
        }

        String source = templateScope.resolveSource(base);
        VariableInfo variableInfo = pythonScope.resolveVariable(source);
        if (variableInfo == null) {
            return;
        }

        String property = dottedName.getRest().get(0);
        Set<String> knownProperties = !variableInfo.objectProperties.isEmpty()
                ? variableInfo.objectProperties
                : variableInfo.elementProperties;

        if (!knownProperties.isEmpty() && !knownProperties.contains(property)) {
            addError(Error_Type.UNDECLARED_PROPERTY,
                    "The Property '" + property + "' is Undeclared on object '" + base + "'",
                    templateName);
        }
    }

    private Set<String> extractRenderTemplatePassedVariables(Expression expression) {
        Set<String> passed = new HashSet<>();
        if (expression == null || expression.getOperator() != null || !(expression.getLeft() instanceof Primary primary)) {
            return passed;
        }

        if (!(primary.getAtom() instanceof IdentifierAtom identifier) || !"render_template".equals(identifier.getValue())) {
            return passed;
        }

        if (primary.getPostfixes() == null) {
            return passed;
        }

        for (Postfix postfix : primary.getPostfixes()) {
            if (postfix instanceof Call call && call.getArgumentList() != null && call.getArgumentList().getArguments() != null) {
                for (Argument argument : call.getArgumentList().getArguments()) {
                    if (argument instanceof ArgAssignment assignment) {
                        passed.add(assignment.getIdentifier());
                    }
                }
            }
        }

        return passed;
    }

    private void declareVariable(Scope scope, String name, VariableInfo info) {
        if (name == null || name.isBlank()) {
            return;
        }

        if (info == null) {
            info = new VariableInfo();
        }
        scope.defineVariable(name, info);
    }

    private AST.flask.DottedName toDottedName(String value) {
        String[] parts = value.split("\\.");
        String first = parts[0];
        List<String> rest = new ArrayList<>();
        for (int i = 1; i < parts.length; i++) {
            rest.add(parts[i]);
        }
        return new AST.flask.DottedName(first, rest);
    }

    private String dottedName(AST.flask.DottedName dottedName) {
        if (dottedName == null || dottedName.getFirst() == null) {
            return "";
        }

        StringBuilder name = new StringBuilder(dottedName.getFirst());
        if (dottedName.getRest() != null) {
            for (String part : dottedName.getRest()) {
                name.append('.').append(part);
            }
        }
        return name.toString();
    }

    private void addError(Error_Type type, String message, String location) {
        Symantic_Error error = new Symantic_Error();
        error.addError(type, message, location == null ? UNKNOWN_LOCATION : location);
        Main.errors.add(error);
    }

    private static class FunctionSignature {
        private final int parameterCount;

        private FunctionSignature(int parameterCount) {
            this.parameterCount = parameterCount;
        }
    }

    private static class VariableInfo {
        private final Set<String> objectProperties = new HashSet<>();
        private final Set<String> elementProperties = new HashSet<>();
    }

    private static class Scope {
        private final Scope parent;
        private final boolean functionScope;
        private final Map<String, VariableInfo> variables = new HashMap<>();

        private Scope(Scope parent, boolean functionScope) {
            this.parent = parent;
            this.functionScope = functionScope;
        }

        private Scope child(boolean functionScope) {
            return new Scope(this, functionScope);
        }

        private boolean inFunction() {
            if (functionScope) {
                return true;
            }
            return parent != null && parent.inFunction();
        }

        private boolean isDeclaredInCurrentScope(String name) {
            return variables.containsKey(name);
        }

        private void defineVariable(String name, VariableInfo info) {
            variables.put(name, info);
        }

        private VariableInfo resolveVariable(String name) {
            Scope scope = this;
            while (scope != null) {
                if (scope.variables.containsKey(name)) {
                    return scope.variables.get(name);
                }
                scope = scope.parent;
            }
            return null;
        }
    }

    private static class TemplateScope {
        private final TemplateScope parent;
        private final Map<String, String> aliases = new HashMap<>();

        private TemplateScope(TemplateScope parent) {
            this.parent = parent;
        }

        private TemplateScope child() {
            return new TemplateScope(this);
        }

        private void define(String name, String source) {
            aliases.put(name, source == null ? name : source);
        }

        private boolean isDefined(String name) {
            return resolveSource(name) != null;
        }

        private String resolveSource(String name) {
            TemplateScope scope = this;
            while (scope != null) {
                if (scope.aliases.containsKey(name)) {
                    return scope.aliases.get(name);
                }
                scope = scope.parent;
            }
            return null;
        }
    }
}
