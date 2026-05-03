package AST.flask;

public class PostfixCall implements Postfix{
    ArgumentList argumentList;

    public PostfixCall(ArgumentList argumentList) {
        this.argumentList = argumentList;
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
        sb.append("PostfixCall{");

        if (argumentList != null) {
            sb.append("argumentList=").append(argumentList);
        }

        sb.append("}");
        return sb.toString();
    }

}
