package AST.flask;

// في AST/flask/IndexAccess.java
// في ملف Postfix/IndexAccess.java (أو حيث توجد كلاسات Postfix)
public class IndexAccess implements Postfix {
    private Expression indexExpression;

    public IndexAccess(Expression indexExpression) {
        this.indexExpression = indexExpression;
    }

    public Expression getIndexExpression() {
        return indexExpression;
    }

    @Override
    public String toString() {
        return "IndexAccess[" + indexExpression + "]";
    }
}
