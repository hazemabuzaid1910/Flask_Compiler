package AST.flask;

import java.util.List;

public class LogicalOR {
    private List<LogicalAnd> terms;

    public LogicalOR(List<LogicalAnd> terms) {
        this.terms = terms;
    }

    public List<LogicalAnd> getRest() {
        return terms;
    }

    public void setRest(List<LogicalAnd> rest) {
        this.terms = rest;
    }

    @Override
    public String toString() {
        return "LogicalOR{" +
                "rest=" + terms +
                '}';
    }
}
