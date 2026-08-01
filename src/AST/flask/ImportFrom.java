//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

import java.util.List;

public class ImportFrom implements ImportStatement {
    DottedName dottedName;
    List<ImportAlias> importAliases;

    public ImportFrom(DottedName var1, List<ImportAlias> var2) {
        this.dottedName = var1;
        this.importAliases = var2;
    }

    public DottedName getDottedName() {
        return this.dottedName;
    }

    public void setDottedName(DottedName var1) {
        this.dottedName = var1;
    }

    public List<ImportAlias> getImportAliases() {
        return this.importAliases;
    }

    public void setImportAliases(List<ImportAlias> var1) {
        this.importAliases = var1;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("ImportFrom{\n");
        if (this.dottedName != null) {
            var1.append("\t\t").append(this.dottedName);
        }

        if (this.importAliases != null && !this.importAliases.isEmpty()) {
            if (var1.length() > "ImportFrom{".length()) {
                var1.append(", ");
            }

            var1.append("\n\t\t").append(this.importAliases);
        }

        var1.append("\n\t\t}");
        return var1.toString();
    }
}
