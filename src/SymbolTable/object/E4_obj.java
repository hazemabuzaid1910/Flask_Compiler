package SymbolTable.object;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class E4_obj {
    Map<String, String> map;



    public E4_obj(){
        map = new HashMap<>();

    }
    public boolean add(String key, String value){


        if (!map.containsKey(key)){
            map.put(key, value);
            return false;
        }

        return true;
    }


    public Map<String, String> getMap() {
        return map;
    }


}
