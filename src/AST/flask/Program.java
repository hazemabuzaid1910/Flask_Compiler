package AST.flask;

import java.util.List;

public class Program {
    private List<Object> elements; // يمكن أن تكون Statement أو BlankLines

    public Program(List<Object> elements) {
        this.elements = elements;
    }

    public List<Object> getElements() {
        return elements;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Program {\n");

        if (elements != null) {
            for (Object element : elements) {
                // إضافة مسافة بادئة (indentation) لجعل الشكل مرتباً
                sb.append("  ").append(element.toString()).append("\n");
            }
        }

        sb.append("}");
        return sb.toString();
    }


}
