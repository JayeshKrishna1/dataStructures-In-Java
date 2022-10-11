package queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class QueueUsingArray {
    private int[] arr;
    private int front = 0, rear = 0, capacity;

    public QueueUsingArray(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
    }

    public void enqueue(int item) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            arr[rear] = item;
            rear++;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            int dequeuedItem = arr[front];
            front++;
            return dequeuedItem;
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else
            return arr[rear - 1];
    }

    public boolean isEmpty() {
        boolean pos = true;
        boolean neg = false;
        if (front == rear || front > rear)
            return pos;
        else
            return neg;
    }

    public boolean isFull() {
        boolean pos = true;
        boolean neg = false;
        if (rear == capacity) {
            return pos;
        } else
            return neg;
    }
    public void print(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            for(int i = front;i<rear;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println(" ");
        }        
    }
}
