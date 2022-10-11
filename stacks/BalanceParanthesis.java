package stacks;

import java.util.Stack;

public class BalanceParanthesis {
    public boolean balace(String str) {
        boolean postive = true;
        boolean negative = false;
        Stack<Character> stack = new Stack<>();
        int length = str.length();
        int i = 0;
        char check;
        while (i < length) {
            check = str.charAt(i);
            if (check == '[' || check == '{' || check == '(' || check == '<') {
                stack.push(check);
            } else if (check == ']' || check == '}' || check == ')' || check == '>') {
                char top = stack.pop();
                if (check == ']' && top != '[' || check == '}' && top != '{' || check == ')' && top != '('
                        || check == '>' && top != '<') {
                    return negative;
                }
            }
            i++;
        }
        if (stack.empty())
            return postive;
        return negative;    
    }

}
