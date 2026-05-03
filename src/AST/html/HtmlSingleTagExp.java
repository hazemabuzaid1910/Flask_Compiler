package AST.html;

public class HtmlSingleTagExp implements HtmlTag{
HtmlSingleTag htmlSingleTag;

    public HtmlSingleTagExp(HtmlSingleTag htmlSingleTag) {
        this.htmlSingleTag = htmlSingleTag;
    }

    public HtmlSingleTag getHtmlSingleTag() {
        return htmlSingleTag;
    }

    public void setHtmlSingleTag(HtmlSingleTag htmlSingleTag) {
        this.htmlSingleTag = htmlSingleTag;
    }

    @Override
    public String toString() {
        return "HtmlSingleTagExp{" +
                "htmlSingleTag=" + htmlSingleTag +
                '}';
    }
}
