package AST.html;

import java.util.List;

public class CssClass {
    List<CssDeclaration> cssDeclaration;

    public CssClass(List<CssDeclaration> cssDeclaration) {
        this.cssDeclaration = cssDeclaration;
    }

    public List<CssDeclaration> getCssDeclaration() {
        return cssDeclaration;
    }

    public void setCssDeclaration(List<CssDeclaration> cssDeclaration) {
        this.cssDeclaration = cssDeclaration;
    }

    @Override
    public String toString() {
        return "CssClass{" +
                "cssDeclaration=" + cssDeclaration +
                '}';
    }
}
