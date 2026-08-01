//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

public class IfStatement {
    Expression expression;
    Block block;
    ElseClause elseClause;

    public IfStatement(Expression var1, Block var2, ElseClause var3) {
        this.expression = var1;
        this.block = var2;
        this.elseClause = var3;
    }

    public Expression getExpression() {
        return this.expression;
    }

    public void setExpression(Expression var1) {
        this.expression = var1;
    }

    public Block getBlock() {
        return this.block;
    }

    public void setBlock(Block var1) {
        this.block = var1;
    }

    public ElseClause getElseClause() {
        return this.elseClause;
    }

    public void setElseClause(ElseClause var1) {
        this.elseClause = var1;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("IfStatement{");
        if (this.expression != null) {
            var1.append("expression=").append(this.expression);
        }

        if (this.block != null) {
            if (var1.length() > "IfStatement{".length()) {
                var1.append(", ");
            }

            var1.append("block=").append(this.block);
        }

        if (this.elseClause != null) {
            if (var1.length() > "IfStatement{".length()) {
                var1.append(", ");
            }

            var1.append("elseClause=").append(this.elseClause);
        }

        var1.append("}");
        return var1.toString();
    }
}
