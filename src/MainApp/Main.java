package MainApp;

import AST.flask.Program;
import SymbolTable.E2_symbolTable;
import antler.FlaskLexer;
import antler.FlaskParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import Visitor.Visitor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Symantic_Error> errors = new ArrayList<>();
    public static check_Symantic_Error semanticError = new check_Symantic_Error();

    public static boolean first = true;
  public static int id_element=0;
    public static void main(String[] args) throws IOException {
//    FlaskLexer lexer = new FlaskLexer(CharStreams.fromFileName("input.py"));
//    CommonTokenStream tokens = new CommonTokenStream(lexer);
//
//        tokens.fill();
//        for (Token token : tokens.getTokens()) {
//            String tokenName = FlaskLexer.VOCABULARY.getSymbolicName(token.getType());
//            System.out.println(tokenName + ": '" + token.getText().replace("\n", "\\n") + "'");
//        }

        String filePath = "C:/Users/hazem/OneDrive/Desktop/4/minmax/Compiler/project/app.py";

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("الملف غير موجود!");
            return;
        }

        // ================================
        // إعداد Lexer و Parser
        // ================================
        FlaskLexer lexer = new FlaskLexer(CharStreams.fromFileName(filePath));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FlaskParser parser = new FlaskParser(tokens);

        // ================================
        // استخراج ParseTree
        // ================================
        ParseTree tree = parser.program();

        // ================================
        // زيارة الشجرة باستخدام Visitor
        // ================================
        Visitor visitor = new Visitor();
        Program programAst = (Program) visitor.visit(tree);

        semanticError.check_Errors();
        // ================================
        // طباعة AST الناتجة
        // ================================
        System.out.println("========== AST ==========");
        System.out.print(programAst);

        semanticError = new check_Symantic_Error() ;
        errors = new ArrayList<>();
    }
}
