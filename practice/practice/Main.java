package practice;

import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        
        // Graph graph = new Graph();
        // WeightedGraph graph = new WeightedGraph();
        // graph.addNode("A");
        // graph.addNode("B");
        // graph.addNode("C");
        // graph.addNode("D");
        // graph.addEdges("A", "B",3);
        // graph.addEdges("B", "C",6);
        // graph.addEdges("A", "C",4);
        // graph.addEdges("D", "A",5);
        // // graph.removeNode("A");
        // // graph.removeEdge("B","C");
        // graph.addNode("A");
        // graph.addNode("B");
        // graph.addNode("C");
        // graph.addNode("D");
        // graph.addNode("E");
        // graph.addEdges("A", "B", 3);
        // graph.addEdges("A", "C", 1);
        // graph.addEdges("A", "D", 2);
        // graph.addEdges("B", "C", 2);
        // graph.addEdges("B", "D", 4);
        // graph.addEdges("C", "D", 5);
        // graph.addEdges("D", "E", 5);
        //----------------------------
        // graph.addNode("A");
        // graph.addNode("B");
        // graph.addNode("C");
        // graph.addNode("D");
        // graph.addNode("E");
        // graph.addEdges("A", "B", 3);
        // graph.addEdges("A", "C", 4);
        // graph.addEdges("A", "D", 2);
        // graph.addEdges("B", "D", 6);
        // graph.addEdges("B", "E", 1);
        // graph.addEdges("C", "D", 1);
        // graph.addEdges("D", "E", 5);
        // System.out.println(graph.shortestDistance("A", "E"));
        // System.out.println(graph.shortestPath("A", "E"));
        // WeightedGraph tree = graph.minimumSpanningTree();
        // tree.print();
        // graph.print();
        //------------------------------------
        // graph.addNode("x");
        // graph.addNode("a");
        // graph.addNode("b");
        // graph.addNode("p");
        // graph.addEdgess("x", "a");
        // graph.addEdgess("x", "b");
        // graph.addEdgess("a", "p");
        // graph.addEdgess("b", "p");
        // graph.print();
        // System.out.println(graph.topologicalSort());
        //----------------------------------
        // graph.addNode("A");
        // graph.addNode("B");
        // graph.addNode("C");
        // graph.addNode("D");
        // graph.addEdgess("A", "B");
        // graph.addEdgess("B", "D");
        // graph.addEdgess("D", "C");
        // graph.addEdgess("A", "C");
        // graph.print();
        // graph.dfsRecursive("A");
        // System.out.println(" ");
        // graph.dfsIteratve("A");
        // System.out.println(" ");
        // graph.bfsIterative("A");
        //------------------------------------
        // Heap heap = new Heap();
        // heap.insert(10);
        // heap.insert(5);
        // heap.insert(17);
        // heap.insert(4);
        // heap.insert(21);
        // heap.delete();
        // heap.print();
        //-----------------------------------
        // AvlTree tree = new AvlTree();
        // tree.insert(30);
        // tree.insert(10);
        // tree.insert(20);
        // ------------------------
        // tree.insert(5);
        // tree.insert(10);
        // tree.insert(3);
        // tree.insert(12);
        // tree.insert(15);
        // tree.insert(14);
        //-------------------------
        // tree.insert(12);
        // tree.insert(3);
        // tree.insert(9);
        // tree.insert(4);
        // tree.insert(6);
        // tree.insert(2);
        // tree.preOrder();
        // System.out.println(tree.isBalance());
        // System.out.println(tree.isPerfect());
        // ------------------------------------------------------------------------------------------
        // Tree tree = new Tree();
        // tree.insert(50);
        // tree.insert(40);
        // tree.insert(65);
        // tree.insert(30);
        // tree.insert(45);
        // tree.insert(60);
        // tree.insert(70);
        // tree.preOrder();
        // System.out.println(" ");
        // tree.inOrder();
        // System.out.println(" ");
        // tree.postOrder();
        // // tree.delete(65);
        // System.out.println(" ");
        // // tree.preOrder();
        // // System.out.println(tree.find(30));
        // // System.out.println(tree.height(6));
        // System.out.println(tree.min());
        // Tree tree2 = new Tree();
        // tree2.insert(50);
        // tree2.insert(40);
        // tree2.insert(65);
        // tree2.insert(30);
        // tree2.insert(45);
        // tree2.insert(60);
        // // tree2.insert(70);
        // System.out.println(tree.equals(tree2));
        // System.out.println(tree.nodesAtaDistance(2));
        // tree.levelOrder();
        // System.out.println(tree.size());
        // System.out.println(tree.noOfLeaves());
        // System.out.println(tree.max());
        // System.out.println(tree.contains(46));
        // System.out.println(tree.isSibilings(30,45));
        // System.out.println(tree.getAncesstors(70));

        // -------------------------------------------------------------------------------------
        // Linked list = new Linked();
        // list.addFirst(10);
        // list.addLast(20);
        // list.addLast(30);
        // list.addLast(40);
        // list.addLast(50);
        // list.addLast(60);
        // list.print();
        // list.addAtIndex(1, 15);
        // list.print();
        // list.removeFirst();
        // list.print();
        // list.removeAtIndex(1);
        // list.print();
        // list.removeLast();
        // list.print();
        // list.reverse();
        // System.out.println(list.kthNodeFromEnd(5));
        // System.out.println(list.middleOfLinkedList());
        // System.out.println(list.hasCycle());
        // list.print();
        // Queues queue = new Queues(5);
        // queue.add(10);
        // queue.add(20);
        // queue.add(30);
        // queue.add(40);
        // queue.add(50);
        // queue.print();
        // queue.remove();
        // queue.print();
        // queue.add(60);
        // queue.print();
        // queue.add(70);
        // queue.print();
        // queue.print();
        // queue.remove();
        // queue.print();
        // queue.remove();
        // queue.print();
        // queue.reverse();
        // queue.enQueue(10);
        // queue.enQueue(20);
        // queue.enQueue(30);
        // System.out.println(queue.deQueue());
        // queue.enQueue(40);
        // System.out.println(queue.deQueue());
        // queue.PriorityEnQueue(30);
        // queue.PriorityEnQueue(10);
        // // queue.PriorityEnQueue(20);
        // queue.PriorityEnQueue(1);
        // queue.PriorityDequeue();
        // queue.PriorityEnQueue(1);
        // queue.print();
        // queue.dummyEnqueue();
        // queue.reverseFirstKElements(3);

        // Map<String,Integer> map = new HashMap<>();
        // String str = "a green apple";
        // for(int i=0;i<str.length();i++){
        // char temp = str.charAt(i);
        // String temp1 = Character.toString(temp);
        // map.putIfAbsent(temp1, 0);
        // }
        // for (int i = 0; i < str.length(); i++) {
        // char temp = str.charAt(i);
        // String temp1 = Character.toString(temp);
        // if(map.containsKey(temp1)){
        // int count = map.get(temp1);
        // map.put(temp1, ++count);
        // }
        // }
        // for (int i = 0; i < str.length(); i++) {
        // char temp = str.charAt(i);
        // String temp1 = Character.toString(temp);
        // int c = map.get(temp1);
        // if(c == 1){
        // System.out.println(temp);
        // return;
        // }
        // }
        // System.out.println(map);
        // Set<Character> set = new HashSet<>();
        // set.add(1);
        // set.add(2);
        // set.add(3);
        // Object[] arr = set.toArray();
        // System.out.println(Arrays.toString(arr));
        // String str = "a green apple";
        // for (char ch : str.toCharArray()) {
        // if(set.contains(ch)){
        // System.out.println(ch);
        // return;
        // }
        // else{
        // set.add(ch);

        // }
        // }
        // Hash hash = new Hash();
        // hash.put(1, "jayesh");
        // hash.put(2, "Krishna");
        // hash.put(1, "jayesh krishna");
        // hash.print();
        // System.out.println(hash.get(1));
        // hash.remove(1);
        // hash.print();
        // int[] arr = {2, 7, 11, 15};
        // int k= 9;
        // int[] result = hash.twoSum(arr, k);
        // System.out.println(Arrays.toString(result));
        // System.out.println(hash.uniquePair(arr, k));
        // hash.mostRepeated(arr);
    }
}
