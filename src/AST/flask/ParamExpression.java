//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

public class ParamExpression implements ParameterFunction {
    Expression expression;

    public ParamExpression(Expression var1) {
        this.expression = var1;
    }

    public Expression getExpression() {
        return this.expression;
    }

    public void setExpression(Expression var1) {
        this.expression = var1;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("ParamExpression{");
        if (this.expression != null) {
            var1.append("expression=").append(this.expression);
        }

        var1.append("}");
        return var1.toString();
    }
}
