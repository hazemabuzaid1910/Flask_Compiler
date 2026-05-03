package AST.html;

public class HtmlAttribute {
    AttributeKey attributeKey;
    AttributeValue attributeValue;

    public HtmlAttribute(AttributeKey attributeKey, AttributeValue attributeValue) {
        this.attributeKey = attributeKey;
        this.attributeValue = attributeValue;
    }

    public AttributeKey getAttributeKey() {
        return attributeKey;
    }

    public void setAttributeKey(AttributeKey attributeKey) {
        this.attributeKey = attributeKey;
    }

    public AttributeValue getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(AttributeValue attributeValue) {
        this.attributeValue = attributeValue;
    }

    @Override
    public String toString() {
        return "HtmlAttribute{" +
                "attributeKey=" + attributeKey +
                ", attributeValue=" + attributeValue +
                '}';
    }
}

