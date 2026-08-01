//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

public class FunctionDef {
    String func_name;
    ParameterList parameterList;
    Block block;

    public FunctionDef(String var1, ParameterList var2, Block var3) {
        this.func_name = var1;
        this.parameterList = var2;
        this.block = var3;
    }

    public String getFunc_name() {
        return this.func_name;
    }

    public void setFunc_name(String var1) {
        this.func_name = var1;
    }

    public ParameterList getParameterList() {
        return this.parameterList;
    }

    public void setParameterList(ParameterList var1) {
        this.parameterList = var1;
    }

    public Block getBlock() {
        return this.block;
    }

    public void setBlock(Block var1) {
        this.block = var1;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("FunctionDef{");
        if (this.func_name != null) {
            var1.append("func_name='").append(this.func_name).append("'");
        }

        if (this.parameterList != null) {
            if (var1.length() > "FunctionDef{".length()) {
                var1.append(", ");
            }

            var1.append("parameterList=").append(this.parameterList);
        }

        if (this.block != null) {
            if (var1.length() > "Block{".length()) {
                var1.append(", ");
            }

            var1.append("Block=").append(this.block);
        }

        var1.append("}");
        return var1.toString();
    }
}
