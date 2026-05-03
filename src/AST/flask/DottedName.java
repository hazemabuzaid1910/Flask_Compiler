package AST.flask;

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
        StringBuilder sb = new StringBuilder();
        sb.append("DottedName{");

        boolean hasPrevious = false;

        if (first != null) {
            sb.append("first='").append(first).append("'");
            hasPrevious = true;
        }

        if (rest != null && !rest.isEmpty()) {
            if (hasPrevious) sb.append(", ");
            sb.append("rest=").append(rest);
        }

        sb.append("}");
        return sb.toString();
    }

}
