package AST.html;

import java.util.List;

public class CssClassExpression implements HtmlContent{
    List<CssClass> cssClasses;

    public CssClassExpression(List<CssClass> cssClasses) {
        this.cssClasses = cssClasses;
    }

    public List<CssClass> getCssClasses() {
        return cssClasses;
    }

    public void setCssClasses(List<CssClass> cssClasses) {
        this.cssClasses = cssClasses;
    }

    @Override
    public String toString() {
        return "CssClassExpression{" +
                "cssClasses=" + cssClasses +
                '}';
    }
}
