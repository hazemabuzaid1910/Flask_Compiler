package AST.flask;

import java.util.List;

public class ArgumentList {
    private List<Argument> arguments;

    public ArgumentList(List<Argument> arguments) {
        this.arguments = arguments;
    }

    public List<Argument> getArguments() {
        return arguments;
    }

    public void setArguments(List<Argument> arguments) {
        this.arguments = arguments;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ArgumentList{\n");

        if (arguments != null && !arguments.isEmpty()) {
            sb.append("  arguments=[\n");
            for (Object arg : arguments) {
                sb.append("    ").append(arg).append("\n");
            }
            sb.append("  ]\n");
        }

        sb.append("}");
        return sb.toString();
    }

}
