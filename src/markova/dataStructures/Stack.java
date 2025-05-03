package markova.dataStructures;

import java.util.ArrayList;
import java.util.List;

public class Stack<T>
{
    private final List<T> stack = new ArrayList<>();

    public void push(T ob){
        stack.add(ob);
    }

    public T pop(){
        if (stack.isEmpty()) return null;
        return stack.removeLast();
    }

    public T peek(){
        if (stack.isEmpty()) return null;
        return stack.getLast();
    }
}
