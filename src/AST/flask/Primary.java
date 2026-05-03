package AST.flask;

import java.util.List;

public class Primary {
Atom atom;
List<Postfix> postfixes;

    public Primary(Atom atom, List<Postfix> postfixes) {
        this.atom = atom;
        this.postfixes = postfixes;
    }

    public Atom getAtom() {
        return atom;
    }

    public void setAtom(Atom atom) {
        this.atom = atom;
    }

    public List<Postfix> getPostfixes() {
        return postfixes;
    }

    public void setPostfixes(List<Postfix> postfixes) {
        this.postfixes = postfixes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Primary{");

        if (atom != null) {
            sb.append("atom=").append(atom);
        }

        if (postfixes != null && !postfixes.isEmpty()) {
            if (atom != null) sb.append(", ");
            sb.append("postfixes=").append(postfixes);
        }

        sb.append('}');
        return sb.toString();
    }
}
