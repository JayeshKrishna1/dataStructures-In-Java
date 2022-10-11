package queue;

import java.util.Stack;
import java.util.*;

public class QueueUsingTwoStacks {
    // Q = [10,20,30]
    //enqueue => S1 = [10,20,30]
    //dequeue = > copy s1 to s2 and return the top of s2
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    
    public void enqueue(int item){
        stack1.push(item);
    }
    public int dequeue(){
        //if we try to dequeue a empty queue
        if(stack1.isEmpty() && stack2.isEmpty()){
            throw new IllegalStateException();
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int popedItem = stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return popedItem;
    }
    public void print(){
        
            System.out.print(stack1);
            System.out.println(" ");
    }
}
