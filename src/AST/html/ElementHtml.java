package AST.html;

public class ElementHtml implements HtmlContent{
    HtmlElement htmlElement;

    public ElementHtml(HtmlElement htmlElement) {
        this.htmlElement = htmlElement;
    }

    public HtmlElement getHtmlElement() {
        return htmlElement;
    }

    public void setHtmlElement(HtmlElement htmlElement) {
        this.htmlElement = htmlElement;
    }

    @Override
    public String toString() {
        return "ElementHtml{" +
                "htmlElement=" + htmlElement +
                '}';
    }
}
