package Searching;
//O(n)
public class LinearSearch {
    public boolean search(int[] array,int element){
        for(int i=0;i<array.length;i++){
            if(array[i] == element)
              return true;
        }
        return false;
    }
}
