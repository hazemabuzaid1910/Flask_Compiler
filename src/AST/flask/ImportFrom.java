package AST.flask;

import java.util.List;

public class ImportFrom implements  ImportStatement{
    DottedName dottedName;
    List<ImportAlias> importAliases;

    public ImportFrom( DottedName dottedName, List<ImportAlias> importAliases) {
        this.dottedName = dottedName;
        this.importAliases = importAliases;
    }



    public DottedName getDottedName() {
        return dottedName;
    }

    public void setDottedName(DottedName dottedName) {
        this.dottedName = dottedName;
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
        sb.append("ImportFrom{\n");

        if (dottedName != null) {
            sb.append("\t\t").append(dottedName);
        }

        if (importAliases != null && !importAliases.isEmpty()) {
            if (sb.length() > "ImportFrom{".length()) sb.append(", ");
            sb.append("\n\t\t").append(importAliases);
        }

        sb.append("\n\t\t}");
        return sb.toString();
    }

}
