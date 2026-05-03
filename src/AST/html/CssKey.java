package AST.html;

import java.util.List;

public class CssKey {
    String Key;
    List<String> rest;

    public CssKey(String key, List<String> rest) {
        Key = key;
        this.rest = rest;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public List<String> getRest() {
        return rest;
    }

    public void setRest(List<String> rest) {
        this.rest = rest;
    }

    @Override
    public String toString() {
        return "CssKey{" +
                "Key='" + Key + '\'' +
                ", rest=" + rest +
                '}';
    }
}
