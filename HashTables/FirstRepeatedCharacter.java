import java.util.HashSet;

public class FirstRepeatedCharacter {
    public char charFinder(String str){
        char result = '0';
        HashSet<Character> set = new HashSet<>();
        for(char ch : str.toCharArray()){
            if(!set.contains(ch)){
                set.add(ch);
            }
            else{
                result = ch;
                break;
            }
        }
        return result;
    }
    
}
