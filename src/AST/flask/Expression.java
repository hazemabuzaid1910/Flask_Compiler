package AST.flask;

public class Expression implements Postfix {
Comparison comparison;

    public Expression(Comparison comparison) {
        this.comparison = comparison;
    }

    public Comparison getComparison() {
        return comparison;
    }

    public void setComparison(Comparison comparison) {
        this.comparison = comparison;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();


        if (comparison != null) {
            sb.append(comparison);
        }

        return sb.toString();
    }

}
