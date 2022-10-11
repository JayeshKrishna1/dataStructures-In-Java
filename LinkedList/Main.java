package LinkedList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        List list = new List();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addLast(5);
        list.addLast(4);
        list.addLast(3);
        // list.reverse();
        // list.addAtIndex(1, 2);
        // list.removeAtIndex(1);
        // list.removeFirst();
        // list.removeLast();
        // System.out.println(list.size());
        // System.out.println(list.indexOf(4));
        // System.out.println(list.contains(5));
        // System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.getKthNode(2));
        System.out.println(Arrays.toString(list.middleNode()));
        System.out.println(list.checkCycle());
        list.print();
        
    }

}
