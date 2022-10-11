package Searching;

public class BinarySearchItertaive {
    public boolean search(int[] array,int element){
        int left = 0;
        int right = array.length -1;
        while(left<=right){
            int middle = (left+right)/2;
            if(element < array[middle]){
                left = 0;
                right = middle-1;
            }
            else if(element > array[middle]){
                left = middle+1;
                right = array.length-1;
            }
            else if(element == array[middle]){
                return true;
            }
        }
        return false;
    }
    
}
