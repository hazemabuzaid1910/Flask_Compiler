//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

public class PostfixMember implements Postfix {
    String dot;
    String identifier;

    public PostfixMember(String var1, String var2) {
        this.dot = var1;
        this.identifier = var2;
    }

    public String getDot() {
        return this.dot;
    }

    public void setDot(String var1) {
        this.dot = var1;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String var1) {
        this.identifier = var1;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("PostfixMember{");
        boolean var2 = false;
        if (this.dot != null) {
            var1.append("dot='").append(this.dot).append("'");
            var2 = true;
        }

        if (this.identifier != null) {
            if (var2) {
                var1.append(", ");
            }

            var1.append("identifier='").append(this.identifier).append("'");
        }

        var1.append("}");
        return var1.toString();
    }
}
