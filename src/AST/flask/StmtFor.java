package AST.flask;

public class StmtFor implements Statement{
    ForStatement forStatement;

    public StmtFor(ForStatement forStatement) {
        this.forStatement = forStatement;
    }

    public ForStatement getForStatement() {
        return forStatement;
    }

    public void setForStatement(ForStatement forStatement) {
        this.forStatement = forStatement;
    }

    @Override
    public String toString() {
        if (forStatement == null) {
            return "StmtFor{}";
        }
        return "StmtFor{\n  " + forStatement + "\n}";
    }

}
