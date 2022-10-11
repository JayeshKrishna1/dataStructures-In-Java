package stacks;

import java.util.*;

public class RefactoredBalanceParanthesis {
    // by declaring final we can access this anywhere within this class 
    private final List<Character> leftBrackets = Arrays.asList('[','(','{','<');  // asList allows us to declare array list in a easier way
    private final List<Character> rightBrackets = Arrays.asList(']', ')', '}', '>');

    public boolean balace(String str) {
        boolean postive = true;
        boolean negative = false;
        Stack<Character> stack = new Stack<>();
        int length = str.length();
        int i = 0;
        char check;
        while (i < length) {
            check = str.charAt(i);
            if (leftCheck(check)) {
                stack.push(check);
            } else if (rightCheck(check)) {
                if(stack.empty()){// if we do pop operation toa empty stack we will throw a exception
                     throw new IllegalArgumentException();
                }
                char top = stack.pop();
                if (!balanceCheck(check,top)) {
                    return negative;
                }
            }
            i++;
        }
        if (stack.empty())
            return postive;
        return negative;
    }
    private boolean leftCheck(char check){
        return (leftBrackets.contains(check));
    }

    private boolean rightCheck(char check){
        return (rightBrackets.contains(check));
    }

    private boolean balanceCheck(char check,char top){
        return (leftBrackets.indexOf(check) == rightBrackets.indexOf(top));
    }
    
}
