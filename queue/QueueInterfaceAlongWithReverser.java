package queue;

import java.util.ArrayDeque;
import java.util.Stack;

public class QueueInterfaceAlongWithReverser {
    public static void main(String[] args) {
        // Queue is an interface in java it only contains the declaration of methods.
        // many classes like linked list,ArrayDequeue implements Queue interface.
        // ArrayDequeue refers double ended queue which is the normal queue with front
        // and rear.
        // queue applications : printers,os,web servers,live stream.

        // ArrayDeque<Integer> queue = new ArrayDeque<>();
        // queue.add(10);
        // queue.add(20);
        // queue.add(30);
        // System.out.println(queue);
        // int front = queue.remove();
        // System.out.println(front);
        // System.out.println(queue);

        // reverser(queue);

        // QueueUsingArray queue = new QueueUsingArray(5);
        // queue.enqueue(10);
        // queue.enqueue(20);
        // queue.enqueue(30);
        // queue.enqueue(40);
        // queue.enqueue(50);
        // // queue.enqueue(60);
        // queue.print();
        // System.out.println(queue.dequeue());
        // System.out.println(queue.dequeue());
        // System.out.println(queue.dequeue());
        // System.out.println(queue.dequeue());
        // // System.out.println(queue.dequeue());
        // // System.out.println(queue.dequeue());
        // queue.print();
        // System.out.println(queue.peek());
        // queue.print();

        // CircularArray queue = new CircularArray(5);
        // queue.enqueue(10);
        // queue.enqueue(20);
        // queue.enqueue(30);
        // queue.enqueue(40);
        // queue.enqueue(50);
        // queue.dequeue();
        // queue.dequeue();
        // queue.enqueue(60);
        // queue.enqueue(70);
        // queue.enqueue(80);
        // System.out.println(queue.toString());  // we cant use print method coz of front and rear positions
        
        // QueueUsingTwoStacks  queue = new QueueUsingTwoStacks();
        // queue.enqueue(10);
        // queue.enqueue(20);
        // queue.enqueue(30);
        // queue.print();
        // System.out.println(queue.dequeue());
        // queue.print();
        // queue.enqueue(40);
        // queue.print();
        // System.out.println(queue.dequeue());
        // queue.print(); 
        // System.out.println(queue.dequeue());
        // System.out.println(queue.dequeue());
        // System.out.println(queue.dequeue());

        // PriorityQueue queue = new PriorityQueue();
        // queue.enqueue(5);
        // queue.enqueue(1);
        // queue.enqueue(2);
        // queue.enqueue(4);
        // queue.enqueue(3);
        // // queue.enqueue(10);
        // while(!queue.isEmpty()){

        //     System.out.println(queue.dequeue()); 
        // }
        // System.out.println(queue.toString());  
    }
    //reverse a queue using stack
    public static void reverser(ArrayDeque<Integer> queue){// queue is instance of class which is of Integer type 
        Stack<Integer> stack = new Stack<>();
        while(!queue.isEmpty()){
            stack.push(queue.remove());
        }
        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }
        System.out.println(queue);
    }
}
