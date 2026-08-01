//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

public class StmtReturn implements Statement {
    ReturnStatement returnStatement;

    public StmtReturn(ReturnStatement var1) {
        this.returnStatement = var1;
    }

    public ReturnStatement getReturnStatement() {
        return this.returnStatement;
    }

    public void setReturnStatement(ReturnStatement var1) {
        this.returnStatement = var1;
    }

    public String toString() {
        return this.returnStatement == null ? "StmtReturn{}" : " " + String.valueOf(this.returnStatement) + " ";
    }
}
