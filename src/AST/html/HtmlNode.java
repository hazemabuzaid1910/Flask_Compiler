package AST.html;

import java.util.List;

public class HtmlNode {
    String DOCTYPE;
    List<HtmlContent> htmlContents;

    public HtmlNode( List<HtmlContent> htmlContents) {
        this.htmlContents = htmlContents;
    }


    public List<HtmlContent> getHtmlContents() {
        return htmlContents;
    }

    public void setHtmlContents(List<HtmlContent> htmlContents) {
        this.htmlContents = htmlContents;
    }

    @Override
    public String toString() {
        return "HtmlNode{" +

                ", htmlContents=" + htmlContents +
                '}';
    }
}
