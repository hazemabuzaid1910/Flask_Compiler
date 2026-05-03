package AST.flask;

public class ArgAssignment implements Argument{
    String identifier;
    Expression expression;

    public ArgAssignment(String identifier, Expression expression) {
        this.identifier = identifier;
        this.expression = expression;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
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
        sb.append("ArgAssignment{\n");

        if (identifier != null) {
            sb.append("  identifier='").append(identifier).append("'\n");
        }
        if (expression != null) {
            sb.append("  expression=").append(expression).append("\n");
        }

        sb.append("}");
        return sb.toString();
    }

}
