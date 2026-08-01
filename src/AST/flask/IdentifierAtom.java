//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

public class IdentifierAtom implements Atom {
    String value;

    public IdentifierAtom(String var1) {
        this.value = var1;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String var1) {
        this.value = var1;
    }

    public String toString() {
        return "IdentifierAtom{value='" + this.value + "'}";
    }
}
