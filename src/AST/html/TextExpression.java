package AST.html;

public class TextExpression implements HtmlContent{
    Text text;

    public TextExpression(Text text) {
        this.text = text;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TextExpression{" +
                "text=" + text +
                '}';
    }
}
