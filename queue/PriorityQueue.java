package queue;
import java.nio.channels.IllegalSelectorException;
import java.util.*;
public class PriorityQueue {
    //queue = [10,20,30,0,0]
    // after enqueue 15 => [10,15,20,30,0] copying the element to next index if it is smaller.if greater we need to insert item next to it
    // we need to iterate the elements from end and perform copy inorder not to lose the element
    //if we copy from front we will lose the element at the place where we copied
    private int[] arr = new int[5];
    private int count=0;
    public void enqueue(int item){
        if(count == arr.length){
            throw new IllegalStateException();
        }
        int i;
        for( i = count-1;i>=0;i--){
            if(arr[i]> item){
                arr[i+1] = arr[i];
            }
            else{
                break;
            }
        }
        arr[i+1] = item;
        count++;
    }
    public int dequeue(){
        if(count == 0){
            throw new IllegalSelectorException();
        }
        //returning the least priority
        return arr[--count];
    }
    public boolean isEmpty(){
        boolean pos = true;
        boolean neg = false;
        if(count == 0){
            return pos;
        }
        else{
            return neg;
        }
    }
    @Override
    public String toString(){
        return Arrays.toString(arr);
    }
    
}
