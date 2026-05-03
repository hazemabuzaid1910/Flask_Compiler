package AST.html;

public class IfStatement implements JinjaStatement{
    IfBlock ifBlock;

    public IfStatement(IfBlock ifBlock) {
        this.ifBlock = ifBlock;
    }

    public IfBlock getIfBlock() {
        return ifBlock;
    }

    public void setIfBlock(IfBlock ifBlock) {
        this.ifBlock = ifBlock;
    }

    @Override
    public String toString() {
        return "IfStatement{" +
                "ifBlock=" + ifBlock +
                '}';
    }
}
