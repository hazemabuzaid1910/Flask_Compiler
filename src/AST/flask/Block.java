package AST.flask;

import java.util.List;

public class Block {
    List<Statement> statements;

    public Block(List<Statement> statements) {
        this.statements = statements;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Block{\n");

        if (statements != null && !statements.isEmpty()) {
            sb.append("  statements=[\n");
            for (Object stmt : statements) {
                if (stmt != null) {
                    sb.append("    ").append(stmt.toString().replaceAll("(?m)^", "    ")).append("\n");
                }
            }
            sb.append("  ]\n");
        }

        sb.append("}");
        return sb.toString();
    }

}
