import java.util.HashSet;

public class RemovingDuplicatesInArray {
    public void removeDuplicate(int[] arr){
        //sets store only keys and all are unique which means it wont allow duplicate
        HashSet<Integer> set = new HashSet<>();
        for(int number : arr){
            set.add(number);
        }
        System.out.println(set);
    }
    
}
