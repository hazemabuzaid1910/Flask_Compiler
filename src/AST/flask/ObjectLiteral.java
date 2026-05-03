package AST.flask;

import java.util.List;

public class ObjectLiteral implements Atom{
    List<Pair> pairList;

    public ObjectLiteral(List<Pair> pairList) {
        this.pairList = pairList;
    }

    public List<Pair> getPairList() {
        return pairList;
    }

    public void setPairList(List<Pair> pairList) {
        this.pairList = pairList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ObjectLiteral{");

        if (pairList != null && !pairList.isEmpty()) {
            sb.append("pairList=").append(pairList);
        }

        sb.append("}");
        return sb.toString();
    }

}
