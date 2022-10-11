public class AvlTree {
    private class Node{
        int value;
        int height;
        private Node leftChild;
        private Node rightChild;

        public Node(int value){
            this.value = value;
        }
    }

    private Node root;

    //insert a bst using recursion
    public void insert(int value){ // public method to start recursion
        root = insertANode(root, value);
    }

    private Node insertANode(Node root,int value){
        //if no tree
        if(root == null){
            root = new Node(value);
            return root; // as root in here is the parameter in this function and wont get updated in original root we need to return and assign it to the original one
        }
        // 10 first insertion
        //next we wanna insert 20
        // it checks root == null and it becomes false,it checks the if else and executes statement in else,
        //now root becomes null and we create a node with value 20,
        //the recursive call goes back to prev where root is 10. and we wanna add that node to its right
        //if we dont assign and just return it wont get added and the node will be vanished by garbage colllector
        //**********compare it with the iterative approach and check the ase conditions******** 
        if(value < root.value){
            root.leftChild = insertANode(root.leftChild, value); //we need to add that element to the leftchild of root node
        }
        else{
            root.rightChild = insertANode(root.rightChild, value);// we need to add that element to the rightchild of root node
        }
        //for each node in tree this will calculate its height
        root.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1; //basic height formula
        //we can also use setHeight(root);

        //balance factor : height(leftSubtree) - height(rightSubtree) => {-1,0,1}
        root = balance(root);
        return root;
    }
    // a simple method that returns a height a node
    private int height(Node root){
        if(root == null){
            return -1; //it should return -1. very very very important.
        }
        return root.height;
    }
    //a method that returns true if node is leftHeavy
    private boolean isLeftHeavy(Node root){
        if(root == null){
            return false;
        }
        else if(height(root.leftChild) - height(root.rightChild) > 1){
            return true;
        }
        return false;
    }
    // a method that returns true if node is rightHeavy
    private boolean isRightHeavy(Node root) {
        if (root == null) {
            return false;
        } else if (height(root.leftChild) - height(root.rightChild) < -1) {
            return true;
        }
        return false;
    }
    //a method that returns the balance factor of a particular node
    private int balancefactor(Node root){
        return height(root.leftChild) - height(root.rightChild);
    }
    //a method that performs left rotate on a node
    public Node leftrotate(Node root){
        Node newRoot;
        newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;
        //as heights of root and newRoot are changed we need to update it
        //instead of that formula we can create a method that takes root and calculates height .
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }
    public Node rightrotate(Node root){
        Node newRoot;
        newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }
    //a method that calculates height
    public void setHeight(Node root){
        root.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;
    }
    //a method that balances the tree
    public Node balance(Node root){
        int balanceFactor = balancefactor(root);
        if (isLeftHeavy(root)) {
            System.out.println(root.value + " is left heavy");
            if (balancefactor(root.leftChild) > 0) {
                System.out.println(root.value + " needs rightrotation");
                return rightrotate(root);
            } else {
                System.out.println(root.leftChild.value+"  needs left rotation"+root.value+" needs right rotation");
                root.leftChild = leftrotate(root.leftChild); 
                //assuming our tree as like below
                //    30(root)
                //   20
                //     25
                // leftrotate(root.leftchild) ==> in leftrotate the root is 20
                //in leftrotate the tree will be
                // 20(root)
                //   25
                //after leftrotation it will return tree as 
                // 25(root)
                //   20
                //we need to add this to the 30's left if not the root in this wont get updated and as we not assigning it the value returned it will be vanished by java garbage collector

                return rightrotate(root); //this will give balaced root and we returning it to the original root
            }
        } else if (isRightHeavy(root)) {
            System.out.println(root.value + " is right heavy");
            if (balancefactor(root.rightChild) < 0) {
                System.out.println(" it needs leftrotation");
                return leftrotate(root);
            } else {
                System.out.println(root.rightChild.value+" needs right rotation"+root.value+" needs left rotation");
                root.rightChild = rightrotate(root.rightChild);
                //same like in if case
                return leftrotate(root);
            }
        }
        //if not the both case then our root is already balanced so we returning it 
        //after this we need to return root coz root here is not the original root
        return root;
    }
    public boolean isBalance(){
        return Balance(root);
    }
    private boolean Balance(Node root){
        //Navys algo
        if(root == null){
            return true;
        }
        int leftHeight = height(root.leftChild);
        int rightHeight = height(root.rightChild);
        if((leftHeight - rightHeight)> 1 || (leftHeight - rightHeight) <-1 ){
            return false;
        }
        //the above are base condition for a node
        //the below will recursively traverse all nodes
        boolean left = Balance(root.leftChild); //if any one node iteration becomes false this method will return false
        boolean right = Balance(root.rightChild);
        if(!left || !right){ //check this. after iterating left and right subtree of a node it will come here.
            // we wanna condition like below
            //  0 0 =>1
            //  0 1 =>1
            //  1 0 =>1
            //  1 1 =>0
            //we can also use (!(left && right))
            return false;
        }
        return true;
    }
    //a tree is said to be perfect if all leaf nodes are at same level / all nodes except leaf has exactly 2 nodes
    public boolean isPerfect(){
        int height = root.height;
        int level = 0;
        return perfect(root,height,level);
    }
    private boolean perfect(Node root,int depth,int level){
        if(root == null){ //empty tree is perfect bst
            return true;
        }
        if(root.leftChild == null && root.rightChild == null){
            return (depth == level+1);
        }
        if (root.leftChild == null || root.rightChild == null)
            return false;
        return perfect(root.leftChild, depth, level+1) && perfect(root.rightChild,depth,level+1);
    }
}
