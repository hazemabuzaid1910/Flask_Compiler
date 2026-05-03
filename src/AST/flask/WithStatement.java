package AST.flask;

public class WithStatement implements Statement{
    Expression expression;
    String name;
    Block block;

    public WithStatement( Expression expression, String name, Block block) {
        this.expression = expression;

        this.name = name;
        this.block = block;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("WithStatement{");
        if (expression != null) sb.append("\n  expression=").append(expression);
        if (name != null) sb.append(",\n  name='").append(name).append('\'');
        if (block != null) sb.append(",\n  block=").append(block);
        sb.append("\n}");
        return sb.toString();
    }

}
