package serializer;

import AST.flask.DottedName;
import AST.html.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlAstJsonSerializer {

    private static final Pattern JINJA_VARIABLE = Pattern.compile("\\{\\{\\s*([a-zA-Z_][a-zA-Z0-9_\\.]*)\\s*}}", Pattern.DOTALL);

    public JsonElement serialize(HtmlNode htmlNode) {
        JsonObject root = new JsonObject();
        root.addProperty("type", "HtmlDocument");
        JsonArray children = new JsonArray();

        if (htmlNode != null && htmlNode.getHtmlContents() != null) {
            for (HtmlContent content : htmlNode.getHtmlContents()) {
                JsonElement item = serializeContent(content);
                if (!item.isJsonNull()) {
                    children.add(item);
                }
            }
        }

        root.add("children", children);
        return root;
    }

    private JsonElement serializeContent(HtmlContent content) {
        if (content == null) {
            return JsonNull.INSTANCE;
        }

        if (content instanceof HtmlElement element) {
            return serializeElement(element.getHtmlTag());
        }

        if (content instanceof Text text) {
            JsonObject node = new JsonObject();
            node.addProperty("type", "Text");
            node.addProperty("value", String.join(" ", text.getText()));
            return node;
        }

        if (content instanceof IdentifierExpression identifier) {
            JsonObject node = new JsonObject();
            node.addProperty("type", "Text");
            node.addProperty("value", identifier.getIdentifier());
            return node;
        }

        if (content instanceof ExpressionJinja expressionJinja) {
            JsonObject node = new JsonObject();
            node.addProperty("type", "Variable");
            node.addProperty("name", dottedName(expressionJinja.getJinjaExpression().getDottedName()));
            return node;
        }

        if (content instanceof ForBlock forBlock) {
            JsonObject node = new JsonObject();
            node.addProperty("type", "ForBlock");
            node.addProperty("variable", forBlock.getLoopVariable());
            node.addProperty("iterable", forBlock.getIterableName());
            node.add("body", serializeChildren(forBlock.getHtmlContents()));
            return node;
        }

        if (content instanceof IfBlock ifBlock) {
            JsonObject node = new JsonObject();
            node.addProperty("type", "IfBlock");
            node.addProperty("condition", ifBlock.getConditionVariable());
            node.add("body", serializeChildren(ifBlock.getHtmlContents()));
            return node;
        }

        if (content instanceof StatementJinja statementJinja && statementJinja.getJinjaStatement() instanceof HtmlContent jinjaContent) {
            return serializeContent(jinjaContent);
        }

        return JsonNull.INSTANCE;
    }

    private JsonArray serializeChildren(List<HtmlContent> contents) {
        JsonArray body = new JsonArray();
        if (contents == null) {
            return body;
        }

        for (HtmlContent content : contents) {
            JsonElement item = serializeContent(content);
            if (!item.isJsonNull()) {
                body.add(item);
            }
        }

        return body;
    }

    private JsonElement serializeElement(HtmlTag htmlTag) {
        if (htmlTag instanceof HtmlPairTag pairTag) {
            JsonObject node = new JsonObject();
            node.addProperty("type", "Element");
            node.addProperty("tag", pairTag.getHtmlTag().getTagName());
            node.add("attributes", attributesToObject(pairTag.getHtmlAttributes()));
            node.add("children", serializeChildren(pairTag.getHtmlContents()));
            return node;
        }

        if (htmlTag instanceof HtmlSingleTagSelfClosing singleTag) {
            JsonObject node = new JsonObject();
            node.addProperty("type", "Element");
            node.addProperty("tag", singleTag.getTagName().getTagName());
            node.add("attributes", attributesToObject(singleTag.getHtmlAttributes()));
            node.add("children", new JsonArray());
            return node;
        }

        return JsonNull.INSTANCE;
    }

    private JsonObject attributesToObject(List<HtmlAttribute> attributes) {
        JsonObject object = new JsonObject();
        if (attributes == null) {
            return object;
        }

        for (HtmlAttribute attribute : attributes) {
            String key = attribute.getAttributeKey().getAttributeKey();
            String rawValue = attribute.getAttributeValue().getValue();
            List<String> jinjaVars = extractInlineVariables(rawValue);

            if (jinjaVars.isEmpty()) {
                object.addProperty(key, rawValue);
            } else if (jinjaVars.size() == 1 && rawValue.trim().startsWith("{{") && rawValue.trim().endsWith("}}")) {
                JsonObject variableNode = new JsonObject();
                variableNode.addProperty("type", "Variable");
                variableNode.addProperty("name", jinjaVars.get(0));
                object.add(key, variableNode);
            } else {
                JsonObject mixedNode = new JsonObject();
                mixedNode.addProperty("type", "TemplateText");
                mixedNode.addProperty("value", rawValue);
                JsonArray variables = new JsonArray();
                for (String variable : jinjaVars) {
                    variables.add(variable);
                }
                mixedNode.add("variables", variables);
                object.add(key, mixedNode);
            }
        }

        return object;
    }

    private List<String> extractInlineVariables(String value) {
        List<String> result = new ArrayList<>();
        if (value == null || value.isBlank()) {
            return result;
        }

        Matcher matcher = JINJA_VARIABLE.matcher(value);
        while (matcher.find()) {
            result.add(matcher.group(1));
        }
        return result;
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
