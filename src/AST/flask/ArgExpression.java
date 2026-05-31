package AST.flask;

public class ArgExpression implements Argument{
    Expression expression;

    public ArgExpression(Expression expression) {
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
        sb.append("ArgExpression{\n\t\t");

        if (expression != null) {
            sb.append("  expression=").append(expression).append("\n");
        }

        sb.append("}");
        return sb.toString();
    }

}
