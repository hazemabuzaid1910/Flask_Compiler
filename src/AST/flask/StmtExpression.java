package AST.flask;

public class StmtExpression implements Statement {

    private Expression expression;

    public StmtExpression(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return "StmtExpression{" +
                "expression=" + expression +
                '}';
    }
}