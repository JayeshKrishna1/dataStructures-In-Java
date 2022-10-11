import java.util.List;
import java.util.*;

public class BinaryTree {
    //creating a node
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value){
            this.value = value;
        }
    }

    private Node root;
    
    public void insert(int value){
        Node node = new Node(value);
        //we need to find the parent node for this value
        //we are considering the binary search tree

        if(root == null){ //if there is no element in tree
            root = node;
            return;
        }
        Node current = root;
        while(true){
            if(value < current.value){
                if(current.leftChild == null){ //if the node has only one value / if we find th leaf node / base condition for infinite while loop
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }
            else{
                if(current.rightChild == null){
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }

    }
    public boolean Find(int value){
        Node current = root; 
        while(current != null){ 

            if(value < current.value){
                current = current.leftChild;
            }
            else if( value > current.value){
                current = current.rightChild;
            }
            else {
                return true;
            }
        }
        return false;
    }
    //depth first searches
    public void preorder(){ // as we dont know the root in main class ,so  we passing in this method
        preOrder(root);
    }
    private void preOrder(Node root){ // as we call this method in main class we dont know the root. to solve this we can create another method and call this method in that
        
        if(root == null){
            return;
        }
        //root left right
        System.out.print(root.value+" ");
        preOrder(root.leftChild);
        preOrder(root.rightChild);
    }

    public void inorder() { // as we dont know the root in main class ,so we passing in this method
        inOrder(root);
    }

    private void inOrder(Node root) { // as we call this method in main class we dont know the root. to solve this we
                                       // can create another method and call this method in that
        
        if (root == null) {
            return;
        }
        // left root right
        inOrder(root.leftChild);
        System.out.print(root.value+" ");
        inOrder(root.rightChild);
    }

    public void postorder() { // as we dont know the root in main class ,so we passing in this method
        postOrder(root);
    }

    private void postOrder(Node root) { // as we call this method in main class we dont know the root. to solve this we
                                       // can create another method and call this method in that
        
        if (root == null) {
            return;
        }
        // left right root
        postOrder(root.leftChild);
        postOrder(root.rightChild);
        System.out.print(root.value+" ");
    }
    //*********watch striver video*******
    public void delete(int value){
        root = deleteNode(root, value);
         preOrder(root);
    }
    private Node deleteNode(Node root,int value){
        if(root == null){
            return null;
        }
        if(root.value == value){
            return helper(root);
        }
        Node dummy = root;
        while(root != null){
            if(root.value > value && root.leftChild.value == value){
                root.leftChild = helper(root.leftChild);
                break;
            }
            else if(root.value > value){
                root = root.leftChild;
                
            }
            else if (root.value < value && root.rightChild.value == value) {
                root.rightChild = helper(root.rightChild);
                break;
            }
            else if (root.value < value) {
                root = root.rightChild;
                
            }
        }
        return dummy;
    }

    private Node helper(Node root){
        if(root.leftChild == null){
            return root.rightChild;
        }
        else if(root.rightChild == null){
            return root.leftChild;
        }
        Node rightChild = root.rightChild;
        Node lastRight = findLastRight(root.leftChild);
        lastRight.rightChild = rightChild;

        return root.leftChild;
    }

    private Node findLastRight(Node root){
        if(root.rightChild == null){
            return root;
        }
        return findLastRight(root.rightChild);
    }
    public int heightOfTree(){
        if(root == null){
            throw new IllegalStateException();
        }
        int height = height(root);
        // System.out.println(height);
        return height;
    }
    //height of root node = height of tree
    private int height(Node root){
        if (root == null) {
            return -1;
        }
        if(root.leftChild == null && root.rightChild == null){ //condition for a node to be an leaf node.
            return 0; //the height will be zero for leaf node
        }
        return 1 + Math.max(height(root.leftChild), height(root.rightChild)); //formula
    }
    public void minValue(){
        int minValue = min(root);
        System.out.println(minValue);
    }

    private int min(Node root){
        if(root.leftChild == null && root.rightChild == null){
            return root.value;
        }
        int left = min(root.leftChild);
        int right = min(root.rightChild);

        return Math.min(Math.min(left, right),root.value); //we are finding the min value among child and comapring it with parent.By this we find the min value in one subtree
        
    }
    public boolean equals(BinaryTree other){ //we are getting an object which is class data type
        return equals(root,other.root);
    }
    private boolean equals(Node first,Node second){
        if(first == null && second == null){
            return true; //both trees leaf node leftChild and rightChild should be null
        }
        if(first != null && second!=null){

            return (first.value == second.value) && //first value must be equal 
            equals(first.leftChild, second.leftChild) &&  //we gonna recursively call both trees left part
            equals(first.rightChild, second.rightChild);  // we gonna recursively call both trees right part
        }
        return false;
    }
    public void swap(){
        Node temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }
    //in validating bst we visit nodes more than one time so we use different method which will traverse a node only once
    //preOrder traversal is used
    public boolean isBinarySearchTree(){
        return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE); //In Integer wrapper class we have MINVAlue and Maxvalue which gives minimum and maximum values in an integer.
    }
    private boolean isBST(Node root,int min,int max){
        //empty tree is BSt
        if(root == null){
            return true;
        }
        //if the value in node is less than specified the min value or greater than specified max value then its violating the rule.
        if(root.value < min || root.value > max){
            return false;
        }
        return isBST(root.leftChild, min,root.value - 1) && isBST(root.rightChild, root.value+1, max); 
    }
    //node at k distance from root
    //eg : print all nodes that are at a distance of 3 from root
    public ArrayList<Integer> NodeAtADistance(int distance){
        ArrayList<Integer> list = new ArrayList<Integer>();
        NodeAtDistance(root, distance, list); //as arrays pass by reference we dont need to return
        return list;
    }
    private void NodeAtDistance(Node root,int distance,ArrayList<Integer> list){
        //we wanna reach root is null
        if(root == null){
            return;
        }
        //when distance becomes zero we print
        //if we want nodes at distance 3 then we decrement the distance when we go one level down
        //eg : if we want to travel 10km to reach destination then we start reducing from 10km. for each km we travel distance is reduced by 1.by distance 0 we will be at destination
        //the same applies here
        if(distance  == 0){
            list.add(root.value);
            return;
        }
        NodeAtDistance(root.leftChild,distance-1,list);
        NodeAtDistance(root.rightChild, distance-1, list);
    }
    public void levelOder(){
        for(int i=0;i<=heightOfTree();i++){
            ArrayList<Integer> list = NodeAtADistance(i);
            for (int  item : list) {
                System.out.println(item);
            }
        }
    }
    //size of a bst is number of nodes
    public int size(){
        ArrayList<Integer> list = new ArrayList<>();
        list = helperForSize(root,list);
        int size = list.size();
        return size;
    }
    private ArrayList<Integer> helperForSize(Node root,ArrayList<Integer> list){
        if(root == null){
            return list;
        }
        else{
            //preorder   
            list.add(root.value);
            helperForSize(root.leftChild, list);
            helperForSize(root.rightChild, list);
        }
        return list;
    }
    public int numberOfLeaves(){
        int count =0;
        count = noOfLeaves(root);
        return count;
    }
    private int noOfLeaves(Node root){
        if(root == null){
            return 0;
        }
        if(root.leftChild == null && root.rightChild == null){
            return 1;
        }
        
         return noOfLeaves(root.leftChild) + noOfLeaves(root.rightChild);
        
    }
    
    public void maxValue() {
        int maxValue = max(root);
        System.out.println(maxValue);
    }

    private int max(Node root) {
        if (root.leftChild == null && root.rightChild == null) {
            return root.value;
        }
        int left = max(root.leftChild);
        int right = max(root.rightChild);

        return Math.max(Math.max(left, right), root.value); // we are finding the max value among child and comapring it
                                                            // with parent.By this we find the max value in one subtree

    }
    
    public boolean contains(int value) {
        return containsvalue(root,value);
    }

    private boolean containsvalue(Node root, int value) {
       if(root == null){
           return false;
       }
        Node current = root;
        while(current != null){
            if(current.value == value){
                return true;
            }
            else if(value < current.value){

                current = current.leftChild;
            }
            if(current.value == value){
                return true;
            }
            else if(value > current.value){

                current = current.rightChild;
            }
        }
        return false;
    }
    public boolean isSibilings(int first,int second){
        return Sibilings(root,first,second);
    }
    private boolean Sibilings(Node root, int first,int second) {
        if (root == null) {
            return false;
        }
        if(root.leftChild == null && root.rightChild == null){
            return false;
        }
       return (root.leftChild.value == first && root.rightChild.value == second) ||
              (root.rightChild.value == second && root.leftChild.value == first) ||
              Sibilings(root.leftChild, first, second) || 
              Sibilings(root.rightChild, first, second); //if any of the node becomes true output will become true;
    }
    public boolean isAncesstors(int value){
        return ancesstors(root, value);
    }
    private boolean ancesstors(Node root,int value){
        if(root == null){
            return false;
        }
        if(root.value == value){
            return true;
        }
        if(ancesstors(root.leftChild,value) || ancesstors(root.rightChild, value)){
            System.out.println(root.value);
            return true;
        }
        return false;
    }  
    
    public List<Integer> getAncesstors(int value) {
        List<Integer> list = new ArrayList<>();
        return getAncesstors(root, value, list);
    }

    private List<Integer> getAncesstors(Node root, int value, List<Integer> list) {
        // if(root.leftChild.value == value || root.rightChild.value == value){
        // list.add(root.value);
        // return list;
        // }
        if (root == null) {
            return list;
        }
        if (root.leftChild == null || root.rightChild == null) {
            return list;
        }
        if (root.leftChild.value == value || root.rightChild.value == value) {
            list.add(root.value);
            return list;
        }
        getAncesstors(root.leftChild, value, list);
        if (root.leftChild.value == value || list.contains(root.leftChild.value)
                || list.contains(root.rightChild.value)) {
            if (!list.contains(root.value))
                list.add(root.value);
        }
        getAncesstors(root.rightChild, value, list);
        if (root.rightChild.value == value || list.contains(root.leftChild.value)
                || list.contains(root.rightChild.value)) {
            if (!list.contains(root.value))
                list.add(root.value);
        }
        return list;
    }
   
  }



