package practice;

import java.util.*;

import javax.lang.model.type.ErrorType;

public class Graph {
    private class Node {
        private String value;

        private Node(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }

    private Map<String, Node> entries = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String value) {
        Node node = new Node(value);
        entries.putIfAbsent(value, node);
        adjacencyList.putIfAbsent(node, new LinkedList());
    }

    public void addEdges(String from, String to) {
        Node fromNode = entries.get(from);
        Node toNode = entries.get(to);
        if (fromNode == null || toNode == null) {
            return;
        }
        adjacencyList.get(fromNode).add(toNode);
    }

    public void removeNode(String value) {
        Node targetNode = entries.get(value);
        for (List entry : adjacencyList.values()) {
            entry.remove(targetNode);
        }
        adjacencyList.remove(targetNode);
        entries.remove(targetNode);
    }

    public void removeEdge(String from, String to) {
        Node fromNode = entries.get(from);
        Node toNode = entries.get(to);
        if (fromNode == null || toNode == null) {
            return;
        }
        adjacencyList.get(fromNode).remove(toNode);
    }

    public void dfsRecursive(String value) {
        Set<Node> visited = new HashSet<>();
        dfsRecurive(entries.get(value), visited);
    }

    private void dfsRecurive(Node root, Set<Node> visited) {
        if (root == null) {
            return;
        }
        System.out.print(root.toString() + " ");
        visited.add(root);
        for (Node entry : adjacencyList.get(root)) {
            if (!visited.contains(entry)) {
                dfsRecurive(entry, visited);
            }
        }
    }

    public void dfsIteratve(String value) {
        Node root = entries.get(value);
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (visited.contains(current)) {
                continue;
            }
            System.out.print(current + " ");
            visited.add(current);
            for (Node entry : adjacencyList.get(current)) {
                if (!visited.contains(entry)) {
                    stack.push(entry);
                }
            }
        }
    }

    public void bfsIterative(String value) {
        Node root = entries.get(value);
        Queue<Node> queue = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            if (visited.contains(current)) {
                continue;
            }
            System.out.print(current + " ");
            visited.add(current);
            for (Node entry : adjacencyList.get(current)) {
                if (!visited.contains(entry)) {
                    queue.add(entry);
                }
            }
        }
    }

    public List<String> topologicalSort(){
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        List<String> list = new LinkedList<>();
        for(Node entry : adjacencyList.keySet()){
            topologicalSort(entry,visited,stack);
        }
        while(!stack.isEmpty()){
            list.add(stack.pop().toString());
        }
        return list;
    }
    private void topologicalSort(Node root,Set<Node> visited,Stack<Node> stack){
        if(root == null){
            return;
        }
        if(visited.contains(root)){
            return;
        }
        visited.add(root);
        for(Node entry : adjacencyList.get(root)){
            if(!visited.contains(entry)){
                topologicalSort(entry,visited,stack);
            }
        }
        stack.push(root);
    }
    public boolean hasCycle(){
        Set<Node> all = new HashSet<>();
        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();
        all.addAll(entries.values());
        for(Node entry : entries.values()){
            if(hasCycle(entry,all,visiting,visited)){
                return true;
            }
        }
        return false;
    }
    private boolean hasCycle(Node root,Set<Node> all,Set<Node> visiting,Set<Node> visited){
        if(root == null){
            return false;
        }
        if(visiting.contains(root)){
            return true;
        }
        all.remove(root);
        visiting.add(root);
        for(Node entry : adjacencyList.get(root)){
            if(visited.contains(entry)){
                continue;
            }
            if(hasCycle(entry, all, visiting, visited)){
                return true;
            }
        }
        visited.add(root);
        visiting.remove(root);
        return false;
    }
    public void print() {
        for (Node source : adjacencyList.keySet()) {
            List target = adjacencyList.get(source);
            if (!target.isEmpty())
                System.out.println(source.toString() + " is connected to " + target);
        }
    }

}
