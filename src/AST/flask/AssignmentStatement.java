package AST.flask;

public class AssignmentStatement {
    private Expression left;
    private Expression right;

    public AssignmentStatement(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public void setLeft(Expression left) {
        this.left = left;
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Expression right) {
        this.right = right;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("AssignmentStatement{");

        if (left != null) {
            sb.append("left=").append(left);
        }

        if (right != null) {
            if (left != null) {
                sb.append(", ");
            }
            sb.append("right=").append(right);
        }

        sb.append('}');
        return sb.toString();
    }
}
