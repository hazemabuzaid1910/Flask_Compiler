package AST.html;

public class ForStatement implements JinjaStatement{
    ForBlock forBlock;

    public ForStatement(ForBlock forBlock) {
        this.forBlock = forBlock;
    }

    public ForBlock getForBlock() {
        return forBlock;
    }

    public void setForBlock(ForBlock forBlock) {
        this.forBlock = forBlock;
    }

    @Override
    public String toString() {
        return "ForStatement{" +
                "forBlock=" + forBlock +
                '}'
                ;
    }
}
