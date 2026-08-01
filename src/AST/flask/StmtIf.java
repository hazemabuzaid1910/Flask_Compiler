//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

public class StmtIf implements Statement {
    IfStatement ifStatement;

    public StmtIf(IfStatement var1) {
        this.ifStatement = var1;
    }

    public IfStatement getIfStatement() {
        return this.ifStatement;
    }

    public void setIfStatement(IfStatement var1) {
        this.ifStatement = var1;
    }

    public String toString() {
        return this.ifStatement == null ? "StmtIf{}" : "StmtIf{\n  " + String.valueOf(this.ifStatement) + "\n}";
    }
}
