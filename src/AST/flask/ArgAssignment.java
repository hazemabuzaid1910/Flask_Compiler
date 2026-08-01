//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

public class ArgAssignment implements Argument {
    String identifier;
    Expression expression;

    public ArgAssignment(String var1, Expression var2) {
        this.identifier = var1;
        this.expression = var2;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String var1) {
        this.identifier = var1;
    }

    public Expression getExpression() {
        return this.expression;
    }

    public void setExpression(Expression var1) {
        this.expression = var1;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("ArgAssignment{\n");
        if (this.identifier != null) {
            var1.append("  identifier='").append(this.identifier).append("'\n");
        }

        if (this.expression != null) {
            var1.append("  expression=").append(this.expression).append("\n");
        }

        var1.append("}");
        return var1.toString();
    }
}
