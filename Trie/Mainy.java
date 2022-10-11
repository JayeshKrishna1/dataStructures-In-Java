public class Mainy {
    public static void main(String[] args) {
        Trie trie = new Trie();
        // trie.insert("car");
        // trie.insert("card");
        // trie.insert("caravan");
        // trie.insert("egg");
        String[] arr = {"apple","app","apps"};
        // for(int i=1;i<=arr.length;i++){
        //     trie.insert(arr[i],i);
        // }
        System.out.println(trie.Lcp(arr, trie));
        // System.out.println(trie.contains("can"));
        // trie.traversePreOrder();
        // trie.traversePostOrder();
        // trie.remove("can");
        // System.out.println(trie.contains("can"));
        // trie.traversePreOrder();
        // System.out.println(trie.autoCompletion("c"));
        // System.out.println(trie.contains("car"));
        // System.out.println(trie.noOfWords());
        
    }
    
}
