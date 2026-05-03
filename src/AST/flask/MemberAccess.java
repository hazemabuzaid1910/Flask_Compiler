package AST.flask;

public class MemberAccess implements Postfix{
String value;

    public MemberAccess(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "MemberAccess{" +
                "value='" + value + '\'' +
                '}';
    }
}
