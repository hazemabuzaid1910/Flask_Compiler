package SymbolTable;

import MainApp.Error_Type;
import MainApp.Main;
import MainApp.Symantic_Error;
import SymbolTable.object.E2_obj;
import SymbolTable.object.E4_obj;

import java.util.Map;

public class E4_symbolTable extends symbolTable<E4_obj>{
    public void insert(){
        if (stack!=null){
            E4_obj newscope=new E4_obj();
            stack.push(newscope);

        }
        else {
            System.out.println("Stack not allocated yet!");
        }
    }
    public boolean add(String key,String value){

        if(stack!=null){

            stack.peek().add(key, value);
            return true;
        }

        return false;
    }
    public boolean exists_E4(String value){

            if (stack.peek().getMap().containsKey(value)) {
                return true;
            }


        return false;
    }
    public boolean check_E4(String value, int line){

        if(stack == null || stack.isEmpty()){
            return false;
        }

            if(stack.peek().getMap().containsKey(value)){
                return true;
            }

          if (stack.firstElement().getMap().containsKey(value)){
              return true;
          }

        Symantic_Error error = new Symantic_Error();
        error.addError(
                Error_Type.VAR_NOT_EXIST,
                "The variable " + value + " is Undeclared",
                String.valueOf(line)
        );

        Main.errors.add(error);

        return false;
    }
}