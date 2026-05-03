package AST.flask;

import java.util.List;

public class DecoratorStatement {
    Decorator decorators;

    FunctionDef functionDef;

    public DecoratorStatement(Decorator decorators, FunctionDef functionDef) {
        this.decorators = decorators;
        this.functionDef = functionDef;
    }

    public Decorator getDecorators() {
        return decorators;
    }

    public void setDecorators(Decorator decorators) {
        this.decorators = decorators;
    }

    public FunctionDef getFunctionDef() {
        return functionDef;
    }

    public void setFunctionDef(FunctionDef functionDef) {
        this.functionDef = functionDef;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DecoratorStatement{");

        boolean hasPrevious = false;

        if (decorators != null) {
            sb.append("\n  routerStatement=").append(decorators);
            hasPrevious = true;
        }

        if (functionDef != null) {
            if (hasPrevious) sb.append(",");
            sb.append("\n  functionDef=").append(functionDef);
        }

        sb.append("\n}");
        return sb.toString();
    }

}
