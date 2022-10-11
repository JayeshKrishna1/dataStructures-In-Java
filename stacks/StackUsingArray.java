package stacks;

import java.util.Arrays;

public class StackUsingArray {
    private int[] stack = new int[100];
    private int i=0;
    private int track=0; // for peek method
    public void push(int item){
        stack[i] = item;
        track = stack[i];
        i++;
    }

    public int pop(){
        int j =i-2;
        track = stack[j];
        return stack[--i];
    }

    public int peek(){
        return track;
    }

    public boolean isEmpty(){
        boolean pos = true;
        boolean neg = false;
        if(i == 0){
            return pos;
        }
        return neg;

    }

    public String print(){
        int[] content = Arrays.copyOfRange(stack,0,i);// the last element wont copy . it will copy excluding the third argument
        return Arrays.toString(content);
    }
    
}
