//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

import java.util.List;

public class ImportSimple implements ImportStatement {
    String importKeyword;
    List<ImportAlias> importAliases;

    public ImportSimple(String var1, List<ImportAlias> var2) {
        this.importKeyword = var1;
        this.importAliases = var2;
    }

    public String getImportKeyword() {
        return this.importKeyword;
    }

    public void setImportKeyword(String var1) {
        this.importKeyword = var1;
    }

    public List<ImportAlias> getImportAliases() {
        return this.importAliases;
    }

    public void setImportAliases(List<ImportAlias> var1) {
        this.importAliases = var1;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("ImportSimple{\n");
        if (this.importKeyword != null) {
            var1.append("\t\t_import='").append(this.importKeyword).append("'");
        }

        if (this.importAliases != null && !this.importAliases.isEmpty()) {
            if (var1.length() > "ImportSimple{".length()) {
                var1.append(", ");
            }

            var1.append("\n\t\timportAliases=").append(this.importAliases);
        }

        var1.append("\n\t\t}");
        return var1.toString();
    }
}
