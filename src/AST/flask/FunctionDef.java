package AST.flask;

public class FunctionDef {
    String func_name;
    ParameterList parameterList;
    Block block;

    public FunctionDef( String func_name, ParameterList parameterList, Block block) {
        this.func_name = func_name;
        this.parameterList = parameterList;
        this.block = block;
    }


    public String getFunc_name() {
        return func_name;
    }

    public void setFunc_name(String func_name) {
        this.func_name = func_name;
    }

    public ParameterList getParameterList() {
        return parameterList;
    }

    public void setParameterList(ParameterList parameterList) {
        this.parameterList = parameterList;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FunctionDef{");

        if (func_name != null) {
            sb.append("func_name='").append(func_name).append("'");
        }

        if (parameterList != null) {
            if (sb.length() > "FunctionDef{".length()) sb.append(", ");
            sb.append("parameterList=").append(parameterList);
        }

        if (block != null) {
            if (sb.length() > "Block{".length()) sb.append(", ");
            sb.append("Block=").append(block);
        }

        sb.append("}");
        return sb.toString();
    }

}
