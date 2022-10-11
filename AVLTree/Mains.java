public class Mains {
    public static void main(String[] args) {
        AvlTree tree = new AvlTree();
        tree.insert(10);
        tree.insert(30);
        tree.insert(20);
        //we can use any one of traversal
        System.out.println(tree.isBalance());  
        System.out.println(tree.isPerfect());
         
    }
    
}
