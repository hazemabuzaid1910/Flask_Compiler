package AST.flask;

import java.util.List;

public class ImportSimple implements ImportStatement {
    String importKeyword;
    List<ImportAlias> importAliases;

    public ImportSimple(String importKeyword, List<ImportAlias> importAliases) {
        this.importKeyword = importKeyword;
        this.importAliases = importAliases;
    }



    public String getImportKeyword() {
        return importKeyword;
    }

    public void setImportKeyword(String importKeyword) {
        this.importKeyword = importKeyword;
    }

    public List<ImportAlias> getImportAliases() {
        return importAliases;
    }

    public void setImportAliases(List<ImportAlias> importAliases) {
        this.importAliases = importAliases;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImportSimple{");

        if (importKeyword != null) {
            sb.append("_import='").append(importKeyword).append("'");
        }

        if (importAliases != null && !importAliases.isEmpty()) {
            if (sb.length() > "ImportSimple{".length()) sb.append(", ");
            sb.append("importAliases=").append(importAliases);
        }

        sb.append("}");
        return sb.toString();
    }

}
