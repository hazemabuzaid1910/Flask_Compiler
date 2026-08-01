//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

public class StmtDecorator implements Statement {
    DecoratorStatement decoratorStatement;

    public StmtDecorator(DecoratorStatement var1) {
        this.decoratorStatement = var1;
    }

    public DecoratorStatement getDecoratorStatement() {
        return this.decoratorStatement;
    }

    public void setDecoratorStatement(DecoratorStatement var1) {
        this.decoratorStatement = var1;
    }

    public String toString() {
        return this.decoratorStatement == null ? "StmtDecorator{}" : "StmtDecorator{\n  " + String.valueOf(this.decoratorStatement) + "\n}";
    }
}
