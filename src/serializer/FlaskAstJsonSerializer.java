package serializer;

import AST.flask.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.util.ArrayList;
import java.util.List;

public class FlaskAstJsonSerializer {

    private final HtmlAstJsonSerializer htmlSerializer = new HtmlAstJsonSerializer();

    public JsonElement serialize(Program program) {
        JsonObject root = new JsonObject();
        root.addProperty("type", "Program");
        JsonArray body = new JsonArray();
        if (program != null && program.getElements() != null) {
            for (Object element : program.getElements()) {
                if (element instanceof Statement statement) {
                    body.add(serializeStatement(statement));
                }
            }
        }
        root.add("body", body);
        return root;
    }

    private JsonElement serializeStatement(Statement statement) {
        if (statement instanceof ImportFrom importFrom) {
            JsonObject node = new JsonObject();
            node.addProperty("type", "ImportFrom");
            node.addProperty("module", dottedName(importFrom.getDottedName()));
            JsonArray symbols = new JsonArray();
            if (importFrom.getImportAliases() != null) {
                for (ImportAlias alias : importFrom.getImportAliases()) {
                    symbols.add(alias.getName());
                }
            }
            node.add("symbols", symbols);
            return node;
        }

        if (statement instanceof ImportSimple importSimple) {
            JsonObject node = new JsonObject();
            node.addProperty("type", "Import");
            JsonArray modules = new JsonArray();
            if (importSimple.getImportAliases() != null) {
                for (ImportAlias alias : importSimple.getImportAliases()) {
                    modules.add(alias.getName());
                }
            }
            node.add("modules", modules);
            return node;
        }

        if (statement instanceof StmtAssign stmtAssign) {
            AssignmentStatement assignment = stmtAssign.getAssignmentStatement();
            JsonObject node = new JsonObject();
            node.addProperty("type", "Assignment");
            node.add("target", jsonValue(extractReference(assignment.getLeft())));
            node.add("value", toJsonValue(assignment.getRight()));
            return node;
        }

        if (statement instanceof StmtFunction stmtFunction) {
            return serializeFunction(stmtFunction.getFunctionDef());
        }

        if (statement instanceof StmtDecorator stmtDecorator) {
            DecoratorStatement decorated = stmtDecorator.getDecoratorStatement();
            JsonObject node = new JsonObject();
            node.addProperty("type", "DecoratedFunction");
            node.add("decorator", serializeDecorator(decorated.getDecorators()));
            node.add("function", serializeFunction(decorated.getFunctionDef()));
            return node;
        }

        if (statement instanceof StmtIf stmtIf) {
            IfStatement ifStmt = stmtIf.getIfStatement();
            JsonObject node = new JsonObject();
            node.addProperty("type", "If");
            node.add("condition", toJsonValue(ifStmt.getExpression()));
            node.add("then", serializeBlock(ifStmt.getBlock()));
            node.add("else", ifStmt.getElseClause() == null
                    ? new JsonArray()
                    : serializeBlock(ifStmt.getElseClause().getBlock()));
            return node;
        }

        if (statement instanceof StmtFor stmtFor) {
            ForStatement forStatement = stmtFor.getForStatement();
            JsonObject node = new JsonObject();
            node.addProperty("type", "For");
            node.addProperty("variable", forStatement.getObjectName());
            node.add("iterable", jsonValue(extractReference(forStatement.getExpression())));
            node.add("body", serializeBlock(forStatement.getBlock()));
            return node;
        }

        if (statement instanceof StmtWith stmtWith) {
            WithStatement withStatement = stmtWith.getWithStatement();
            JsonObject node = new JsonObject();
            node.addProperty("type", "With");
            node.add("value", toJsonValue(withStatement.getExpression()));
            node.add("alias", jsonValue(withStatement.getName()));
            node.add("body", serializeBlock(withStatement.getBlock()));
            return node;
        }

        if (statement instanceof StmtReturn stmtReturn) {
            ReturnStatement returnStatement = stmtReturn.getReturnStatement();
            JsonObject node = new JsonObject();
            node.addProperty("type", "Return");
            node.add("value", toJsonValue(returnStatement.getExpression()));
            if (returnStatement.hasHtmlTemplate()) {
                node.addProperty("template", returnStatement.getTemplatePath());
                node.add("html", htmlSerializer.serialize(returnStatement.getHtmlNode()));
            }
            return node;
        }

        if (statement instanceof StmtExpression stmtExpression) {
            JsonObject node = new JsonObject();
            node.addProperty("type", "ExpressionStatement");
            node.add("expression", toJsonValue(stmtExpression.getExpression()));
            return node;
        }

        JsonObject fallback = new JsonObject();
        fallback.addProperty("type", statement.getClass().getSimpleName());
        return fallback;
    }

    private JsonObject serializeFunction(FunctionDef functionDef) {
        JsonObject node = new JsonObject();
        node.addProperty("type", "Function");
        node.addProperty("name", functionDef.getFunc_name());
        JsonArray params = new JsonArray();
        if (functionDef.getParameterList() != null && functionDef.getParameterList().getParameters() != null) {
            for (ParameterFunction parameter : functionDef.getParameterList().getParameters()) {
                if (parameter instanceof ParamIdentifier identifier) {
                    params.add(identifier.getParameter());
                }
            }
        }
        node.add("parameters", params);
        node.add("body", serializeBlock(functionDef.getBlock()));
        return node;
    }

    private JsonObject serializeDecorator(Decorator decorator) {
        JsonObject node = new JsonObject();
        node.addProperty("type", "Decorator");
        node.addProperty("name", dottedName(decorator.getDottedName()));
        node.add("arguments", serializeArguments(decorator.getArgumentList()));
        return node;
    }

    private JsonArray serializeBlock(Block block) {
        JsonArray body = new JsonArray();
        if (block == null || block.getStatements() == null) {
            return body;
        }
        for (Statement statement : block.getStatements()) {
            body.add(serializeStatement(statement));
        }
        return body;
    }

    private JsonElement toJsonValue(Expression expression) {
        if (expression == null) {
            return JsonNull.INSTANCE;
        }
        if (expression.getOperator() != null) {
            JsonObject node = new JsonObject();
            node.addProperty("type", "BinaryExpression");
            node.addProperty("operator", expression.getOperator());
            node.add("left", toJsonValue(asExpression(expression.getLeft())));
            node.add("right", toJsonValue(asExpression(expression.getRight())));
            return node;
        }

        Object left = expression.getLeft();
        if (left instanceof Primary primary) {
            return primaryToValue(primary);
        }
        if (left instanceof Expression nested) {
            return toJsonValue(nested);
        }
        return rawValueToJson(left);
    }

    private JsonElement primaryToValue(Primary primary) {
        Object current = atomToValue(primary.getAtom());
        if (primary.getPostfixes() == null || primary.getPostfixes().isEmpty()) {
            return rawValueToJson(current);
        }

        String chain = (current instanceof String value) ? value : null;

        for (Postfix postfix : primary.getPostfixes()) {
            if (postfix instanceof MemberAccess member) {
                chain = chain == null ? member.getValue() : chain + "." + member.getValue();
                current = chain;
                continue;
            }

            if (postfix instanceof IndexAccess indexAccess) {
                JsonObject indexNode = new JsonObject();
                indexNode.addProperty("type", "Index");
                indexNode.add("target", rawValueToJson(current));
                indexNode.add("index", toJsonValue(indexAccess.getIndexExpression()));
                current = indexNode;
                chain = null;
                continue;
            }

            if (postfix instanceof Call call) {
                JsonObject callNode = new JsonObject();
                callNode.addProperty("type", "Call");
                callNode.add("function", rawValueToJson(current));
                callNode.add("arguments", serializeArguments(call.getArgumentList()));
                current = callNode;
                chain = null;
            }
        }

        return rawValueToJson(current);
    }

    private JsonArray serializeArguments(ArgumentList argumentList) {
        JsonArray args = new JsonArray();
        if (argumentList == null || argumentList.getArguments() == null) {
            return args;
        }

        for (Argument argument : argumentList.getArguments()) {
            if (argument instanceof ArgExpression argExpression) {
                args.add(toJsonValue(argExpression.getExpression()));
                continue;
            }

            if (argument instanceof ArgAssignment assignment) {
                JsonObject named = new JsonObject();
                named.addProperty("name", assignment.getIdentifier());
                named.add("value", toJsonValue(assignment.getExpression()));
                args.add(named);
            }
        }

        return args;
    }

    private Object atomToValue(Atom atom) {
        if (atom instanceof IdentifierAtom identifier) {
            return identifier.getValue();
        }
        if (atom instanceof Literal literal) {
            return literal.getValue();
        }
        if (atom instanceof ObjectLiteral objectLiteral) {
            JsonObject objectNode = new JsonObject();
            if (objectLiteral.getPairList() != null) {
                for (Pair pair : objectLiteral.getPairList()) {
                    objectNode.add(pair.getKey(), toJsonValue(pair.getValue()));
                }
            }
            return objectNode;
        }
        if (atom instanceof ArrayLiteral arrayLiteral) {
            JsonArray arrayNode = new JsonArray();
            if (arrayLiteral.getExpressions() != null) {
                for (Expression expression : arrayLiteral.getExpressions()) {
                    arrayNode.add(toJsonValue(expression));
                }
            }
            return arrayNode;
        }
        return null;
    }

    private String extractReference(Expression expression) {
        JsonElement value = toJsonValue(expression);
        if (value.isJsonPrimitive() && value.getAsJsonPrimitive().isString()) {
            return value.getAsString();
        }
        return value.toString();
    }

    private Expression asExpression(Object value) {
        return value instanceof Expression expression ? expression : new Expression(value);
    }

    private JsonElement rawValueToJson(Object value) {
        if (value == null) {
            return JsonNull.INSTANCE;
        }
        if (value instanceof JsonElement jsonElement) {
            return jsonElement;
        }
        if (value instanceof String stringValue) {
            return new JsonPrimitive(stringValue);
        }
        if (value instanceof Number numberValue) {
            return new JsonPrimitive(numberValue);
        }
        if (value instanceof Boolean booleanValue) {
            return new JsonPrimitive(booleanValue);
        }
        return new JsonPrimitive(value.toString());
    }

    private JsonElement jsonValue(String value) {
        return value == null ? JsonNull.INSTANCE : new JsonPrimitive(value);
    }

    private String dottedName(DottedName dottedName) {
        if (dottedName == null) {
            return "";
        }

        List<String> parts = new ArrayList<>();
        parts.add(dottedName.getFirst());
        if (dottedName.getRest() != null) {
            parts.addAll(dottedName.getRest());
        }
        return String.join(".", parts);
    }
}
