package AST.flask;

public class StmtIf implements Statement{
    IfStatement ifStatement;

    public StmtIf(IfStatement ifStatement) {
        this.ifStatement = ifStatement;
    }

    public IfStatement getIfStatement() {
        return ifStatement;
    }

    public void setIfStatement(IfStatement ifStatement) {
        this.ifStatement = ifStatement;
    }

    @Override
    public String toString() {
        if (ifStatement == null) {
            return "StmtIf{}";
        }
        return "StmtIf{\n  " + ifStatement + "\n}";
    }
}
