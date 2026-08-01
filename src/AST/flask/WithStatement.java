//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

public class WithStatement implements Statement {
    Expression expression;
    String name;
    Block block;

    public WithStatement(Expression var1, String var2, Block var3) {
        this.expression = var1;
        this.name = var2;
        this.block = var3;
    }

    public Expression getExpression() {
        return this.expression;
    }

    public void setExpression(Expression var1) {
        this.expression = var1;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String var1) {
        this.name = var1;
    }

    public Block getBlock() {
        return this.block;
    }

    public void setBlock(Block var1) {
        this.block = var1;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder("WithStatement{");
        if (this.expression != null) {
            var1.append("\n  expression=").append(this.expression);
        }

        if (this.name != null) {
            var1.append(",\n  name='").append(this.name).append('\'');
        }

        if (this.block != null) {
            var1.append(",\n  block=").append(this.block);
        }

        var1.append("\n}");
        return var1.toString();
    }
}
