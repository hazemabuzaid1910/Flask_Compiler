//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

public class StmtAssign implements Statement {
    private AssignmentStatement assignmentStatement;

    public StmtAssign(AssignmentStatement var1) {
        this.assignmentStatement = var1;
    }

    public AssignmentStatement getAssignmentStatement() {
        return this.assignmentStatement;
    }

    public String toString() {
        return "\n\t\t" + String.valueOf(this.assignmentStatement) + "\n";
    }
}
