package practice;

import java.util.Arrays;

public class Linked {
    private class Node{
        private int data;
        private Node next;

        private Node(int data){
            this.data = data;
        }
    }
    private Node first;
    private Node last;
    public void addLast(int item){
        Node node = new Node(item);
        if(first == null ){
            first = last = node;
        }
        last.next = node;
        last = node;
    }
    public void addFirst(int item){
        Node node = new Node(item);
        if(first == null){
            first = last = node;
        }
        node.next = first;
        first = node;
    }
    public void addAtIndex(int index,int item){
        Node current = first;
        Node prev = null;
        int i = 0;
        while(i != index){
            prev = current;
            current = current.next;
            i++;
        }
        Node node = new Node(item);
        prev.next = node;
        node.next = current;

    }
    public void removeFirst(){
        if(first == null){
            return;
        }
        // first = first.next;
        Node current = first.next;
        first.next = null;
        first = current;
    }
    public void removeLast(){
        Node current = first;
        while(current.next.next != null){
            current=current.next;
        }
        last = current;
        current.next = null;
    }
    public void removeAtIndex(int index){
        Node current = first;
        int i=0;
        while(i!=index-1){
            current = current.next;
        }
        Node next = current.next;
        current.next = current.next.next;
        next.next = null;
    }
    public void reverse(){
        Node prev = first;
        Node current = first.next;
        Node next = current.next;

        prev.next = null;
        last = prev;
        while(current.next != null){
            current.next = prev;
            prev = current;
            current = next;
            next = current.next;
        }
        current.next = prev;
        first = current;
    }
    public void print(){
        Node current= first;
        int count = 0;
        while(current != null){
            // System.out.println(current.data);
            count++;
            current = current.next;
        }
        current = first;
        int[] data = new int[count];
        int i=0;
        while (current != null) {
            // System.out.println(current.data);
            data[i] = current.data;
            i++;
            current = current.next;
        }
        System.out.println(Arrays.toString(data));
    }
    public int kthNodeFromEnd(int k){
        Node current;
        Node next;
        current = next =first;
        int i = k-1;
        while(i != 0){
            next = next.next;
            i--;
        }
        while(next.next != null){
            current = current.next;
            next = next.next;
        }
        return current.data;
    }
    public int middleOfLinkedList(){
        Node slow = first;
        Node fast = first;
        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
    public boolean hasCycle(){
        // last.next=first;
        Node slow;
        Node fast;
        slow = fast = first;
        while(true){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
            if( fast == null){
                break;
            }
        }
        return false;
    }
    
}
