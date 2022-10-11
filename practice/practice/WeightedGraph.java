package practice;
import java.beans.Visibility;
import java.util.*;
public class WeightedGraph {
    private class Node{
        private String value;
        private List<Edges> edges = new ArrayList<>();
        private Node(String value){
            this.value = value;
        }
        private void addEdges(Node to,int weight){
            edges.add(new Edges(this, to, weight));
        }
        @Override
        public String toString(){
            return this.value;
        }
    }
    private class Edges{
        private Node from;
        private Node to;
        private int weight;
        private Edges(Node from,Node to,int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public String toString(){
            return this.from.toString()+ "->" +this.to.toString()+" with weight as"+this.weight;
        }
    }
    private Map<String,Node> entries = new HashMap<>();
    public void addNode(String value){
        Node node = new Node(value);
        entries.putIfAbsent(value,node);
    }
    public void addEdges(String from,String to,int weight){
        Node fromNode = entries.get(from);
        Node toNode = entries.get(to);
        if(fromNode == null | toNode == null){
            return;
        }
        fromNode.addEdges(toNode, weight);
        toNode.addEdges(fromNode, weight);
    }
    public void removeNode(String value){
        Node target = entries.get(value);
        for(Node node : entries.values()){
            int i=0;int concurrencyAvoid =0;
            for(Edges edge : node.edges){
                if(edge.to == target){
                    concurrencyAvoid = i;
                }
                i++;
            }
            node.edges.remove(concurrencyAvoid);
        }
        entries.remove(target.toString());
    }
    public void removeEdge(String from,String to){
        Node fromNode = entries.get(from);
        Node toNode = entries.get(to);
        if(fromNode == null || toNode == null){
            return;
        }
        int concurrencyAvoidFromNode = 0,i=0,concurrencyAvoidToNode = 0,j=0;
        for(Edges edge : fromNode.edges){
            if(edge.to == toNode){
                concurrencyAvoidFromNode = i;
            }
            i++;
        }
        fromNode.edges.remove(concurrencyAvoidFromNode);
        for (Edges edge : toNode.edges) {
            if (edge.to == fromNode) {
                concurrencyAvoidToNode = j;
            }
            j++;
        }
        toNode.edges.remove(concurrencyAvoidToNode);
    }
    private class NodeEntry{
        private Node node;
        private int priority;
        private NodeEntry(Node node,int priority){
            this.node = node;
            this.priority = priority;
        }
    }
    public int shortestDistance(String from,String to){
        Node fromNode = entries.get(from);
        Node toNode = entries.get(to);
        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));
        Map<Node,Integer> distance = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        for(Node node : entries.values()){
            distance.put(node, Integer.MAX_VALUE);
        }
        distance.replace(entries.get(from), 0);
        queue.add(new NodeEntry(fromNode,0));
        while(!queue.isEmpty()){
            Node current = queue.remove().node;
            if(visited.contains(current)){
                continue;
            }
            visited.add(current);
            for(Edges edge : current.edges){
                if(visited.contains(edge.to)){
                    continue;
                }
                int newDistance = distance.get(current) + edge.weight;
                if(newDistance < distance.get(edge.to)){
                    distance.replace(edge.to, newDistance);
                    queue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }
        return distance.get(toNode);
    }
    private class Path{
        // private Node node;
        List<String> list = new ArrayList<>();
        public void addNode(String node){
            list.add(node);
        }
        @Override
        public String toString(){
            return list.toString();
        }
    }
    public Path shortestPath(String from, String to) {
        Node fromNode = entries.get(from);
        Node toNode = entries.get(to);
        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));
        Map<Node, Integer> distance = new HashMap<>();
        Map<Node,Node> previousNode = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        for (Node node : entries.values()) {
            distance.put(node, Integer.MAX_VALUE);
        }
        distance.replace(entries.get(from), 0);
        queue.add(new NodeEntry(fromNode, 0));
        while (!queue.isEmpty()) {
            Node current = queue.remove().node;
            if (visited.contains(current)) {
                continue;
            }
            visited.add(current);
            for (Edges edge : current.edges) {
                if (visited.contains(edge.to)) {
                    continue;
                }
                int newDistance = distance.get(current) + edge.weight;
                if (newDistance < distance.get(edge.to)) {
                    distance.replace(edge.to, newDistance);
                    previousNode.put(edge.to,current);
                    queue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }
        // System.out.println(previousNode);
        Stack<Node> st = new Stack<>();
        st.push(toNode);
        Node previous = previousNode.get(toNode);
        while(previous != null){
            st.push(previous);
            previous = previousNode.get(previous);
        }
        // System.out.println(st);
        Path path = new Path();
        while(!st.isEmpty()){
            path.addNode(st.pop().toString());
        }
        return path;
    }
    public WeightedGraph minimumSpanningTree(){
        WeightedGraph tree = new WeightedGraph();
        PriorityQueue<Edges> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        Node startNode = entries.values().iterator().next();
        tree.addNode(startNode.value);
        queue.addAll(startNode.edges);
        while(tree.entries.size() < entries.size()){
            Edges minEdge = queue.remove();
            if(tree.entries.containsKey(minEdge.to.value)){
                continue;
            }
            tree.addNode(minEdge.to.value);
            tree.addEdges(minEdge.from.value, minEdge.to.value,minEdge.weight);
            for(Edges edge : minEdge.to.edges){
                if(!tree.entries.containsKey(edge.to.value)){
                    queue.add(edge);
                }
            }
        }
        return tree;
    }
    // public void removeNode(String value){
    //     Node target = entries.get(value);
    //     // int i=0;
    //     for(Node entry : entries.values()){
    //         // List list = entry.edges;
    //         for(int i=0;i<entry.edges.size();i++){
    //             if(entry.edges.get(i).to == target){
    //                 entry.edges.remove(entry.edges.get(i));
    //             }
    //         }
    //     }
    //     entries.remove(value);
    // }
    // public void removeEdge(String from,String to){
    //     Node fromNode = entries.get(from);
    //     Node toNode = entries.get(to);
    //     if(fromNode == null || toNode == null){
    //         return;
    //     }
    //     for(int i=0;i<fromNode.edges.size();i++){
    //         if(fromNode.edges.get(i).to == toNode){
    //             fromNode.edges.remove(i);
    //         }
    //     }
    //     for (int i = 0; i < toNode.edges.size(); i++) {
    //         if(toNode.edges.get(i).to == fromNode){
    //             toNode.edges.remove(i);
    //         }
    //     }
    // }
    // private class NodeEntry{
    //     private Node node;
    //     private int priority;
    //     private NodeEntry(Node node,int priority){
    //         this.node = node;
    //         this.priority = priority;
    //     }
    // }
    // public int shortestDistance(String from,String to){
    //     Map<Node,Integer> distance = new HashMap<>();
    //     PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));
    //     Set<Node> visited = new HashSet<>();
    //     for(Node entry : entries.values()){
    //         distance.putIfAbsent(entry,Integer.MAX_VALUE);
    //     }
    //     distance.replace(entries.get(from),0);
    //     queue.add(new NodeEntry(entries.get(from),0));
    //     while(!queue.isEmpty()){
    //         Node current = queue.remove().node;
    //         if(visited.contains(current)){
    //             continue;
    //         }
    //         visited.add(current);
    //         for(Edges edge : current.edges){
    //             if(visited.contains(edge.to)){
    //                 continue;
    //             }
    //             int newDistance = distance.get(current) + edge.weight;
    //             if(newDistance < distance.get(edge.to)){
    //                 distance.replace(edge.to, newDistance);
    //                 queue.add(new NodeEntry(edge.to, newDistance));
    //             }
    //         }
    //     }
    //     return distance.get(entries.get(to));
    // }
    // private class Path{
    //     private String node;
    //     private List<String> nodes = new ArrayList<>();
    //     public void addPath(String node){
    //         nodes.add(node);
    //     }
    //     @Override
    //     public String toString(){
    //         return nodes.toString();
    //     }
    // }
    // public Path shortestPath(String from, String to) {
    //     Map<Node, Integer> distance = new HashMap<>();
    //     Map<Node,Node> previous = new HashMap<>();
    //     PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));
    //     Set<Node> visited = new HashSet<>();
    //     for (Node entry : entries.values()) {
    //         distance.putIfAbsent(entry, Integer.MAX_VALUE);
    //     }
    //     distance.replace(entries.get(from), 0);
    //     queue.add(new NodeEntry(entries.get(from), 0));
    //     while (!queue.isEmpty()) {
    //         Node current = queue.remove().node;
    //         if (visited.contains(current)) {
    //             continue;
    //         }
    //         visited.add(current);
    //         for (Edges edge : current.edges) {
    //             if (visited.contains(edge.to)) {
    //                 continue;
    //             }
    //             int newDistance = distance.get(current) + edge.weight;
    //             if (newDistance < distance.get(edge.to)) {
    //                 distance.replace(edge.to, newDistance);
    //                 previous.put(edge.to, current);
    //                 queue.add(new NodeEntry(edge.to, newDistance));
    //             }
    //         }
    //     }
        
    //     Stack<Node> st = new Stack<>();
    //     st.push(entries.get(to));
    //     Node previousNode = previous.get(entries.get(to));
    //     while(previousNode != null){
    //         st.push(previousNode);
    //         previousNode = previous.get(previousNode);
    //     }
    //     Path path = new Path();
    //     while(!st.isEmpty()){
    //         path.addPath(st.pop().value);
    //     }
    //     return path;
    // }
    // public boolean hasCycle(){
    //     Set<Node> visited = new HashSet<>();
    //     for(Node node : entries.values()){
    //         if(!visited.contains(node)){
    //             if(hasCycle(node,null,visited)){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
    // private boolean hasCycle(Node root,Node parent,Set<Node> visited){
        
    //     visited.add(root);
    //     for(Edges edge : root.edges){
    //         if(visited.contains(parent)){
    //             continue;
    //         }
    //         if(visited.contains(edge.to)){
    //             return true;
    //         }
    //         if(hasCycle(edge.to,root,visited)){
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    // public WeightedGraph minimumSpanningTree(){
    //     WeightedGraph tree = new WeightedGraph();
    //     PriorityQueue<Edges> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
    //     Node startNode = entries.values().iterator().next();
    //     queue.addAll(startNode.edges);
    //     tree.addNode(startNode.value);
    //     while(tree.entries.size() < entries.size()){
    //         Edges minEdge = queue.remove();
    //         if(tree.entries.containsKey(minEdge.to.value)){
    //             continue;
    //         } 
    //         tree.addNode(minEdge.to.value);
    //         tree.addEdges(minEdge.from.value, minEdge.to.value, minEdge.weight);
    //         for(Edges edge : minEdge.to.edges){
    //             if(!tree.entries.containsKey(edge.to.value))
    //                queue.add(edge);
    //         }
    //     }
    //     return tree;
    // }
    public void print(){
        for(Node entry : entries.values()){
            if(!entry.edges.isEmpty())
              System.out.println(entry+" has edges to"+entry.edges);
        }
    }

}
