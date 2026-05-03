package SymbolTable;

import java.util.Stack;

public abstract class symbolTable<T> {
    protected Stack<T> stack;

    public void allocate(){
        stack=new Stack<>();
    }
    public T get(){
      if(stack!=null && !stack.isEmpty()){
    return stack.pop();
     }
      else{
    System.out.println("Stack is Empty or not allocated");
    return null;
}
    }
}
