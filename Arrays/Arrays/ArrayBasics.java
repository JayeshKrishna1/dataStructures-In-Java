package Arrays;
// package Arrays;

import java.util.Arrays;

public class ArrayBasics {
    public static void main(String[] args) {
        int[] numbers = new int[3];
        System.out.println(numbers);// returns a random string with type and starting address of the object
        // we have Arrays class and toString method which converts all elements of array
        // to string and we can print it
        System.out.println(Arrays.toString(numbers));

        // inserting elements
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        System.out.println(Arrays.toString(numbers));

        // if we need to add one more item its not possible . we need to create one more
        // array with size 4 and we need to copy old elements
        // into the new array and add the new element .

        // if we know the elements before the start we can initialize like below
        int[] number = { 10, 20, 30, 40 };
        System.out.println(Arrays.toString(number));
        numbers = number; // we can copy arrays like copying variables in java
        System.out.println(Arrays.toString(numbers));
    }

}
