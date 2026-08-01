//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

import java.util.List;

public class LogicalAnd {
    List<Additive> additives;

    public LogicalAnd(List<Additive> var1) {
        this.additives = var1;
    }

    public List<Additive> getAdditives() {
        return this.additives;
    }

    public void setAdditives(List<Additive> var1) {
        this.additives = var1;
    }

    public String toString() {
        return "LogicalAnd{\n\t\t" + String.valueOf(this.additives) + "\n\t\t}";
    }
}
