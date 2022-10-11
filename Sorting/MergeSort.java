package Sorting;
//complexity - O(nlog n)
/* refer the video and comments to understand */
public class MergeSort {
    public void sort(int[] array) {

        // divide
        if(array.length <2){ //base condition
            return;
        }
        // diving the element by half to find the middle
        int middle = array.length / 2;

        // left subarray
        int[] left = new int[middle];
        for (int i = 0; i < middle; i++) {
            left[i] = array[i];
        }

        // right subarray
        int[] right = new int[array.length - middle];
        for (int i = middle; i < array.length; i++) {
            right[i - middle] = array[i]; //we cant store the elements from middle as it is not the starting index of right array
            //i-middle will start from 0 to desired no of items.
        }

        // sorting subarrays
        sort(left);
        sort(right);

        // merge
        merge(left,right,array);  
    }
    //the work of this is to merge the subsarrays in sorted manner to store in result array and pass result as left/right subarray.this process will continue for all recursive calls.
    private void merge(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0; // 3 variables for checking 3 arrays
        while (i < left.length && j < right.length) { // copying the least element among the ith and jth positions and incrementing copied element array index by 1.
            if (left[i] < right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }
        //to add the remaining elements
        while (i < left.length) {
            result[k++] = left[i++];
        }
            while (j < right.length) {
                result[k++] = right[j++]; //this result array will act as left/right sub array depending on which is calling and executing it and retruns to where
            }
        }
    }

