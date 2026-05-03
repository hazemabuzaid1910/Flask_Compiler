package AST.flask;

public class Literal implements Atom{
     private LiteralType type;  // ENUM: STRING, NUMBER, NONE, TRUE, FALSE
     private Object value;

     public Literal(LiteralType type, Object value) {
          this.type = type;
          this.value = value;
     }

     public LiteralType getType() {
          return type;
     }

     public void setType(LiteralType type) {
          this.type = type;
     }

     public Object getValue() {
          return value;
     }

     public void setValue(Object value) {
          this.value = value;
     }

     @Override
     public String toString() {
          StringBuilder sb = new StringBuilder();
          sb.append("Literal{");

          if (type != null) {
               sb.append("type=").append(type);
          }

          if (value != null) {
               if (sb.length() > "Literal{".length()) sb.append(", ");
               sb.append("value=").append(value);
          }

          sb.append("}");
          return sb.toString();
     }

}
