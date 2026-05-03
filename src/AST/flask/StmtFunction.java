package AST.flask;

public class StmtFunction implements Statement{
    FunctionDef functionDef;

    public StmtFunction(FunctionDef functionDef) {
        this.functionDef = functionDef;
    }

    public FunctionDef getFunctionDef() {
        return functionDef;
    }

    public void setFunctionDef(FunctionDef functionDef) {
        this.functionDef = functionDef;
    }

    @Override
    public String toString() {
        if (functionDef == null) {
            return "StmtFunction{}";
        }
        return "StmtFunction{\n  " + functionDef + "\n}";
    }

}
