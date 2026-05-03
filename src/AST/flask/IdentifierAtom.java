package AST.flask;

public class IdentifierAtom implements Atom{
    String value;

    public IdentifierAtom(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "IdentifierAtom{" +
                "value='" + value + '\'' +
                '}';
    }
}
