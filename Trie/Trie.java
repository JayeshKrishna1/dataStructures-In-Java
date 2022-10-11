import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {
    private class Node{
        private char value;
        private Map<Character,Node> children = new HashMap<>();
        private boolean isEndOfWord;
        // private int wordCount;
        private Node(char value){
            this.value = value;
        }
        @Override
        public String toString(){
            return "value = "+value;
        }
        public boolean hasAParticularChild(char ch){
            return (children.get(ch) !=null);
        }
        public void putChild(char ch){
            children.put(ch, new Node(ch));
        }
        public Node getChild(char ch){
            return children.get(ch);
        }
        public boolean isEnd(Node node){
            return node.isEndOfWord;
        }
        public Node[] getChildren(char ch){
            return children.values().toArray(new Node[0]);
        }
        public void remove(char ch){
            children.remove(ch);
        }
        public boolean hasChild(){
            return children.values() != null;
        }
    }
    private Node root = new Node(' ');
    public void insert(String value){
        Node current = root;
        for(char ch : value.toCharArray()){
            if(!current.hasAParticularChild(ch)){
                current.putChild(ch);;
            }
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }
    public boolean contains(String value){
        if(value == null){
            return false;
        }
        Node current = root;
        for(char ch : value.toCharArray()){
            if(current.hasAParticularChild(ch)){
                current = current.getChild(ch);
                continue;
            }
            return false;
        }
        if(current.isEnd(current)){
            return true;
        }
        return false; 
    }
    //we used post order for removing words
    public void traversePreOrder(){
        traversePreOrder(root);
    }
    private void traversePreOrder(Node root){
        System.out.println(root.value);
        for(Node node : root.getChildren(root.value)){
            traversePreOrder(node);
        }
    }
    
    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        for (Node node : root.getChildren(root.value)) {
            traversePostOrder(node);
        }
        System.out.println(root.value);
    }
    public void remove(String value){
        remove(root,value,0);
    }
    private void remove(Node root,String value,int index){
        if(index == value.length()){
            root.isEndOfWord = false;
            return;
        }
        char ch = value.charAt(index);
        Node child = root.getChild(ch);
        if(child == null){
            return;
        }
        remove(child, value, index+1);

        if(!child.hasChild() && child.isEndOfWord == false){
            root.remove(child.value);
        }
    }
    public List<String> autoCompletion(String value){
        List<String> list = new ArrayList<>();
        autoCompletion(root,value,list);
        return list;
    }
    public void autoCompletion(Node root,String value,List<String> list){
        Node lastNode = lastNode(root, value);
        traverse(lastNode, value, list);
    }
    private void traverse(Node node,String value,List<String> list){
        if(node.isEndOfWord == true){
            list.add(value);
            
        }
        for(Node child : node.children.values()){
            traverse(child, value+child.value, list);
        }
    }
    private Node lastNode(Node root,String value){
        Node current = root;
        for(char ch : value.toCharArray()){
            current = current.children.get(ch);
            if(current == null){
                return null;
            }
        }
        return current;
    }
    public boolean containsRecursive(String value){
        return containsRecursive(root,value,0);
    }
    private boolean containsRecursive(Node root,String value,int index){
        if(index == value.length() && root.isEndOfWord == true){
            return true;
        }
        else if (index == value.length() && root.isEndOfWord != true) {
            return false;
        } 
        char ch = value.charAt(index);
        Node child = root.children.get(ch);
        if(child == null){
            return false;
        }
        if(containsRecursive(child, value, index+1)){
            return true;
        }
        return false;
    }
    public int noOfWords(){
        return noOfWords(root,0);
    }
    private int noOfWords(Node root,int count){
        if(root.isEndOfWord == true){
            ++count;        
        }
        for(Node child : root.children.values()){
            count = noOfWords(child,count);
        }
        return count;
    }
    public String Lcp(String[] arr,Trie trie){
        for(int i=0;i<arr.length;i++){
            trie.insert(arr[i]);
        }
        // trie.traversePreOrder();
        String lcp="";
        for(int i=0;i<arr.length;i++){
            lcp = trie.getCommonPrefix(root,arr[i]);
        }
        return lcp;
    }
    private String getCommonPrefix(Node root,String arr){
        String lcp="";
        for(char ch : arr.toCharArray()){
            if(root.children.values().size() == 1){
                lcp+=root.children.get(ch).value;
            }
            else{
                return lcp;
            }
            root = root.children.get(ch);
        }
        // System.out.println(lcp);
        return lcp;
    }
}
