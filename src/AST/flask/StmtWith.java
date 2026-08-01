//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

public class StmtWith implements Statement {
    WithStatement withStatement;

    public StmtWith(WithStatement var1) {
        this.withStatement = var1;
    }

    public WithStatement getWithStatement() {
        return this.withStatement;
    }

    public void setWithStatement(WithStatement var1) {
        this.withStatement = var1;
    }

    public String toString() {
        return this.withStatement == null ? "StmtWith{}" : "StmtWith{\n  " + String.valueOf(this.withStatement) + "\n}";
    }
}
