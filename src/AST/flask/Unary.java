package AST.flask;

public class Unary {
    Primary primary;

    public Unary(Primary primary) {
        this.primary = primary;
    }

    public Primary getPrimary() {
        return primary;
    }

    public void setPrimary(Primary primary) {
        this.primary = primary;
    }

    @Override
    public String toString() {
        return "Unary{" +
                "primary=" + primary +
                '}';
    }
}
