package AST.flask;

public class ParamIdentifier implements ParameterFunction{
    String parameter;

    public ParamIdentifier(String parameter) {
        this.parameter = parameter;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ParamIdentifier{");

        if (parameter != null) {
            sb.append("parameter='").append(parameter).append("'");
        }

        sb.append("}");
        return sb.toString();
    }

}
