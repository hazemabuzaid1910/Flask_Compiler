package AST.html;

import AST.flask.DottedName;

public class JinjaExpression {
    DottedName dottedName;

    public JinjaExpression(DottedName dottedName) {
        this.dottedName = dottedName;
    }

    public DottedName getDottedName() {
        return dottedName;
    }

    public void setDottedName(DottedName dottedName) {
        this.dottedName = dottedName;
    }

    @Override
    public String toString() {
        return "JinjaExpression{" +
                "dottedName=" + dottedName +
                '}';
    }
}
