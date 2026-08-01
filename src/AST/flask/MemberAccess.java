//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

public class MemberAccess implements Postfix {
    String value;

    public MemberAccess(String var1) {
        this.value = var1;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return "MemberAccess{value='" + this.value + "'}";
    }
}
