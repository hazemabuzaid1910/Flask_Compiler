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
        sb.append("ImportSimple{\n");

        if (importKeyword != null) {
            sb.append("\t\t_import='").append(importKeyword).append("'");
        }

        if (importAliases != null && !importAliases.isEmpty()) {
            if (sb.length() > "ImportSimple{".length()) sb.append(", ");
            sb.append("\n\t\timportAliases=").append(importAliases);
        }

        sb.append("\n\t\t}");
        return sb.toString();
    }

}
