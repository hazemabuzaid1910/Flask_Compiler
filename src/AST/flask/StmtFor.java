//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

public class StmtFor implements Statement {
    ForStatement forStatement;

    public StmtFor(ForStatement var1) {
        this.forStatement = var1;
    }

    public ForStatement getForStatement() {
        return this.forStatement;
    }

    public void setForStatement(ForStatement var1) {
        this.forStatement = var1;
    }

    public String toString() {
        return this.forStatement == null ? "StmtFor{}" : "StmtFor{\n  " + String.valueOf(this.forStatement) + "\n}";
    }
}
