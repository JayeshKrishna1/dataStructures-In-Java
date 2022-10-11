package practice;
import java.util.*;
public class Trie {
    private class Node{
        private char value;
        private Map<Character,Node> children = new HashMap<>();
        private boolean isEndOfWord;
        private Node(char value){
            this.value = value;
        }
    }
    private Node root = new Node(' ');
    public void insert(String value){
        Node current = root;
        for(char ch : value.toCharArray()){
            if(current.children.get(ch) == null){
                current.children.put(ch, new Node(ch));
            }
            current = current.children.get(ch);
        }
        current.isEndOfWord = true;
    }
    public boolean contains(String value){
        Node current = root;
        for(char ch : value.toCharArray()){
            if(current.children.get(ch) != null){
                continue;
            }
            else{
                return false;
            }
        }
        if(current.isEndOfWord == true){
            return true;
        }
        return false;
    }
    public void traversePreOrder(){
        traversePreOrder(root);
    }
    private void traversePreOrder(Node root){
        if(!root.equals(null)){
            System.out.print(root.value+" ");
        }
        for(Node node : root.children.values()){
            traversePreOrder(node);
        }
    }
    
    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        for (Node node : root.children.values()) {
            traversePostOrder(node);
        }
        if (!root.equals(null)) {
            System.out.print(root.value + " ");
        }
    }
    public void remove(String value){
        remove(root,value,0);
    }
    public void remove(Node root,String value,int index){
        if(index == value.length()){
            root.isEndOfWord =false;
            return;
        }
        char ch = value.charAt(index);
        Node child = root.children.get(ch);
        if(child== null){
            return;
        }
        remove(child, value, index+1);
        if(child.children.values() == null && child.isEndOfWord == false){
            root.children.remove(child.value);
        }
    }
    public List<String> autoCompletion(String value){
        List<String> list = new ArrayList<>();
        autoCompletion(root,value,list);
        return list;
    }
    private void autoCompletion(Node root,String value,List<String> list){
        Node lastChild = findLastNode(value);
        traverse(lastChild,value,list);
    }
    private void traverse(Node root,String value,List<String> list){
        if(root.isEndOfWord == true){
            list.add(value);
        }
        for(Node child : root.children.values()){
            traverse(child, value+child.value, list);
        }
        

    }
    private Node findLastNode(String value){
        Node current = root;
        for(char ch : value.toCharArray()){
            if(current.children.get(ch)!=null){
                current = current.children.get(ch);
            }
        }
        return current;
    }
    
}
