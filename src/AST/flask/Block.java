package AST.flask;

import java.util.Iterator;
import java.util.List;

public class Block {
    List<Statement> statements;

    public Block(List<Statement> var1) {
        this.statements = var1;
    }

    public List<Statement> getStatements() {
        return this.statements;
    }

    public void setStatements(List<Statement> var1) {
        this.statements = var1;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("Block{\n");
        if (this.statements != null && !this.statements.isEmpty()) {
            var1.append("  statements=[\n");
            Iterator var2 = this.statements.iterator();

            while(var2.hasNext()) {
                Object var3 = var2.next();
                if (var3 != null) {
                    var1.append("    ").append(var3.toString().replaceAll("(?m)^", "    ")).append("\n");
                }
            }

            var1.append("  ]\n");
        }

        var1.append("}");
        return var1.toString();
    }
}
