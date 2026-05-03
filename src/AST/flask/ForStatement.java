package AST.flask;

public class ForStatement {
    String objectName;

    Expression expression;
    Block block;

    public ForStatement( String objectName, Expression expression, Block block) {
        this.objectName = objectName;
        this.expression = expression;
        this.block = block;
    }


    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ForStatement{");

        boolean hasPrev = false;

        if (objectName != null) {
            sb.append("objectName='").append(objectName).append("'");
            hasPrev = true;
        }

        if (expression != null) {
            if (hasPrev) sb.append(", ");
            sb.append("expression=").append(expression);
            hasPrev = true;
        }

        if (block != null) {
            if (hasPrev) sb.append(", ");
            sb.append("block=").append(block);
        }

        sb.append("}");
        return sb.toString();
    }

}
