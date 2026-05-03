package AST.flask;

public class StmtDecorator implements Statement{
    DecoratorStatement decoratorStatement;

    public StmtDecorator(DecoratorStatement decoratorStatement) {
        this.decoratorStatement = decoratorStatement;
    }

    public DecoratorStatement getDecoratorStatement() {
        return decoratorStatement;
    }

    public void setDecoratorStatement(DecoratorStatement decoratorStatement) {
        this.decoratorStatement = decoratorStatement;
    }

    @Override
    public String toString() {
        if (decoratorStatement == null) {
            return "StmtDecorator{}";
        }
        return "StmtDecorator{\n  " + decoratorStatement + "\n}";
    }

}
