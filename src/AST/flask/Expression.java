package AST.flask;

public class Expression implements Postfix {

    private Object left;
    private String operator;
    private Object right;


    // للتعبيرات البسيطة مثل DATA_FILE أو "hello"
    public Expression(Object left) {
        this.left = left;
    }


    // للتعبيرات مثل a + b أو a == b
    public Expression(Object left, String operator, Object right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }


    public Object getLeft() {
        return left;
    }


    public void setLeft(Object left) {
        this.left = left;
    }


    public String getOperator() {
        return operator;
    }


    public void setOperator(String operator) {
        this.operator = operator;
    }


    public Object getRight() {
        return right;
    }


    public void setRight(Object right) {
        this.right = right;
    }


    @Override
    public String toString() {

        if(operator != null){
            return left + " " + operator + " " + right;
        }

        return left == null ? "" : left.toString();
    }
}