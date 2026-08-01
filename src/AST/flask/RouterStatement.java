//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

public class RouterStatement {
    DottedName dottedName;
    ArgumentList argumentList;

    public RouterStatement(DottedName var1, ArgumentList var2) {
        this.dottedName = var1;
        this.argumentList = var2;
    }

    public DottedName getDottedName() {
        return this.dottedName;
    }

    public void setDottedName(DottedName var1) {
        this.dottedName = var1;
    }

    public ArgumentList getArgumentList() {
        return this.argumentList;
    }

    public void setArgumentList(ArgumentList var1) {
        this.argumentList = var1;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("RouterStatement{");
        if (this.dottedName != null) {
            var1.append("dottedName=").append(this.dottedName);
        }

        if (this.argumentList != null) {
            if (this.dottedName != null) {
                var1.append(", ");
            }

            var1.append("argumentList=").append(this.argumentList);
        }

        var1.append("}");
        return var1.toString();
    }
}
