//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

public class Unary {
    Primary primary;

    public Unary(Primary var1) {
        this.primary = var1;
    }

    public Primary getPrimary() {
        return this.primary;
    }

    public void setPrimary(Primary var1) {
        this.primary = var1;
    }

    public String toString() {
        return "Unary{" + String.valueOf(this.primary) + "}";
    }
}
