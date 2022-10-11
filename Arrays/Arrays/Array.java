package Arrays;
// package Arrays;

import java.util.*;

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    // insert method
    public void insert(int item) {
        // if array is full we need to resize it and add
        if (count == items.length) {
            // we need to create a new array with size bigger than the old one
            int[] newItems = new int[count * 2];
            // we need to copy old array items to new array
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            // we need to copy new array to old array
            items = newItems;
        }
        // if array is not full we need to add at end
        items[count++] = item;
    }

    // removeAt method
    public void removeAt(int index) {
        // index exsist or not
        if (index > count) {
            throw new IllegalArgumentException();
        }
        if (count == items.length) {
            for (int i = index; i < count - 1; i++) {
                items[i] = items[i + 1];
            }
            count = count - 1;
            return;
        }
        if (index < count) {
            // shift the elements by one left
            for (int i = index; i < count; i++) {
                items[i] = items[i + 1];
            }
            // if we have [10,20,30,40] after removing 20(that is after executing above
            // code) the array becomes [10,30,40,40]
            // to remove the last item we do count --;
            count = count - 1;
        }
    }

    // indexOf method
    public int indexOf(int item) {
        // if item exsist return index else -1
        for (int i = 0; i < count; i++) {
            if (item == items[i]) {
                return i;
            }
        }
        return -1;
    }

    // max method
    public int max() {
        int maxItem = items[0];
        for (int i = 1; i < count; i++) {
            if (maxItem < items[i]) {
                maxItem = items[i];
            }
        }
        return maxItem;
    }

    // intersect method
    public String intersect() {
        int specificCount = 0;
        String value = "-1";
        int[] commonItems = new int[items.length];
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if (items[i] == items[j] ) {
                    commonItems[specificCount++] = items[i];
                }
            }
        }
        if (specificCount != 0) {

            return Arrays.toString(commonItems);
        } else {
            return value;
        }
    }
    //removing duplicates
    public void removeDuplicates(){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < items.length; i++) {
            set.add(items[i]);
        }
        System.out.println(set);
        // set.toArray();
    }
    // insertAt
    public void insertAt(int item, int index) {
        int[] addedItems = new int[count+1];
        for (int i = 0; i < count; i++) {
            addedItems[i] = items[i];
        }
        System.out.println(Arrays.toString(addedItems));
        for (int i = count; i >= 0; i--) {
            if (i != index) {

                addedItems[i] = addedItems[i - 1];
            }
            else{

                addedItems[i] = item;
                break;
            }
        }
        System.out.println(Arrays.toString(addedItems));
        items = addedItems;
        count++;
    }

    // reverse method
    public void reverse() {
        int index = 0;
        int[] reverseArray = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            reverseArray[index++] = items[i];
        }
        System.out.println(Arrays.toString(reverseArray));
    }

    // print method
    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

}
