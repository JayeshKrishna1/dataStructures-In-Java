package LinkedList;

import java.util.NoSuchElementException;

public class List {
    private class Node {
        private int value;
        private Node next;

        private Node(int item) {
            this.value = item;
        }
    }

    private Node First;
    private Node Last;

    // add at the first
    public void addFirst(int item) {
        Node node = new Node(item);
        // 1. list is empty
        if (First == null) {
            First = Last = node;
        } else {
            node.next = First;
            First = node;
        }
    }

    // add at the last
    public void addLast(int item) {
        Node node = new Node(item);
        // 1. list is empty
        if (First == null) {
            First = Last = node;
        } else {
            Last.next = node;
            Last = node;
        }
    }

    // add at a particular index
    public void addAtIndex(int index, int item) {
        Node node = new Node(item);
        int count = 0;
        Node current = First;
        while (count != index - 1) {
            current = current.next;
            count++;
        }
        Node nextNode = current.next;
        current.next = node;
        node.next = nextNode;
    }

    // remove at first
    public void removeFirst() {
        if (First == null) {
            throw new NoSuchElementException();
        } else {
            Node current = First.next;
            First.next = null;
            First = current;
        }
    }

    // remove at last
    public void removeLast() {
        if (First == null) {
            throw new NoSuchElementException();
        } else if (First == Last) {
            First = Last = null;
            return;
        } else {
            Node current = First;
            while (current.next != Last) {
                current = current.next;
            }
            Node previous = current;
            previous.next = null;
            Last = previous;
        }
    }

    // remove at a particular index
    public void removeAtIndex(int index) {
        int count = 0;
        Node current = First;
        while (count != index - 1) {
            current = current.next;
            count++;
        }
        Node nextNode = current.next;
        current.next = nextNode.next;
        nextNode.next = null;
    }

    // size
    public int size() {
        int count = 0;
        if (First == null) {
            throw new NoSuchElementException();
        } else {
            Node current = First;
            while (current != null) {
                current = current.next;
                count++;
            }
        }
        return count;
    }

    // indexOf
    public int indexOf(int item) {
        int index = 0;
        Node current = First;
        while (current.value != item) {
            current = current.next;
            index++;
        }
        return index;
    }

    // contains
    public Boolean contains(int item) {
        boolean positive = true;
        boolean negative = false;
        Node current = First;
        while (current != null) {
            if (current.value == item) {
                return positive;
            }
            current = current.next;
        }
        return negative;
    }

    // toArray
    public int[] toArray() {
        int size = size();
        int index = 0;
        int[] array = new int[size];
        Node current = First;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    // reverse a linked list
    public void reverse() {
        // checking the empty condition
        if (First == null) {
            throw new NoSuchElementException();
        }
        // ********we need 3 variables of type Node*******
        // 1) [10 -> 20 -> 30] 2)[10 <- 20 30] 3)[10 <- 20 <- 30]
        // p c n p c n p c n
        // the stopping condition of the loop is current node = null
        Node prev, curr, next;
        prev = First;
        curr = First.next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // we need to change the first and last node
        Last = First;
        Last.next = null;
        First = prev;
    }

    // get the kth node from the end of the list in one pass
    public int getKthNode(int k) {
        // mostly all linked list problems can be solved with 2 pointers
        // assume a list 10->20->30->40->50
        // k=1 => 50 k =2 => 40 k= 3 => 30
        // we can have 2 points which are k-1 distance away
        // if k= 3 then they are 2 nodes apart
        // 10->20->30->40->50
        // * * we need to itarate and when 2nd pointer reaches end we will have our
        // required node
        Node a, b;
        a = First;
        b = First;
        for (int i = 0; i < k - 1; i++) { // to move the 2nd pointer to the required position ie., k-1
            b = b.next;
        }
        while (b != Last) {
            a = a.next;
            b = b.next;
        }
        System.out.println(a.value);
        return a.value;
    }

    // middle node of the list
    public int[] middleNode() {
        Node slowTortoise, FastTortoise, prev; // slow gonna move by 1 node where as the fast gonna move by 2
        int count = 0; // to check whether the list has odd or even number of nodes
        slowTortoise = FastTortoise = prev = First;
        while (FastTortoise != null && FastTortoise.next != null) { //either of these two cases happen we can say that the loop reaches the end of the list
            prev = slowTortoise; // in case of even we need to return 2 nodes
            slowTortoise = slowTortoise.next;
            FastTortoise = FastTortoise.next.next;
            count++;
        }
        if (count % 2 == 0) {
            int[] ans = { slowTortoise.value };
            return ans;
        } else {
            int[] ans = { prev.value, slowTortoise.value };
            return ans;
        }
    }

    //check cycle
    public boolean checkCycle(){
        boolean positive = true;
        boolean negative = false;
        Node SlowTortoise,FastTortoise;
        SlowTortoise = FastTortoise = First;
        while (FastTortoise != null && FastTortoise.next != null) { 
            SlowTortoise = SlowTortoise.next;
            FastTortoise = FastTortoise.next.next;
            if(SlowTortoise == FastTortoise){ // if exsist a loop at some point they will meet.
                return positive;
            }
        }
        return negative;
    }
    // print
    public void print() {
        if (First == null) {
            throw new NoSuchElementException();
        } else {

            Node current = First;
            while (current != null) {
                System.out.println(current.value);
                current = current.next;
            }
        }

    }
}
