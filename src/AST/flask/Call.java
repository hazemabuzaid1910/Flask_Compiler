package AST.flask;

public class Call implements Postfix {

    private ArgumentList argumentList;

    public Call(ArgumentList argumentList) {
        this.argumentList = argumentList;
    }

    public ArgumentList getArgumentList() {
        return argumentList;
    }

    @Override
    public String toString() {
        return "Call{"  + argumentList +
                '}';
    }
}