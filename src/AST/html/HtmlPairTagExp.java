package AST.html;

public class HtmlPairTagExp implements HtmlTag{
HtmlPairTag htmlPairTag;

    public HtmlPairTagExp(HtmlPairTag htmlPairTag) {
        this.htmlPairTag = htmlPairTag;
    }

    public HtmlPairTag getHtmlPairTag() {
        return htmlPairTag;
    }

    public void setHtmlPairTag(HtmlPairTag htmlPairTag) {
        this.htmlPairTag = htmlPairTag;
    }

    @Override
    public String toString() {
        return "HtmlPairTagExp{" +
                "htmlPairTag=" + htmlPairTag +
                '}';
    }
}
