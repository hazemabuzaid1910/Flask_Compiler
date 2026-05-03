package AST.html;

import java.util.List;

public class HtmlSingleTagOpening implements  HtmlSingleTag{
    TagName tagName;
    List<HtmlAttribute> htmlAttributes;

    public HtmlSingleTagOpening(TagName tagName, List<HtmlAttribute> htmlAttributes) {
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
        return "HtmlSingleTagOpening{" +
                "tagName=" + tagName +
                ", htmlAttributes=" + htmlAttributes +
                '}';
    }
}
