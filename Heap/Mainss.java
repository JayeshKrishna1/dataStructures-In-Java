public class Mainss {
    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(2);
        heap.insert(10);
        heap.insert(5);
        heap.insert(7);
        heap.print();
        System.out.println(" ");
        System.out.println("removed element is "+heap.remove()); 
        // System.out.println(" ");
        heap.print();
    }
    
}
