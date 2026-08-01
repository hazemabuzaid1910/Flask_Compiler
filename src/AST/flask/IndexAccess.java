//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

public class IndexAccess implements Postfix {
    private Expression indexExpression;

    public IndexAccess(Expression var1) {
        this.indexExpression = var1;
    }

    public Expression getIndexExpression() {
        return this.indexExpression;
    }

    public String toString() {
        return "IndexAccess[" + String.valueOf(this.indexExpression) + "]";
    }
}
