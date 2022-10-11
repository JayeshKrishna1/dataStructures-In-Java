package practice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

import Arrays.Array;

public class Queues {
    // Queue<Integer> queue = new ArrayDeque<>();
    private int[] arr;
    public Queues(int length){
        arr = new int[length];
    }

    private int front = 0;
    private int rear = 0;
    private int count = 0;
    public void add(int value){
        if(count >= arr.length){
            throw new IllegalStateException();
        }
        if(front == 0 && rear == 0){
            arr[rear] = value;
            // front = rear;
            rear = (rear+1)%arr.length;
            count++;
            return;
        }
        if(front == rear){
            arr[rear] = value;
            rear = (rear + 1) % arr.length;
            count++;
            return;
        }
        arr[rear] = value;
        rear = (rear+1)%arr.length;
        count++;
    }
    public void remove(){
        // if(front == rear){
        //     count--;
        //     front = rear = -1;
        //     return;
        // }
        // for(int i=0;i<count;i++){
        //     arr[i] = arr[i+1];
        // }
        // count--;
        arr[front] = 0;
        front = (front+1)%arr.length;
        count--;
        // rear = count-1;
    }
    public void print(){
        int[] arr1 = Arrays.copyOfRange(arr, front, rear+1);
        // System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
        System.out.println(front+" "+rear);
    }
    public void reverse(){
     Queue<Integer> q = new ArrayDeque<>();
     q.add(10);
     q.add(20);
     q.add(30);
     Stack<Integer> s = new Stack<>();
     while(!q.isEmpty()){
         s.push(q.remove());
     }
     while(!s.isEmpty()){
         q.add(s.pop());
     }   
     System.out.println(q);
    }
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    public void enQueue(int item){
        s1.push(item);
    } 
    public int deQueue(){
        if(s1.isEmpty() && s2.isEmpty()){
            throw new IllegalArgumentException();
        }
        if(s2.isEmpty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    public void PriorityEnQueue(int item){
        if(count >= arr.length){
            throw new IllegalArgumentException();
        }
        if(front == 0 && rear == 0){
            front++;
            rear++;
            arr[rear] = item;
            count++;
            return;
        }
        if(front == rear){
            if(item < arr[rear]){
                arr[rear+1] = arr[rear];
                arr[rear] = item;
                rear++;
                count++;
            }
            else{
                arr[++rear] = item;
                count++;
            }
            return;
        }
        for(int i = rear;i>=front;i--){
            if(item < arr[i]){
                arr[i+1] = arr[i];
            }
            else if(item > arr[i]){
                arr[i+1] = item;
                rear++;
                count++;
                return;
            }
        }
        arr[front] = item;
        count++;
        rear++;
        return;
        
    }
    public int PriorityDequeue(){
        int remove = arr[front];
        front++;
        count--;
        return remove;
    }
    Queue<Integer> q = new ArrayDeque<>();
    public void dummyEnqueue(){
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
    }
    public void reverseFirstKElements(int k){
        Stack<Integer> s3 = new Stack<>();
        int i =k;
        while(i>=1){
            s3.push(q.remove());
            i--;
        }
        while(!s3.empty()){
            q.add(s3.pop());
        }
        // int front = q.peek();
        // System.out.println(front);
        int temp = q.size()-k;
        while(temp > 0){
            q.add(q.remove());
            temp--;
        }
        System.out.print(q);
    }
}
