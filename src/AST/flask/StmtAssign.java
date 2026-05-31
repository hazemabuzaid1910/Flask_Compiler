package AST.flask;

public class StmtAssign implements Statement {

    private AssignmentStatement assignmentStatement;

    public StmtAssign(AssignmentStatement assignmentStatement) {
        this.assignmentStatement = assignmentStatement;
    }

    public AssignmentStatement getAssignmentStatement() {
        return assignmentStatement;
    }

    @Override
    public String toString() {
        return
                "\n\t\t" + assignmentStatement +
                '\n';
    }
}
