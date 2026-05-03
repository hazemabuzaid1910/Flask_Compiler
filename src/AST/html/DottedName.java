package AST.html;

import java.util.List;

public class DottedName {
    String first;
    List<String> rest;

    public DottedName(String first, List<String> rest) {
        this.first = first;
        this.rest = rest;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public List<String> getRest() {
        return rest;
    }

    public void setRest(List<String> rest) {
        this.rest = rest;
    }

    @Override
    public String toString() {
        return "DottedName{" +
                "first='" + first + '\'' +
                ", rest=" + rest +
                '}';
    }
}
