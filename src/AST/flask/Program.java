//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

import java.util.Iterator;
import java.util.List;

public class Program {
    private List<Object> elements;

    public Program(List<Object> var1) {
        this.elements = var1;
    }

    public List<Object> getElements() {
        return this.elements;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder("Program {\n");
        if (this.elements != null) {
            Iterator var2 = this.elements.iterator();

            while(var2.hasNext()) {
                Object var3 = var2.next();
                var1.append("  ").append(var3.toString()).append("\n");
            }
        }

        var1.append("}");
        return var1.toString();
    }
}
