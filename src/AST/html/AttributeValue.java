package AST.html;
public class AttributeValue {

    public enum ValueType {
        STRING,
        NUMBER,
        IDENTIFIER
    }

    private String value;
    private ValueType type;

    public AttributeValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public ValueType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "AttributeValue{" +
                ", value='" + value + '\'' +
                '}';
    }
}
