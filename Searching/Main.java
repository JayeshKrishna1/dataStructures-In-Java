package Searching;

public class Main {
    public static void main(String[] args) {
        // LinearSearch search = new LinearSearch();
        // int[] array = {3,44,2,4,1,6};
        // System.out.println(search.search(array, 0));
        
        BinarySearchItertaive search = new BinarySearchItertaive();
        int[] array = { 1,2,3,4,5,6,7,8 };
        System.out.println(search.search(array, 1));
    }
    
}
