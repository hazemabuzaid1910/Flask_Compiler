package AST.html;

public class IdentifierExpression implements HtmlContent{
    String identifier;

    public IdentifierExpression(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return "IdentifierExpression{" +
                "identifier='" + identifier + '\'' +
                '}';
    }
}
