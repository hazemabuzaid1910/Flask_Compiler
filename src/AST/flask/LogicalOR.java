package AST.flask;

import java.util.List;

public class LogicalOR {

    private LogicalAnd first;
    private List<LogicalAnd> rest;

    public LogicalOR(LogicalAnd first, List<LogicalAnd> rest) {
        this.first = first;
        this.rest = rest;
    }

    public LogicalAnd getFirst() {
        return first;
    }

    public List<LogicalAnd> getRest() {
        return rest;
    }

    @Override
    public String toString() {
      StringBuilder sb=new StringBuilder();
      sb.append(first);
      if (rest!=null && !rest.isEmpty()){
          sb.append("rest").append(rest);
      }
      return sb.toString();
    }
}
