package AST.flask;

public class PostfixCall implements Postfix {
    ArgumentList argumentList;

    public PostfixCall(ArgumentList var1) {
        this.argumentList = var1;
    }

    public ArgumentList getArgumentList() {
        return this.argumentList;
    }

    public void setArgumentList(ArgumentList var1) {
        this.argumentList = var1;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("PostfixCall{");
        if (this.argumentList != null) {
            var1.append("argumentList=").append(this.argumentList);
        }

        var1.append("}");
        return var1.toString();
    }
}