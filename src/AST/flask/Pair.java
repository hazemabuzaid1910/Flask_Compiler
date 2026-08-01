//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

public class Pair {
    private String key;
    private boolean isStringKey;
    private Expression value;

    public Pair(String var1, boolean var2, Expression var3) {
        this.key = var1;
        this.isStringKey = var2;
        this.value = var3;
    }

    public String getKey() {
        return this.key;
    }

    public boolean isStringKey() {
        return this.isStringKey;
    }

    public Expression getValue() {
        return this.value;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("\n\t\tPair{");
        if (this.key != null) {
            var1.append("key='").append(this.key).append('\'');
        }

        var1.append(", isStringKey=").append(this.isStringKey);
        if (this.value != null) {
            var1.append(", value=").append(this.value);
        }

        var1.append("}");
        return var1.toString();
    }
}
