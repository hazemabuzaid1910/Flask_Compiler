package AST.html;

import java.util.List;

public class ForBlock implements JinjaStatement{

    private String loopVariable;   // product
    private String iterableName;   // products
    List<HtmlContent> htmlContents;

    public ForBlock(String loopVariable, String iterableName, List<HtmlContent> htmlContents) {
        this.loopVariable = loopVariable;
        this.iterableName = iterableName;
        this.htmlContents = htmlContents;
    }

    public String getLoopVariable() {
        return loopVariable;
    }

    public void setLoopVariable(String loopVariable) {
        this.loopVariable = loopVariable;
    }

    public String getIterableName() {
        return iterableName;
    }

    public void setIterableName(String iterableName) {
        this.iterableName = iterableName;
    }

    public List<HtmlContent> getHtmlContents() {
        return htmlContents;
    }

    public void setHtmlContents(List<HtmlContent> htmlContents) {
        this.htmlContents = htmlContents;
    }

    @Override
    public String toString() {
        return "ForBlock{" +
                "loopVariable='" + loopVariable + '\'' +
                ", iterableName='" + iterableName + '\'' +
                ", htmlContents=" + htmlContents +
                '}';
    }
}
