package AST.flask;

import java.util.List;

public class LogicalAnd {
    List<Additive> additives;

    public LogicalAnd(List<Additive> additives) {
        this.additives = additives;
    }

    public List<Additive> getAdditives() {
        return additives;
    }

    public void setAdditives(List<Additive> additives) {
        this.additives = additives;
    }

    @Override
    public String toString() {
        return "LogicalAnd{\n\t\t" +
             additives +
                "\n\t\t"+'}';
    }
}
