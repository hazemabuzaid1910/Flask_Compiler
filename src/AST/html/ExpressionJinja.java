package AST.html;

public class ExpressionJinja implements HtmlContent{
    JinjaExpression jinjaExpression;

    public ExpressionJinja(JinjaExpression jinjaExpression) {
        this.jinjaExpression = jinjaExpression;
    }

    public JinjaExpression getJinjaExpression() {
        return jinjaExpression;
    }

    public void setJinjaExpression(JinjaExpression jinjaExpression) {
        this.jinjaExpression = jinjaExpression;
    }

    @Override
    public String toString() {
        return "ExpressionJinja{" +
                "jinjaExpression=" + jinjaExpression +
                '}';
    }
}
