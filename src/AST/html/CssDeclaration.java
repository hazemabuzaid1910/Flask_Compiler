package AST.html;

import java.util.List;

public class CssDeclaration {
    CssKey cssKey;
    List<CssValue> cssValues;

    public CssDeclaration(CssKey cssKey, List<CssValue> cssValues) {
        this.cssKey = cssKey;
        this.cssValues = cssValues;
    }

    public CssKey getCssKey() {
        return cssKey;
    }

    public void setCssKey(CssKey cssKey) {
        this.cssKey = cssKey;
    }

    public List<CssValue> getCssValues() {
        return cssValues;
    }

    public void setCssValues(List<CssValue> cssValues) {
        this.cssValues = cssValues;
    }

    @Override
    public String toString() {
        return "CssDeclaration{" +
                "cssKey=" + cssKey +
                ", cssValues=" + cssValues +
                '}';
    }
}
