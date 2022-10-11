package practice;

import java.util.Arrays;

public class Heap {
    private int[] arr = new int[5];
    private int size;
    public void insert(int value){
        if(isFull()){
            throw new IllegalStateException();
        }
        arr[size++] = value;
        int index = size-1;
        while(arr[index] > arr[parentIndex(index)]){
            swap(arr, index, parentIndex(index));
            index = parentIndex(index);
        }
    }
    private boolean isFull(){
        return (size == arr.length);
    }
    public void delete(){
        arr[0] = arr[--size];
        int index =0;
        while(!isValidParent(index)){
            int largerChild = largerChild(index);
            int largerChildIndex = largerChildIndex(largerChild, index);
            if(largerChildIndex < arr.length-1){
                swap(arr,index,largerChildIndex);
                index = largerChildIndex;
            }
            else{
                return;
            }
        } 
    }
    private boolean isValidParent(int index){
        if(!hasLeftChild(index)){
            return true;
        }
        if(!hasRightChild(index)){
            return leftChild(index) <= arr[index];
        }
        return leftChild(index) <= arr[index] || rightChild(index) <= arr[index];
    }
    private boolean hasLeftChild(int index){
        return leftChildIndex(index) <= arr.length-1;
    }
    
    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= arr.length - 1;
    }
    private int largerChildIndex(int largerChild,int index){
        if(!hasLeftChild(index)){
            return index;
        }
        if(!hasRightChild(index)){
            return largerChild == leftChild(index) ? leftChild(index) : index;
        }
        return (largerChild == leftChild(index)) ? leftChildIndex(index) : rightChildIndex(index);
    }
    private int largerChild(int index){
        return (leftChild(index) > rightChild(index)) ? leftChild(index) : rightChild(index);
    }
    private int leftChildIndex(int index){
        return (index*2)+1;
    }
    private int rightChildIndex(int index){
        return (index*2)+2;
    }
    private int parentIndex(int index){
        return (index-1)/2;
    }
    private int leftChild(int index){
        return arr[leftChildIndex(index)];
    }
    private int rightChild(int index){
        return arr[rightChildIndex(index)];
    }
    private int parent(int index){
        return arr[parentIndex(index)];
    }
    private void swap(int[] arr,int first,int second){
        int temp =arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    public void print(){
        int[] result = Arrays.copyOfRange(arr, 0, size);
        System.out.println(Arrays.toString(result));
    }
    
}
