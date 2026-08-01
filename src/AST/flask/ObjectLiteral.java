//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

import java.util.List;

public class ObjectLiteral implements Atom {
    List<Pair> pairList;

    public ObjectLiteral(List<Pair> var1) {
        this.pairList = var1;
    }

    public List<Pair> getPairList() {
        return this.pairList;
    }

    public void setPairList(List<Pair> var1) {
        this.pairList = var1;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("ObjectLiteral{\n\t\t");
        if (this.pairList != null && !this.pairList.isEmpty()) {
            var1.append("pairList=").append(this.pairList);
        }

        var1.append("}");
        return var1.toString();
    }
}
