package AST.flask;

public class ListComprehension implements Atom {

    private Expression target;
    private String loopVariable;
    private Expression iterable;
    private Expression condition; // nullable

    public ListComprehension(
            Expression target,
            String loopVariable,
            Expression iterable,
            Expression condition) {

        this.target = target;
        this.loopVariable = loopVariable;
        this.iterable = iterable;
        this.condition = condition;
    }


    public Expression getTarget() {
        return target;
    }

    public void setTarget(Expression target) {
        this.target = target;
    }

    public String getLoopVariable() {
        return loopVariable;
    }

    public void setLoopVariable(String loopVariable) {
        this.loopVariable = loopVariable;
    }

    public Expression getIterable() {
        return iterable;
    }

    public void setIterable(Expression iterable) {
        this.iterable = iterable;
    }

    public Expression getCondition() {
        return condition;
    }

    public void setCondition(Expression condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "ListComprehension{" +
                "target=" + target +
                ", loopVariable='" + loopVariable + '\'' +
                ", iterable=" + iterable +
                ", condition=" + condition +
                '}';
    }
}
