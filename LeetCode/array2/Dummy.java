import java.util.*;
public class Dummy{
    public static void main(String[] args) {
        int[][] arr = { { 5, 6 }, { 2, 4 }, { 3, 5 }, { 1, 5 }, { 9, 10 }, { 0, 2 } };
        List<int[]> list = new ArrayList<>(); //way of declaring a list of array
        //In List array in each index we gonna have a int array
        //a 2d array representation
        list.add(new int[]{1,2,3});//check here
        list.add(new int[] { 1, 2, 3 });
        list.add(new int[] { 1, 2, 3 });
        int[][] arr1 = list.toArray(new int[0][]);//check here
        System.out.println(Arrays.deepToString(arr1));
        Integer s=45;
        // System.out.println(s.);
        
    }
}