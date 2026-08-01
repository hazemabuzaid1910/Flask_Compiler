//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

public class ImportAlias {
    private String name;
    private String alias;

    public ImportAlias(String var1, String var2) {
        this.name = var1;
        this.alias = var2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String var1) {
        this.name = var1;
    }

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String var1) {
        this.alias = var1;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("ImportAlias{");
        if (this.name != null) {
            var1.append("name='").append(this.name).append("'");
        }

        if (this.alias != null) {
            if (var1.length() > "ImportAlias{".length()) {
                var1.append(", ");
            }

            var1.append("alias='").append(this.alias).append("'");
        }

        var1.append("}");
        return var1.toString();
    }
}
