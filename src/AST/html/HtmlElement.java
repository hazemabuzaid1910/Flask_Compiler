package AST.html;

public class HtmlElement implements HtmlContent{
    HtmlTag htmlTag;

    public HtmlElement(HtmlTag htmlTag) {
        this.htmlTag = htmlTag;
    }

    public HtmlTag getHtmlTag() {
        return htmlTag;
    }

    public void setHtmlTag(HtmlTag htmlTag) {
        this.htmlTag = htmlTag;
    }

    @Override
    public String toString() {
        return "HtmlElement{" +
                "htmlTag=" + htmlTag +
                '}';
    }
}
