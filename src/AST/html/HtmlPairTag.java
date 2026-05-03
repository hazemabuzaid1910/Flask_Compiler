package AST.html;

import java.util.List;

public class HtmlPairTag implements HtmlTag {
  TagName tagName;
  List<HtmlAttribute> htmlAttributes;
  List<HtmlContent> htmlContents;

    public HtmlPairTag(TagName tagName, List<HtmlAttribute> htmlAttributes, List<HtmlContent> htmlContents) {
        this.tagName = tagName;
        this.htmlAttributes = htmlAttributes;
        this.htmlContents = htmlContents;
    }

    public TagName getHtmlTag() {
        return tagName;
    }

    public void setHtmlTag(TagName htmlTag) {
        this.tagName = htmlTag;
    }

    public List<HtmlAttribute> getHtmlAttributes() {
        return htmlAttributes;
    }

    public void setHtmlAttributes(List<HtmlAttribute> htmlAttributes) {
        this.htmlAttributes = htmlAttributes;
    }

    public List<HtmlContent> getHtmlContents() {
        return htmlContents;
    }

    public void setHtmlContents(List<HtmlContent> htmlContents) {
        this.htmlContents = htmlContents;
    }

    @Override
    public String toString() {
        return "HtmlPairTag{" +
                "htmlTag=" + tagName +
                ", htmlAttributes=" + htmlAttributes +
                ", htmlContents=" + htmlContents +
                '}';
    }
}
