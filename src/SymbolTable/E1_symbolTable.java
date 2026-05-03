package SymbolTable;


import MainApp.Error_Type;
import MainApp.Main;
import MainApp.Symantic_Error;

import java.util.Objects;

public class E1_symbolTable extends symbolTable<String>{
    public void insert(String value){
        if (stack!=null){
            Main.id_element++;
            value+="id";
            value+=Main.id_element;
            stack.push(value);

        }else {
            System.out.println("\"Stack not allocated yet!\"");
        }
    }
    public void check_E1(String endtag , int number){
        String startTag = get();
        String endtag2 =endtag+="id"+ Main.id_element;
        if(!Objects.equals(startTag, endtag2)){
            Symantic_Error error = new Symantic_Error();
            error.addError(Error_Type.TAG_MISMATCH ,
                    "Start tag is "+startTag+" and end tag is "+endtag ,
                    String.valueOf(number));
            Main.errors.add(error);
            Main.id_element--;
        }else {
            Main.id_element--;
        }
    }
}
