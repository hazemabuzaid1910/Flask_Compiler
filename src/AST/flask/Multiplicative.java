//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

import java.util.List;

public class Multiplicative {
    List<Unary> unaryList;
    List<String> operator;

    public Multiplicative(List<Unary> var1, List<String> var2) {
        this.unaryList = var1;
        this.operator = var2;
    }

    public List<Unary> getUnaryList() {
        return this.unaryList;
    }

    public void setUnaryList(List<Unary> var1) {
        this.unaryList = var1;
    }

    public List<String> getOperator() {
        return this.operator;
    }

    public void setOperator(List<String> var1) {
        this.operator = var1;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder("Multiplicative{");
        if (this.unaryList != null && !this.unaryList.isEmpty()) {
            var1.append(this.unaryList);
        }

        if (operator != null && !operator.isEmpty()) {
            if (this.unaryList != null && !this.unaryList.isEmpty()) {
                var1.append(", ");
            }

            var1.append("operator=").append(this.operator);
        }

        var1.append('}');
        return var1.toString();
    }
}
