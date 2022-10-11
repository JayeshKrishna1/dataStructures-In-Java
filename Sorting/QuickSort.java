package Sorting;
// complexity - O(n^2)
//depending on partition it varies. best case - O(log n) ,worst case  - O(n^2)
/*for better clearence watch video */
public class QuickSort {
    public void sort(int[] array,int start,int end){

        if(start >= end) //base condition
        // start == end when there is one element
        //start > end when array is emepty . if we pass start as 0 and end as array.length-1 now start > end  
          return;
        //partition
        int boundary = partition(array,start,end);
        //now for sorting left and right we need range for that we introducing start and end
        
        //sort left
        sort(array,start,boundary-1);
        
        //sort right
        sort(array,boundary+1,end);
    }
    // for partititn we use 2 pointers one for itertaing till end/boundary
    //another for keeping track of  partition boundary
    //pivot is taken as the last element
    private int partition(int[] array,int start,int end){
        int pivot = array[end];
        int boundary = start-1;
        for(int i=start;i<=end;i++){
            if(array[i]<= pivot){
                // int temp = array[++boundary];
                // array[boundary]= array[i];
                // array[i] = temp;
                swap(array,i,++boundary);
            }
        }
        return boundary;
    }

    private void swap(int[] arra,int index1,int index2){
        int temp = arra[index1];
        arra[index1] = arra[index2];
        arra[index2] = temp;
    } 
}
