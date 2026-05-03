package AST.html;

import java.util.List;

public class Text implements HtmlContent{
    List<String> text;

    public Text(List<String> text) {
        this.text = text;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Text{" +
                "text=" + text +
                '}';
    }
}
