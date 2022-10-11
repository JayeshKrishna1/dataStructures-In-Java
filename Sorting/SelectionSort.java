package Sorting;

import java.util.Arrays;

// complexity - O(n^2) - quadratic
// hint - sorted array and unsorted array. finding minimum element index and swaping it in ith position.
public class SelectionSort {
    public void sort(int[] array){
        // for passes
        for(int i=0;i<array.length;i++){
            int minIndex = i; //assuming the ith index is the minimum element index
            for(int j=i;j<array.length;j++){ // here we assigned j=i coz we dont need to compare it with the minumum element which already in its right position
                if(array[j]<array[minIndex]){
                    minIndex = j;
                }
            }//by coming out of this loop we will have the index of minimum element in the array
            //we swaping it with the ith index
            int temp = array[i]; //we can use swap method as in bubble sort
            array[i] = array[minIndex];
            array[minIndex] = temp;
            //now ith index has the minimum element and we dont need to compare it for remaining passes
        }
        System.out.println(Arrays.toString(array));
    } 
    
}
