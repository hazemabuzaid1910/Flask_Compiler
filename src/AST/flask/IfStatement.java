package AST.flask;

public class IfStatement {

    Expression expression;
    Block block;
    ElseClause elseClause;

    public IfStatement( Expression expression, Block block, ElseClause elseClause) {
        this.expression = expression;
        this.block = block;
        this.elseClause = elseClause;
    }



    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public ElseClause getElseClause() {
        return elseClause;
    }

    public void setElseClause(ElseClause elseClause) {
        this.elseClause = elseClause;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IfStatement{");

        if (expression != null) {
            sb.append("expression=").append(expression);
        }

        if (block != null) {
            if (sb.length() > "IfStatement{".length()) sb.append(", ");
            sb.append("block=").append(block);
        }

        if (elseClause != null) {
            if (sb.length() > "IfStatement{".length()) sb.append(", ");
            sb.append("elseClause=").append(elseClause);
        }

        sb.append("}");
        return sb.toString();
    }

}
