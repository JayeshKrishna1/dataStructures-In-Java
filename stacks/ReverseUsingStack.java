package stacks;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ReverseUsingStack {
    public String reverser(String input) {
        Stack<String> stack = new Stack<>();
        // System.out.println(str);
        int length = input.length();
        // System.out.println(length);
        int i=0;
        // System.out.println(str.charAt(0));
        // System.out.println(str.valueOf(str.charAt(0)));    
        while(i<length){
            stack.push(input.valueOf(input.charAt(i))); //valueOf method retruns a string of a char argument.
            i++;
        }
        i--;
        int j=0;
        String[] str = new String[++i];//if we declare it as Staring[5] it will allocate only 5 string space as i has a value of 5.
        // so we declare as ++i to allocate 6 space.
        while(i>0){
            str[j]=stack.pop(); 
            i--;
            j++;
        }
        StringBuilder stringbuilder = new StringBuilder(); // for converting [1,2,3] to "123" or ['j','a','y','e','s','h'] to "jayesh"
        for(i=0;i<str.length;i++){
            stringbuilder.append(str[i]);
        }
        // System.out.println(Arrays.toString(str));
        // return Arrays.toString(str);
        return stringbuilder.toString();
    }
}
