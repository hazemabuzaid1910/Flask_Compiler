package AST.html;

import java.util.List;

public class IfBlock {
    private String ConditionVariable;   // product
    List<HtmlContent> htmlContents;

    public IfBlock(String conditionVariable, List<HtmlContent> htmlContents) {
        ConditionVariable = conditionVariable;
        this.htmlContents = htmlContents;
    }

    public String getConditionVariable() {
        return ConditionVariable;
    }

    public void setConditionVariable(String conditionVariable) {
        ConditionVariable = conditionVariable;
    }

    public List<HtmlContent> getHtmlContents() {
        return htmlContents;
    }

    public void setHtmlContents(List<HtmlContent> htmlContents) {
        this.htmlContents = htmlContents;
    }

    @Override
    public String toString() {
        return "IfBlock{" +
                "ConditionVariable='" + ConditionVariable + '\'' +
                ", htmlContents=" + htmlContents +
                '}';
    }
}
