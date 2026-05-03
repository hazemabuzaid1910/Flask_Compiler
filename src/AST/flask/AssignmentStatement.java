package AST.flask;

public class AssignmentStatement {
    Primary primary;
    Expression expression;

    public AssignmentStatement(Primary primary, Expression expression) {
        this.primary = primary;
        this.expression = expression;
    }

    public Primary getPrimary() {
        return primary;
    }

    public void setPrimary(Primary primary) {
        this.primary = primary;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "AssignmentStatement{" +
                "primary=" + primary +
                ", expression=" + expression +
                '}';
    }
}
