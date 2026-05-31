package AST.flask;

import java.util.List;

public class Comparison {

    private LogicalOR first;
    private List<CompOp> operators;
    private List<LogicalOR> rest;

    public Comparison(LogicalOR first, List<CompOp> operators, List<LogicalOR> rest) {
        this.first = first;
        this.operators = operators;
        this.rest = rest;
    }

    public LogicalOR getFirst() {
        return first;
    }

    public List<CompOp> getOperators() {
        return operators;
    }

    public List<LogicalOR> getRest() {
        return rest;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Comparison{");

        if (first != null)
            sb.append("\n\t\t  first=").append(first);

        if (operators != null && !operators.isEmpty())
            sb.append("\n  operators=").append(operators);

        if (rest != null && !rest.isEmpty())
            sb.append("\n  rest=").append(rest);

        sb.append("\n\t\t}");
        return sb.toString();
    }
}