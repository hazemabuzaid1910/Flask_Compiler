package AST.flask;

public class RouterStatement {
    DottedName dottedName;
    ArgumentList argumentList;

    public RouterStatement( DottedName dottedName, ArgumentList argumentList) {
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
        StringBuilder sb = new StringBuilder();
        sb.append("RouterStatement{");

        if (dottedName != null) {
            sb.append("dottedName=").append(dottedName);
        }
        if (argumentList != null) {
            if (dottedName != null) sb.append(", ");
            sb.append("argumentList=").append(argumentList);
        }

        sb.append("}");
        return sb.toString();
    }

}
