package stacks;

import java.util.*;

public class StackMinMax {
    private int[] stack = new int[100];
    private int[] minStack = new int[100];
    private int countStack = 0, countMinStack = 0, trackStack = 0, trackMinStack = 0;

    public void push(int item) {
        stack[countStack] = item;
        trackStack = stack[countStack];
        countStack++;
        if (minStack[countMinStack] == 0 && countMinStack == 0) { // each time when it comes to push method
            // minStack[countMinStack] will have 0 coz at the end of each if statement the
            // countMinstack is increased and it pointing the next index to receive a new
            // item.
            // so always that condition will be true and remaining if statements wont
            // execute.
            // in order to overcome this we add another condition countMinstack == 0 . it
            // will be zero only when there is no element.
            minStack[countMinStack] = trackStack;
            // System.out.println(minStack[countMinStack]);
            countMinStack++;
        } else if (minStack[countMinStack - 1] < trackStack) {
            // int temp1 = countMinStack;
            minStack[countMinStack] = minStack[countMinStack - 1];
            // System.out.println(minStack[countMinStack]);
            countMinStack++;
        } else if (minStack[countMinStack - 1] > trackStack) {
            minStack[countMinStack] = trackStack;
            // System.out.println(minStack[countMinStack]);
            countMinStack++;
        }
    }

    public void pop() {
        int popedElement = stack[countStack - 1];
        // System.out.println(popedElement);
        countStack = countStack - 2;
        countMinStack = countMinStack - 2;
        countMinStack++;
    }

    public int min() {
        // System.out.println(Arrays.toString(minStack));
        return minStack[countMinStack - 1];
    }
}
