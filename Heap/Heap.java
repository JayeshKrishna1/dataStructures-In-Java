public class Heap {
    private int[] items = new int[10];
    private int size;

    public void insert(int value){
        //if array is full
        if(size == items.length){
            throw new IllegalArgumentException();
        }
        //imagine uisng array here
        //   10
        //  7  6
        //if we want to find leftchild and rightchild of 10
        // assuming 10's position in array as index
        //leftchild of 10 = (index * 2)+1
        //rightchild of 10 = (index * 2)+2
        //-----------------------------------------
        //if we want to find a parent of a element ,lets say 7
        //assuming 7's position as index
        //parent of 7 = (index -1)/2
        //by this using the element position in array we can calculate its left,right child,parent  
        items[size++] = value; //isertion will always be at last
        int index = size-1;//we want the index of the insertion element for checking the heap property
        int parentIndex = (index-1)/2; //for checking it with parent
        while(index>0 && items[index] > items[parentIndex]){
            swap(index,parentIndex); //if the parent index is smaller then the child then we need to swap
            //we need to continue this process untill the element we inserted satisfies the heap property
            //as after swapping our element will be at parentindex
            //so we need to calculate the parent of that element with respect to that current position of the element
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    public int remove(){
        //In heap we can remove only the first element and bubble down
        int index = 0; 
        int removedElement = items[index]; //for returning the removed element
        int lastElement = items[--size];//the last element need to be moved to the removed element position
        items[index] = lastElement;
        int leftchild = (index*2)+1;//we wanna check the new starting element with its left and right child if starting element is smaller than its child we wanna do bubble down
        //we want to check the greatest element among the child and need to swap the new starting element with the greatest one
        int rightchild = (index*2)+2;
        while(index <= size && items[leftchild] > items[index] && items[rightchild] > items[index]){
            int requiredIndexForSwap;
            if(items[leftchild] > items[rightchild]){
                requiredIndexForSwap = leftchild;
            }
            else{
                requiredIndexForSwap = rightchild;
            }
            swap(index,requiredIndexForSwap);
            //we need to do this process untill we find the correct position where the starting element is greater tahn its both childs
            index = requiredIndexForSwap; //we want to calculate childs for element which moved to the new index 
            leftchild = (index * 2) + 1;
            rightchild = (index * 2) + 2;

        }
        return removedElement;
    }
    
    private void swap(int first,int second){
        int temp =items[first];
        items[first] = items[second];
        items[second] = temp;
    }
    public void print(){
        for(int i=0;i<items.length;i++){
            System.out.print(items[i]+" ");
        }
    }
}
