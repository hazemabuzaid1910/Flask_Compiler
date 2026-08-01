//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

import java.util.List;

public class ParameterList {
    List<ParameterFunction> parameters;

    public ParameterList(List<ParameterFunction> var1) {
        this.parameters = var1;
    }

    public List<ParameterFunction> getParameters() {
        return this.parameters;
    }

    public void setParameters(List<ParameterFunction> var1) {
        this.parameters = var1;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("ParameterList{");
        if (this.parameters != null && !this.parameters.isEmpty()) {
            var1.append("parameters=").append(this.parameters);
        }

        var1.append("}");
        return var1.toString();
    }
}
