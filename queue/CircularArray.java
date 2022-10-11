package queue;

import java.util.*;

// [10,20,30,40,50]
//   F           R
//after 2 dequeue [10,20,30,40,50] 
//                        F     R
//the first 2 elements are obselete and we can utilze those spaces to add new items instead of creating a new array of more size and copying the old items in it
//  size of array is 5 but in memory it is 0-4 . so when we try to add an element at 5 it should add at 0th index
// 5 - 0 it goes in a order as follows
// 6 - 1  
// 7 - 2
// 8 - 3
// 9 - 4
//10 - 0
//11 - 1
// if we look at the above order it follows a sequence 
// number at the left % length of the array = number at right

public class CircularArray {
    private int[] arr;
    private int front = 0, rear = 0, capacity, count = 0;

    public CircularArray(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
    }

    public void enqueue(int item) {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            arr[rear] = item;
            rear = (rear + 1) % capacity; // notice
            // rear++;
            count++;
        }
    }

    public int dequeue() {
        count--; // notice
        // if we add that in else ,when a dequeue is called after inserting 5 elements
        // the count will be equal to capacity
        // so it goes to if statement and throws exception
        // to avoid that we reducing count at top of the if else statements.
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            int dequeuedItem = arr[front];
            arr[front] = 0;
            front = (front + 1) % capacity; // notice
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
        if (count == capacity) // notice. here we checking using count. as in circular queue front cannot be
                               // always greater than rear

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

    public void print() { // cant be used coz of front and rear positions
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            for (int i = front; i < rear; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println(" ");
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
