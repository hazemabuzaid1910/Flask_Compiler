//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST.flask;

public class Literal implements Atom {
     private LiteralType type;
     private Object value;

     public Literal(LiteralType var1, Object var2) {
          this.type = var1;
          this.value = var2;
     }

     public LiteralType getType() {
          return this.type;
     }

     public void setType(LiteralType var1) {
          this.type = var1;
     }

     public Object getValue() {
          return this.value;
     }

     public void setValue(Object var1) {
          this.value = var1;
     }

     public String toString() {
          StringBuilder var1 = new StringBuilder();
          var1.append("Literal{");
          if (this.type != null) {
               var1.append("type=").append(this.type);
          }

          if (this.value != null) {
               if (var1.length() > "Literal{".length()) {
                    var1.append(", ");
               }

               var1.append("value=").append(this.value);
          }

          var1.append("}");
          return var1.toString();
     }
}
