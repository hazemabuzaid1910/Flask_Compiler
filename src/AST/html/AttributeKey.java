package AST.html;

public class AttributeKey {
    String attributeKey;

    public AttributeKey(String attributeKey) {
        this.attributeKey = attributeKey;
    }

    public String getAttributeKey() {
        return attributeKey;
    }

    public void setAttributeKey(String attributeKey) {
        this.attributeKey = attributeKey;
    }

    @Override
    public String toString() {
        return "AttributeKey{" +
                "attributeKey='" + attributeKey + '\'' +
                '}';
    }
}
