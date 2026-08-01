//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

import java.util.ArrayList;
import java.util.List;

public class Primary {
    Atom atom;
    List<Postfix> postfixes;

    public Primary(Atom var1, List<Postfix> var2) {
        this.atom = var1;
        this.postfixes = var2;
    }

    public Atom getAtom() {
        return this.atom;
    }

    public void setAtom(Atom var1) {
        this.atom = var1;
    }

    public List<Postfix> getPostfixes() {
        return this.postfixes;
    }

    public void setPostfixes(List<Postfix> var1) {
        this.postfixes = var1;
    }
    public void addPostfix(Postfix postfix) {
        if (postfixes == null) {
            postfixes = new ArrayList<>();
        }

        postfixes.add(postfix);
    }
    public String toString() {
        StringBuilder var1 = new StringBuilder("Primary{");
        if (this.atom != null) {
            var1.append("atom=").append(this.atom);
        }

        if (postfixes != null && !this.postfixes.isEmpty()) {
            if (this.atom != null) {
                var1.append(", ");
                var1.append("postfixes=").append(this.postfixes);

            }

        }

        var1.append('}');
        return var1.toString();
    }
}
