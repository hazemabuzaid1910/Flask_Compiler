package MainApp;

import SymbolTable.E1_symbolTable;
import SymbolTable.E2_symbolTable;
import SymbolTable.E3_symbolTable;

import java.io.FileWriter;
import java.io.IOException;

public class check_Symantic_Error {
    private final E1_symbolTable tagStack=new E1_symbolTable();
    private final E2_symbolTable funStack=new E2_symbolTable();
    private final E3_symbolTable thisVariable=new E3_symbolTable();


    public check_Symantic_Error() {
        tagStack.allocate();
        funStack.allocate();
        thisVariable.allocate();

    }

    public E1_symbolTable getE1() {
        return tagStack;
    }
    public E2_symbolTable getE2(){
        return funStack;
    }
    public E3_symbolTable getE3(){
        return thisVariable;
    }
    public void  check_Errors(){
        try {

            FileWriter test;
            if(Main.first){
                test =  new FileWriter("Result\\Semantic.txt" , false);
            }else{
                test = new FileWriter("Result\\Semantic.txt", true);
                test.append("Another file : \n");
            }
            if (!Main.errors.isEmpty()){
                test.append("Semantic Check : \n");
                for (Symantic_Error error :Main.errors) {
                    test.append(error.getError()).append("\n");
                }
            }else {
                test.append("No Semantic Error");
            }
            test.flush();
            test.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.first = false ;
    }

}
