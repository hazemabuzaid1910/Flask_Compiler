package SymbolTable.object;

import java.util.HashSet;
import java.util.Set;

public class E2_obj {
    Set<String> set;
    public E2_obj(){
        set=new HashSet<>();
    }
    public boolean add(String value){
    if (set.contains(value)){
        return true;
    }
    else {
        set.add(value);
        return false;
    }
    }
    public Set<String> getSet(){return set;}
}
