package Sorting;

import java.util.Arrays;

import Arrays.Array;
// complexity - O(n^2) - quadratic
//hint - max element is bubbled to the end in every pass
public class BubbleSort {
    public void sort(int[] array) {
        // for passes
        for (int i = 0; i < array.length; i++) { //O(n)
            // if array is sorted we need to stop ,so we declare a bollean var to check
            boolean isSorted = true; // assuming the array is sorted at first
            // for comparisons
            for (int j = 1; j < array.length - i; j++) { //O(n)
                if (array[j - 1] > array[j]) {
                    swap(array,j,j-1); // arrays are passed by refernce so it will swap the array
                    isSorted = false; // if the swap doesnt work it means array is sorted
                }
            }
            if (isSorted) {
                System.out.println(Arrays.toString(array));
                return;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    private void swap(int[] arra,int index1,int index2){
        int temp = arra[index1];
        arra[index1] = arra[index2];
        arra[index2] = temp;
    }

}
