package practice;
import java.util.*;
public class AvlTree {
    private class AVLNode{
        private int value;
        private int height;
        private int balancingFactor;
        private AVLNode leftChild;
        private AVLNode rightChild;

        private AVLNode(int value){
            this.value = value;
        }
    }
    private AVLNode root;
    public void insert(int value){
        root = insert(root,value);
    }
    private AVLNode insert(AVLNode root,int value){
        if(root == null){
            root = new AVLNode(value);
        }

        if(value<root.value){
            root.leftChild = insert(root.leftChild,value);
        }
        else if(value > root.value){
            root.rightChild = insert(root.rightChild,value);
        }
        root.height = heightOfANode(root);
        root.balancingFactor = balancefactor(root);
        root = balance(root);
        return root;
    }
    private boolean leftHeavy(AVLNode root){
        if(root.balancingFactor > 1){
            return true;
        }
        return false;
    }
    private boolean rightHeavy(AVLNode root){
        if(root.balancingFactor < -1){
            return true;
        }
        return false;
    }
    private AVLNode leftRotate(AVLNode root){
        AVLNode newRoot = root.rightChild;
        root.rightChild=newRoot.leftChild;
        newRoot.leftChild = root;
        root.height = heightOfANode(root);
        newRoot.height = heightOfANode(newRoot);
        root = newRoot;
        return root;
    }
    private AVLNode rightRotate(AVLNode root){
        AVLNode newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;
        root.height = heightOfANode(root);
        newRoot.height = heightOfANode(newRoot);
        root = newRoot;
        return root;
    }
    private AVLNode balance(AVLNode root){
        if(leftHeavy(root)){
            if(root.leftChild.balancingFactor >= 1){
                root = rightRotate(root);
            }
            else{
                root.leftChild = leftRotate(root.leftChild);
                root = rightRotate(root);
            }
        }
        else if(rightHeavy(root)){
            if(root.rightChild.balancingFactor <= -1){
                root = leftRotate(root);
            }
            else{
                root.rightChild = rightRotate(root.rightChild);
                root = leftRotate(root);
            }
        }
        return root;
    }
    private int balancefactor(AVLNode root){
        return height(root.leftChild) - height(root.rightChild);
    }
    private int heightOfANode(AVLNode root){
        return Math.max(height(root.leftChild),height(root.rightChild))+1;
    }
    //the below method returns the height of a node which is already calculated and above method is for calculation of height of a node.
    private int height(AVLNode root){
        if(root == null){
            return -1;
        }
        return root.height;
    }
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(AVLNode root){
        if(root == null){
            return;
        }
        System.out.print(root.value+" ");
        preOrder(root.leftChild);
        preOrder(root.rightChild);
    }
    public boolean isBalance(){
        return isBalance(root);
    }
    private boolean isBalance(AVLNode root){
        if(root == null){
            return true;
        }
        int Lheight = height(root.leftChild);
        int Rheight = height(root.rightChild);
        if ((Lheight - Rheight < -1) || (Lheight - Rheight > 1)) {
            return false;
        }
        boolean left = isBalance(root.leftChild);
        boolean right = isBalance(root.rightChild);
        if(!(left && right)){
            return false;
        }
        return true;

    }
    public boolean isPerfect(){
        return isPerfect(root,root.height,1);
    }
    private boolean isPerfect(AVLNode root,int height,int level){
        if(root == null){
            return true;
        }
        if(root.leftChild == null && root.rightChild == null){
            return (height == level-1);
        }
        if (root.leftChild == null || root.rightChild == null)
            return false;
        return isPerfect(root.leftChild,height,level+1) && isPerfect(root.rightChild,height,level+1);
    }
}
