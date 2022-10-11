package LinkedList;

import java.util.*;

public class Linkedlist {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(10);
        list.addLast(20);
        list.addLast("jayesh");
        list.addLast(40);
        System.out.println(list.contains("jayesh"));
        System.out.println(list.size());
        list.addFirst(5);
        list.removeLast();
        list.removeFirst();
        System.out.println(list.indexOf("jayesh"));
        System.out.println(list);
        System.out.println(Arrays.toString(list.toArray()));

    }
}