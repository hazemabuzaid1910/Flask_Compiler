package AST.html;

import java.util.List;

public class HtmlSingleTagSelfClosing implements HtmlSingleTag{
   TagName tagName;
   List<HtmlAttribute> htmlAttributes;

    public HtmlSingleTagSelfClosing(TagName tagName, List<HtmlAttribute> htmlAttributes) {
        this.tagName = tagName;
        this.htmlAttributes = htmlAttributes;
    }

    public TagName getTagName() {
        return tagName;
    }

    public void setTagName(TagName tagName) {
        this.tagName = tagName;
    }

    public List<HtmlAttribute> getHtmlAttributes() {
        return htmlAttributes;
    }

    public void setHtmlAttributes(List<HtmlAttribute> htmlAttributes) {
        this.htmlAttributes = htmlAttributes;
    }

    @Override
    public String toString() {
        return "HtmlSingleTagSelfClosing{" +
                "tagName=" + tagName +
                ", htmlAttributes=" + htmlAttributes +
                '}';
    }
}
