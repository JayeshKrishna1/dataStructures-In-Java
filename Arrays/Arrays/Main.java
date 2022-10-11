package Arrays;

import java.util.Arrays;

// building a dynamic array
public class Main {
    public static void main(String[] args) {
        Array numbers = new Array(3);
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(20);
        numbers.removeAt(0);
        numbers.removeAt(1);
        // numbers.removeAt(5);
        // System.out.println(numbers.indexOf(20));
        // System.out.println(numbers.indexOf(30));
        // System.out.println(numbers.max());
        // System.out.println(numbers.intersect());
        numbers.insertAt(30, 1);
        // numbers.reverse();
        // int[] arr = new int[2];
        // arr[0] =1;
        // arr[1] = arr[1+1];
        // System.out.println(Arrays.toString(arr));
        numbers.print();
    }

}
