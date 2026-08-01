//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

public class StmtFunction implements Statement {
    FunctionDef functionDef;

    public StmtFunction(FunctionDef var1) {
        this.functionDef = var1;
    }

    public FunctionDef getFunctionDef() {
        return this.functionDef;
    }

    public void setFunctionDef(FunctionDef var1) {
        this.functionDef = var1;
    }

    public String toString() {
        return  "StmtFunction{:"  +"\n  " + (this.functionDef) + "\n}";
    }
}
