package AST.html;

public class TagName {
    String tagName;

    public TagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String toString() {
        return "TagName{" +
                "tagName='" + tagName + '\'' +
                '}';
    }
}
