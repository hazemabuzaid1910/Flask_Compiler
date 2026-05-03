package AST.flask;

public class PostfixMember implements Postfix{
    String dot;
    String identifier;

    public PostfixMember(String dot, String identifier) {
        this.dot = dot;
        this.identifier = identifier;
    }

    public String getDot() {
        return dot;
    }

    public void setDot(String dot) {
        this.dot = dot;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PostfixMember{");

        boolean hasPrevious = false;

        if (dot != null) {
            sb.append("dot='").append(dot).append("'");
            hasPrevious = true;
        }

        if (identifier != null) {
            if (hasPrevious) sb.append(", ");
            sb.append("identifier='").append(identifier).append("'");
        }

        sb.append("}");
        return sb.toString();
    }

}
