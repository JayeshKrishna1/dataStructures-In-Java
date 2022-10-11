package Sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // BubbleSort sort = new BubbleSort();
        // int[] array = {7,3,6,9,2,5};
        // sort.sort(array);

        // SelectionSort sort = new SelectionSort();
        // int[] array = {7,3,6,9,2,5};
        // sort.sort(array);

        // InsertionSort sort = new InsertionSort();
        // int[] array = {7,3,6,9,2,5};
        // sort.sort(array);

        // MergeSort sort = new MergeSort();
        // int[] array = { 7, 3, 6, 9, 2, 5 };
        // sort.sort(array);
        // System.out.println(Arrays.toString(array));

        QuickSort sort = new QuickSort();
        int[] array = { 7, 3, 6, 9, 2, 5 };
        sort.sort(array,0,5);
        System.out.println(Arrays.toString(array));
    }
    
}
