//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

import java.util.List;

public class LogicalOR {
    private LogicalAnd first;
    private List<LogicalAnd> rest;

    public LogicalOR(LogicalAnd var1, List<LogicalAnd> var2) {
        this.first = var1;
        this.rest = var2;
    }

    public LogicalAnd getFirst() {
        return this.first;
    }

    public List<LogicalAnd> getRest() {
        return this.rest;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append(this.first);
        if (this.rest != null && !this.rest.isEmpty()) {
            var1.append("rest").append(this.rest);
        }

        return var1.toString();
    }
}
