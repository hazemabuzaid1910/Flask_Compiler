package AST.flask;

import java.util.List;




import java.util.List;

public class Additive {
    List<Multiplicative> multiplicatives;
    List<String> operator;

    public Additive(List<Multiplicative> var1, List<String> var2) {
        this.multiplicatives = var1;
        this.operator = var2;
    }

    public List<Multiplicative> getMultiplicatives() {
        return this.multiplicatives;
    }

    public void setMultiplicatives(List<Multiplicative> var1) {
        this.multiplicatives = var1;
    }

    public List<String> getOperator() {
        return this.operator;
    }

    public void setOperator(List<String> var1) {
        this.operator = var1;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder("Additive{");
        if (this.multiplicatives != null && !this.multiplicatives.isEmpty()) {
            var1.append(this.multiplicatives);
        }

        if (this.operator != null && !this.operator.isEmpty()) {
            if (this.multiplicatives != null && !this.multiplicatives.isEmpty()) {
                var1.append(", ");
            }

            var1.append("operator=").append(this.operator);
        }

        var1.append('}');
        return var1.toString();
    }
}
