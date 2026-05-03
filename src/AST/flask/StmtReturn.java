package AST.flask;

public class StmtReturn implements  Statement{
    ReturnStatement returnStatement;

    public StmtReturn(ReturnStatement returnStatement) {
        this.returnStatement = returnStatement;
    }

    public ReturnStatement getReturnStatement() {
        return returnStatement;
    }

    public void setReturnStatement(ReturnStatement returnStatement) {
        this.returnStatement = returnStatement;
    }

    @Override
    public String toString() {
        if (returnStatement == null) {
            return "StmtReturn{}";
        }
        return " "+returnStatement+" ";
    }

}
