package AST.flask;

public class PostfixIndex implements Postfix{
    Expression expression;

    public PostfixIndex(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PostfixIndex{");

        if (expression != null) {
            sb.append("expression=").append(expression);
        }

        sb.append("}");
        return sb.toString();
    }

}
