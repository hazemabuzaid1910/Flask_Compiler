package AST.flask;

public class Pair {

    private String key;
    private boolean isStringKey; // لمعرفة هل كان STRING أو IDENTIFIER
    private Expression value;

    public Pair(String key, boolean isStringKey, Expression value) {
        this.key = key;
        this.isStringKey = isStringKey;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public boolean isStringKey() {
        return isStringKey;
    }

    public Expression getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pair{");

        if (key != null) {
            sb.append("key='").append(key).append('\'');
        }

        sb.append(", isStringKey=").append(isStringKey);

        if (value != null) {
            sb.append(", value=").append(value);
        }

        sb.append("}");
        return sb.toString();
    }

}
