package MainApp;

import SymbolTable.*;

import java.io.FileWriter;
import java.io.IOException;

public class check_Symantic_Error {
    private final E1_symbolTable tagStack=new E1_symbolTable();
    private final E2_symbolTable funStack=new E2_symbolTable();
    private final E3_symbolTable thisVariable=new E3_symbolTable();
    private  final E4_symbolTable Variable=new E4_symbolTable();
    private final E5_symbolTable FlaskMissingVariable=new E5_symbolTable();
    private final E6_symbolTable TypeError=new E6_symbolTable();
    public check_Symantic_Error() {
        tagStack.allocate();
        funStack.allocate();
        thisVariable.allocate();
        Variable.allocate();
        FlaskMissingVariable.allocate();
        TypeError.allocate();

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
    public E4_symbolTable getE4(){
        return Variable;
    }
    public E5_symbolTable getE5(){
        return FlaskMissingVariable;
    }
    public E6_symbolTable getE6(){return TypeError;}
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
