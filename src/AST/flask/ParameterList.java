package AST.flask;

import java.util.List;

public class ParameterList {
    List<ParameterFunction> parameters;

    public ParameterList(List<ParameterFunction> parameters) {
        this.parameters = parameters;
    }

    public List<ParameterFunction> getParameters() {
        return parameters;
    }

    public void setParameters(List<ParameterFunction> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ParameterList{");

        if (parameters != null && !parameters.isEmpty()) {
            sb.append("parameters=").append(parameters);
        }

        sb.append("}");
        return sb.toString();
    }

}
