package AST.flask;

import java.util.List;

public class Additive {
List<Multiplicative> multiplicatives;
List<String> operator;

    public Additive(List<Multiplicative> multiplicatives, List<String> operator) {
        this.multiplicatives = multiplicatives;
        this.operator = operator;
    }

    public List<Multiplicative> getMultiplicatives() {
        return multiplicatives;
    }

    public void setMultiplicatives(List<Multiplicative> multiplicatives) {
        this.multiplicatives = multiplicatives;
    }

    public List<String> getOperator() {
        return operator;
    }

    public void setOperator(List<String> operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Additive{");

        if (multiplicatives != null && !multiplicatives.isEmpty()) {
            sb.append("multiplicatives=").append(multiplicatives);
        }

        if (operator != null && !operator.isEmpty()) {
            if (multiplicatives != null && !multiplicatives.isEmpty()) sb.append(", ");
            sb.append("operator=").append(operator);
        }

        sb.append('}');
        return sb.toString();
    }
}
