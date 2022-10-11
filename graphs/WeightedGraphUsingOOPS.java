import java.util.*;
//like in tree a node class have 2 other feilds other than node.here also we have 2 feilds 
//one is label and other is a list to store the edges make by that particular node
//so every time a node is created the list also instantiated along with it
//it also has addEdge function which will add a tonode and weight with which the node wants to connect
//so every time we call addEdge from instance of this WeihtedGraphUsingOOPS class we gonna call addEdge method of node class with toNode and weight as parameter
//we dont require 2 Maps  
public class WeightedGraphUsingOOPS {
    private class Node {
        private String label;
        private List<Edge> edges = new ArrayList<>();

        public Node(String label) {
            this.label = label;
        }
        //we gonna create instance of edge class each time we wanna add a connection.
        //this each edge instance is a connection of that particular node to another node.
        //we need add them to a list.this list contains all edges that the particular node make 
        public void addEdge(Node to,int weight){
            edges.add(new Edge(this, to, weight));
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private class Edge {
        private Node fromNode;
        private Node toNode;
        private int weight;

        public Edge(Node fromNode, Node toNode, int weight) {
            this.fromNode = fromNode;
            this.toNode = toNode;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return fromNode + " -> " + toNode + " weight : " + weight;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    // private Map<Node, List<Edge>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);

        nodes.putIfAbsent(label, node);
    }

    public void addEdge(String from, String to, int weight) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if (fromNode == null) {
            throw new IllegalStateException();
        }
        if (toNode == null) {
            throw new IllegalStateException();
        }
        //we have fromNode  which is type node class .
        // we need to add edges to it
        //****IMPORTANT**basically each node object is a state. in each state the list contains the Edge that node make along with its weight******IMP
        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }
    //concurrency exception -> while iterting collections using a loop if we tried to modifty the collection inside the loop it will shoaw concurrencyModificationException
    //to avoid that I made a int value which stores the index point at which we want to perform remove operation. 
    public void removeNode(String value) {
        Node target = nodes.get(value);
        for (Node node : nodes.values()) {
            int i = 0;
            int concurrencyAvoid = 0;
            for (Edge edge : node.edges) {
                if (edge.toNode == target) {
                    concurrencyAvoid = i;
                }
                i++;
            }
            node.edges.remove(concurrencyAvoid);
        }
        nodes.remove(target.toString());
    }
    // public void removeNode(String value) {
    //     Node target = nodes.get(value);
    //     // int i=0;
    //     for (Node entry : nodes.values()) {
    //         // List list = entry.edges;
    //         for (int i = 0; i < entry.edges.size(); i++) {
    //             if (entry.edges.get(i).toNode == target) {
    //                 entry.edges.remove(entry.edges.get(i));
    //             }
    //         }
    //     }
    //     nodes.remove(value);
    // }
    public void removeEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if (fromNode == null || toNode == null) {
            return;
        }
        int concurrencyAvoidFromNode = 0, i = 0, concurrencyAvoidToNode = 0, j = 0;
        for (Edge edge : fromNode.edges) {
            if (edge.toNode == toNode) {
                concurrencyAvoidFromNode = i;
            }
            i++;
        }
        fromNode.edges.remove(concurrencyAvoidFromNode);
        
        for (Edge edge : toNode.edges) {
            if (edge.toNode == fromNode) {
                concurrencyAvoidToNode = j;
            }
            j++;
        }
        toNode.edges.remove(concurrencyAvoidToNode);
    }
    // public void removeEdge(String from,String to){
    //     Node fromNode = nodes.get(from);
    //     Node toNode = nodes.get(to);
    //     if(fromNode == null || toNode == null){
    //         return;
    //     }
    //     for(int i=0;i<fromNode.edges.size();i++){
    //         if(fromNode.edges.get(i).toNode == toNode){
    //             fromNode.edges.remove(i);
    //         }
    //     }
    // }    
    public void print() {
        for (Node node : nodes.values()) { //returns a collections of node object. we gonna itertate through each object
            List target = node.edges; //each node object has a list which contains the list of its edges
            if (!target.isEmpty()) {
                System.out.println(node.toString() + " is connected to " + target.toString());
                //the List class itself has toString method
                //we override that to print in our desired manner
            }
        }
    }

    //---implementation of Dijkstra algorithm----------------------
    //this is a bit complex refer mosh video for understanding the logic
    //dijkstra algorithm is one of the greedy algorithm
    //greedy algorithm : algorithm that tries to find the optimal solution for a problem by making optimal choices at each step
    public class NodeEntry{
        Node node;
        int priority;
        public NodeEntry(Node node,int priority){
            this.node = node;
            this.priority = priority;
        }
    }

    public int shortestDistance(String from,String to){
        Map<Node,Integer> distance = new HashMap<>();
        for(Node node : nodes.values()){
            distance.put(node,Integer.MAX_VALUE);
        }
        distance.replace(nodes.get(from),0);
        Set<Node> visisted = new HashSet<>();
        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));
        queue.add(new NodeEntry(nodes.get(from), 0));
        while(!queue.isEmpty()){
            Node current = queue.remove().node;
            visisted.add(current);
            for(Edge edge : current.edges){
                if(visisted.contains(edge.toNode)){
                    continue;
                }
                int newDistance = distance.get(current) + edge.weight;
                if(newDistance < distance.get(edge.toNode)){
                    distance.replace(edge.toNode,newDistance);
                }
                queue.add(new NodeEntry(edge.toNode, newDistance));
            }
        }

        return distance.get(nodes.get(to));
    }
    
    private class Path {
        List<Node> listNode = new ArrayList<>();

        public void addNode(Node node){
            listNode.add(node);
        }

        @Override
        public String toString(){
            return listNode.toString();
        }
    }

    //for finding shortest path.
    //same as shortest distance
    //here we have one more map for kepping track of previous node which means by which it got to that position
    //the idea is from the target node we trace the path to start node by adding it to a stack
    //bottom of stack contains the target node and top conatins the start node
    //so we wanna pop items from stack and display
    //here we add the node to list each time we pop and return that list
    //for simplicity we created a Path class which has list of type node
    public Path shortestPath(String from,String to){
        Map<Node, Integer> distance = new HashMap<>();
        Map<Node,Node> previousNode = new HashMap<>();
        for (Node node : nodes.values()) {
            distance.put(node, Integer.MAX_VALUE);
        }
        distance.replace(nodes.get(from), 0);
        Set<Node> visisted = new HashSet<>();
        //comparator is a interface. instead of creating a class and implementing this interface we can use this method
        //we using anonymous function that is function without a name.
        //this function says the queue that on what basis it should implement the priority queue
        //the compareInt is called factory method and it returns an object
        //basically if we implement the interface using class  we will create an obj for it to access the implenention of its method.
        //here we doing the same.
        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));
        queue.add(new NodeEntry(nodes.get(from), 0));
        while (!queue.isEmpty()) {
            Node current = queue.remove().node;
            visisted.add(current);
            for (Edge edge : current.edges) {
                if (visisted.contains(edge.toNode)) {
                    continue;
                }
                int newDistance = distance.get(current) + edge.weight;
                if (newDistance < distance.get(edge.toNode)) {
                    distance.replace(edge.toNode, newDistance);
                    previousNode.put(edge.toNode, current);
                }
                queue.add(new NodeEntry(edge.toNode, newDistance));
            }
        }

        Stack<Node> stack = new Stack<>();
        stack.push(nodes.get(to));
        Node previous = previousNode.get(nodes.get(to));
        while(previous != null){
            stack.push(previous);
            previous = previousNode.get(previous);
        }

        Path path = new Path();
        while(!stack.isEmpty()){
            path.listNode.add(stack.pop());
        }
        return path;
    }
    public boolean hasCycle(){
        Set<Node> visited = new HashSet<>();
        for(Node node : nodes.values()){ // we wanna check cycle on each node.
            if(!visited.contains(node)){
                if(hascycle(node,null,visited)){ //note : we passing null as parent for very first node
                    return true;
                }
            }
        }
        return false;
    }
    //we cant use the same way as we did in directed graph because in undirected the nodes are connected in both ways
    //ie., A-> B and B->A. so our previous method will say that there is a cycle but we dont have cycle actually
    //to avoid that each time we check a cycle on a node we will not consider the parent node of that particular node
    //each time when we do cycle on a node we must pass the parent node as parameter
    //both directed and undirected graph cycle check follows DFS.
    private boolean hascycle(Node node,Node parent,Set<Node> visited){
        visited.add(node);
        for(Edge edge : node.edges){
            if(visited.contains(parent)){
                continue;
            }
            if(visited.contains(edge.toNode)){
                return true;
            }
            boolean result = hascycle(edge.toNode,node,visited);
            if(result){
                return true;
            }
        }
        return false;
    }
    //minimum spanning tree uisng prims algorithm
    //imagine we have 4 offices we want to connect thwm with minimum number of cost
    //a tree is a part of graph
    //we do memoization with entries of tree object instead of using set.
    public WeightedGraph minimumSpanningTree() {
        WeightedGraph tree = new WeightedGraph();
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        Node startNode = nodes.values().iterator().next();
        queue.addAll(startNode.edges);
        tree.addNode(startNode.label);
        while (tree.nodes.size() < nodes.size()) {
            Edge minEdge = queue.remove();
            if (tree.nodes.containsKey(minEdge.toNode.label)) {
                continue;
            }
            tree.addNode(minEdge.toNode.label);
            tree.addEdge(minEdge.fromNode.label, minEdge.toNode.label, minEdge.weight);
            for (Edge edge : minEdge.toNode.edges) {
                if (!tree.nodes.containsKey(edge.toNode.label))
                    queue.add(edge);
            }
        }
        return tree;
    }
}    

