package stacks;

import java.util.Stack;

public class Stacks {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        int top = stack.peek();
        System.out.println(top);
        System.out.println(stack.empty());
        //wehen we wanna do something back then stacks are best for it. like undo,back/forward feature
    }
}
