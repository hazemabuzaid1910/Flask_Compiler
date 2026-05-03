package AST.html;

import java.util.List;

public class CssValue {
    List<String> value;

    public CssValue(List<String> value) {
        this.value = value;
    }

    public List<String> getValue() {
        return value;
    }

    public void setValue(List<String> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CssValue{" +
                "value=" + value +
                '}';
    }
}
