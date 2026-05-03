package AST.flask;

import java.util.List;

public class ArrayLiteral implements Atom{
List<Expression> expressions;

    public ArrayLiteral(List<Expression> expressions) {
        this.expressions = expressions;
    }

    public List<Expression> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<Expression> expressions) {
        this.expressions = expressions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ArrayLiteral{\n");

        if (expressions != null && !expressions.isEmpty()) {
            sb.append("  expressions=[\n");
            for (Object expr : expressions) {
                sb.append("    ").append(expr).append("\n");
            }
            sb.append("  ]\n");
        }

        sb.append("}");
        return sb.toString();
    }

}
