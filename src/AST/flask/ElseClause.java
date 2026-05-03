package AST.flask;

public class ElseClause {

    Block block;

    public ElseClause( Block block) {
        this.block = block;
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
        sb.append("ElseClause{");

        if (block != null) {
            sb.append("block=").append(block);
        }

        sb.append("}");
        return sb.toString();
    }

}
