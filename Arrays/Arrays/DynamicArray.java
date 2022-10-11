package Arrays;
// package Arrays;

import java.util.*;

public class DynamicArray {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(); // each time an arraylist gets full it grow by 50% ,while vector
                                                     // grow by 100%
        list.add(10);
        list.add(20);
        list.add(30);
        list.remove(0);
        System.out.println(list.indexOf(20));
        System.out.println(list.contains(20));
        System.out.println(list.size());
        System.out.println(Arrays.toString(list.toArray()));// returns an array ie., it converts an arraylist to array
        System.out.println(list);
    }
}
