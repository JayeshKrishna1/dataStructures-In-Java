import java.util.ArrayList;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        BinaryTree tree =  new BinaryTree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        System.out.println("done");
        // System.out.println(tree.Find(2));
        // System.out.println("preOrder");
        // tree.preorder();
        // System.out.println(" ");
        // System.out.println("inOrder");
        // tree.inorder();
        // System.out.println(" ");
        // System.out.println("postOrder");
        // tree.postorder();
        // System.out.println(" ");
        // System.out.println("after deletion it dsiplays the preorder traversal of the tree");
        // System.out.println(" ");
        // tree.delete(7);         
        // System.out.println(" ");
        // tree.delete(10);
        // tree.heightOfTree();
        // tree.minValue();
        BinaryTree tree1 = new BinaryTree();
        tree1.insert(7);
        tree1.insert(4);
        tree1.insert(9);
        tree1.insert(1);
        tree1.insert(6);
        tree1.insert(8);
        tree1.insert(10);
        System.out.println("done");
        System.out.println(tree.equals(tree1));
        // tree.swap();
        System.out.println(tree.isBinarySearchTree());
        ArrayList<Integer> list = tree.NodeAtADistance(2);
        for (int item : list) {
            System.out.println(item);
        }
        tree.levelOder();
        System.out.println(tree.size());
        System.out.println(tree.numberOfLeaves());
        tree.maxValue();
        System.out.println(tree.contains(7));
        // System.out.println(tree.contains(4));
        // System.out.println(tree.contains(9));
        // System.out.println(tree.contains(1));
        // System.out.println(tree.contains(6));
        // System.out.println(tree.contains(8));
        // System.out.println(tree.contains(10));
        System.out.println(tree.isSibilings(1, 10));
        tree.isAncesstors(1);

    }
}