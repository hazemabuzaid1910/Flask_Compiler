package AST.flask;

public class ImportAlias {
    private String name;
    private String alias;

    public ImportAlias(String name, String alias) {
        this.name = name;
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImportAlias{");

        if (name != null) {
            sb.append("name='").append(name).append("'");
        }

        if (alias != null) {
            if (sb.length() > "ImportAlias{".length()) sb.append(", ");
            sb.append("alias='").append(alias).append("'");
        }

        sb.append("}");
        return sb.toString();
    }

}
