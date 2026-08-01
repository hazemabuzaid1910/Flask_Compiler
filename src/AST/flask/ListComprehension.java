//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

public class ListComprehension implements Atom {
    private Expression target;
    private String loopVariable;
    private Expression iterable;
    private Expression condition;

    public ListComprehension(Expression var1, String var2, Expression var3, Expression var4) {
        this.target = var1;
        this.loopVariable = var2;
        this.iterable = var3;
        this.condition = var4;
    }

    public Expression getTarget() {
        return this.target;
    }

    public void setTarget(Expression var1) {
        this.target = var1;
    }

    public String getLoopVariable() {
        return this.loopVariable;
    }

    public void setLoopVariable(String var1) {
        this.loopVariable = var1;
    }

    public Expression getIterable() {
        return this.iterable;
    }

    public void setIterable(Expression var1) {
        this.iterable = var1;
    }

    public Expression getCondition() {
        return this.condition;
    }

    public void setCondition(Expression var1) {
        this.condition = var1;
    }

    public String toString() {
        String var10000 = String.valueOf(this.target);
        return "ListComprehension{target=" + var10000 + ", loopVariable='" + this.loopVariable + "', iterable=" + String.valueOf(this.iterable) + ", condition=" + String.valueOf(this.condition) + "}";
    }
}
