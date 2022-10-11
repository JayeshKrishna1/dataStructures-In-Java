package stacks;

import java.util.*;

public class TwoStackUsingOneArray {
    private int[] stack = new int[100];
    private int count1, track1;
    private int count2 = stack.length - 1, track2;

    public void push1(int item) {
        stack[count1] = item;
        track1 = stack[count1];
        count1++;
    }

    public int pop1() {
        track1 = stack[count1 - 2]; // after pushing one element count1 will be
        // incremented so count1 will have one value more than the no of stack elements.

        return stack[--count1];
    }

    public int peek1() {
        return track1;
    }

    public String print1() {
        if (count1 == 0) {
            throw new NoSuchElementException();
        }
        int[] content = Arrays.copyOfRange(stack, 0, count1);
        return Arrays.toString(content);
    }

    // we are using the array from end for the next stack
    public void push2(int item) {
        // System.out.println(stack.length-1);
        stack[count2] = item;
        track2 = stack[count2];
        count2--;
    }

    public int pop2() {
        if(count2+2 == stack.length-1 || count2 == stack.length-1 || count2+1 == stack.length-1){
            track2 = 0; // if we have only one item or no item the else part operation will throw an error of array index out of bound exception
        }
        else{

            track2 = stack[count2 + 2];
        }
        return stack[++count2];
    }

    public int peek2() {
        return track2;
    }

    public void print2() {
        // int[] content1 = Arrays.copyOfRange(stack, count2 , stack.length);
        // return Arrays.toString(content1);
        if(count2 == stack.length-1){
            throw new NoSuchElementException();
        }
        for (int k = stack.length - 1; k > count2; k--) {
            System.out.print(" "+stack[k]);
        }
        System.out.println("");
    }
}   
