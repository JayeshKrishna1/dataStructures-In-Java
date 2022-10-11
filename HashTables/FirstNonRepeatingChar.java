import java.util.HashMap;

public class FirstNonRepeatingChar {
    public char CharFinder(String str){
        HashMap<Character,Integer> map = new HashMap<>();
        char result = '0';
        for(char ch : str.toCharArray()){
            // if(map.containsKey(ch)){
            //     int count  = map.get(ch);
            //     map.put(ch,count+1);
            // }
            // else{
            //     map.put(ch,1);
            // }
            //we can simplify the above if else by using ternary operator
            int count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch,count+1);
        }
        System.out.println(map);
        for(char ch : str.toCharArray()){
            int count = map.get(ch);
            if(count == 1){
                 result = ch;
                break;
            }
        }
        return result;
    }
    
}
