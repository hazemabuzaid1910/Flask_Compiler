package AST.flask;

public class StmtWith implements Statement{
    WithStatement withStatement;

    public StmtWith(WithStatement withStatement) {
        this.withStatement = withStatement;
    }

    public WithStatement getWithStatement() {
        return withStatement;
    }

    public void setWithStatement(WithStatement withStatement) {
        this.withStatement = withStatement;
    }

    @Override
    public String toString() {
        if (withStatement == null) {
            return "StmtWith{}";
        }
        return "StmtWith{\n  " + withStatement + "\n}";
    }

}
