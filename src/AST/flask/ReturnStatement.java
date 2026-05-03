package AST.flask;

import AST.html.HtmlNode;

public class ReturnStatement {
    private Expression expression;
    private HtmlNode htmlNode;  // إضافة حقل HTML
    private String templatePath; // مسار القالب

    public ReturnStatement(Expression expression) {
        this.expression = expression;
        this.htmlNode = null;
        this.templatePath = null;
    }

    public ReturnStatement(Expression expression, HtmlNode htmlNode, String templatePath) {
        this.expression = expression;
        this.htmlNode = htmlNode;
        this.templatePath = templatePath;
    }

    public Expression getExpression() {
        return expression;
    }

    public HtmlNode getHtmlNode() {
        return htmlNode;
    }

    public String getTemplatePath() {
        return templatePath;
    }

    public boolean hasHtmlTemplate() {
        return htmlNode != null;
    }

    @Override
    public String toString() {
        if (htmlNode != null) {
            return "ReturnStatement(render_template: " + templatePath + ", htmlAST: " + htmlNode + ")";
        }
        return "ReturnStatement(expression: " + expression + ")";
    }
}