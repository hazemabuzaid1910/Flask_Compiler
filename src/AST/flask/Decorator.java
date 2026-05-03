package AST.flask;

public class Decorator {
    DottedName dottedName;
    ArgumentList argumentList;

    public Decorator(DottedName dottedName, ArgumentList argumentList) {
        this.dottedName = dottedName;
        this.argumentList = argumentList;
    }

    public DottedName getDottedName() {
        return dottedName;
    }

    public void setDottedName(DottedName dottedName) {
        this.dottedName = dottedName;
    }

    public ArgumentList getArgumentList() {
        return argumentList;
    }

    public void setArgumentList(ArgumentList argumentList) {
        this.argumentList = argumentList;
    }

    @Override
    public String toString() {
        return "Decorator{" +
                "dottedName=" + dottedName +
                ", argumentList=" + argumentList +
                '}';
    }
}
