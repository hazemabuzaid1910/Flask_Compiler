//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

public class ParamIdentifier implements ParameterFunction {
    String parameter;

    public ParamIdentifier(String var1) {
        this.parameter = var1;
    }

    public String getParameter() {
        return this.parameter;
    }

    public void setParameter(String var1) {
        this.parameter = var1;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("ParamIdentifier{");
        if (this.parameter != null) {
            var1.append("parameter='").append(this.parameter).append("'");
        }

        var1.append("}");
        return var1.toString();
    }
}
