package Sorting;

import java.util.Arrays;
//complexity - O(n^2) - quadratic
//hint - taking a card and finding its correct position among the cards in our hand
public class InsertionSort {
    public void sort(int[] array){
        for(int i=1;i<array.length;i++){ // we taking our first card and holding in our hand. and taking next card comparing it with the card in our hand
            int current = array[i]; // as we move the element to right the cuurent element we take will vanish. so we storing it in a variable
            int j= i-1; //we need to start from elemets on left to the current element
            while(j>=0 && array[j]>current){ // itreate upto 0 and need to move the element to right when it is greater than current
                array[j+1] = array[j];
                j--;
            }//after coming out of this loop j will be at the position whose element is smaller than current. we need to add our current next to it
            array[j+1] = current; 
        }
        System.out.println(Arrays.toString(array));
    }
    
}
