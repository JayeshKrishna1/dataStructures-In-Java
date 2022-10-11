import java.util.*;

public class WeightedGraph {
    private class Node{
        private String label;
        public Node(String label){
            this.label = label;
        }

        @Override
        public String toString(){
            return label;
        }
    }
    private class Edge{
        private Node fromNode;
        private Node toNode;
        private int weight;
        public Edge(Node fromNode,Node toNode,int weight){
            this.fromNode = fromNode;
            this.toNode = toNode;
            this.weight = weight;
        }

        @Override
        public String toString(){
            return fromNode+" -> "+toNode+" weight : "+weight;
        }
    }
    Map<String,Node> nodes = new HashMap<>();
    private Map<Node,List<Edge>> adjacencyList = new HashMap<>();
    public void addNode(String label){
        Node node = new Node(label);

        nodes.putIfAbsent(label,node);
        adjacencyList.putIfAbsent(node,new ArrayList<>());
    }
    public void addEdge(String from,String to,int weight){
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if(fromNode == null){
            throw new IllegalStateException();
        }
        if(toNode == null){
            throw new IllegalStateException();
        }
        adjacencyList.get(fromNode).add(new Edge(fromNode, toNode, weight));
        adjacencyList.get(toNode).add(new Edge(toNode, fromNode, weight));
    }

    public void print(){
        for(Node node : adjacencyList.keySet()){
            List target = adjacencyList.get(node);
            if(!target.isEmpty()){
                System.out.println(node.toString()+" is connected to "+target.toString()); 
            }
        }
    }
    
}
