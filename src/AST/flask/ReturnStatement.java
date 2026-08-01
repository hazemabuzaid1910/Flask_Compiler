//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

import AST.html.HtmlNode;

public class ReturnStatement {
    private Expression expression;
    private HtmlNode htmlNode;
    private String templatePath;

    public ReturnStatement(Expression var1) {
        this.expression = var1;
        this.htmlNode = null;
        this.templatePath = null;
    }

    public ReturnStatement(Expression var1, HtmlNode var2, String var3) {
        this.expression = var1;
        this.htmlNode = var2;
        this.templatePath = var3;
    }

    public Expression getExpression() {
        return this.expression;
    }

    public HtmlNode getHtmlNode() {
        return this.htmlNode;
    }

    public String getTemplatePath() {
        return this.templatePath;
    }

    public boolean hasHtmlTemplate() {
        return this.htmlNode != null;
    }

    public String toString() {
        if (this.htmlNode != null) {
            String var10000 = this.templatePath;
            return "ReturnStatement(render_template: " + var10000 + ", htmlAST: " + String.valueOf(this.htmlNode) + ")";
        } else {
            return "ReturnStatement(expression: " + String.valueOf(this.expression) + ")";
        }
    }
}
