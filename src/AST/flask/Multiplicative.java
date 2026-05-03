package AST.flask;

import java.util.List;

public class Multiplicative {
    List<Unary> unaryList;
    List<String> operator;

    public Multiplicative(List<Unary> unaryList, List<String> operator) {
        this.unaryList = unaryList;
        this.operator = operator;
    }

    public List<Unary> getUnaryList() {
        return unaryList;
    }

    public void setUnaryList(List<Unary> unaryList) {
        this.unaryList = unaryList;
    }

    public List<String> getOperator() {
        return operator;
    }

    public void setOperator(List<String> operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Multiplicative{");

        if (unaryList != null && !unaryList.isEmpty()) {
            sb.append("unaryList=").append(unaryList);
        }

        if (operator != null && !operator.isEmpty()) {
            if (unaryList != null && !unaryList.isEmpty()) sb.append(", ");
            sb.append("operator=").append(operator);
        }

        sb.append('}');
        return sb.toString();
    }
}
