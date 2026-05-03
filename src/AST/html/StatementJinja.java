package AST.html;

public class StatementJinja implements HtmlContent {
    JinjaStatement jinjaStatement;

    public StatementJinja(JinjaStatement jinjaStatement) {
        this.jinjaStatement = jinjaStatement;
    }

    public JinjaStatement getJinjaStatement() {
        return jinjaStatement;
    }

    public void setJinjaStatement(JinjaStatement jinjaStatement) {
        this.jinjaStatement = jinjaStatement;
    }

    @Override
    public String toString() {
        return "StatementJinja{" +
                "jinjaStatement=" + jinjaStatement +
                '}';
    }
}
