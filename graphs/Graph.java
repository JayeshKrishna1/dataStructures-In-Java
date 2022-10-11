import java.nio.channels.IllegalSelectorException;
import java.util.*;

public class Graph {
    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdges(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if (fromNode == null) {
            throw new IllegalStateException();
        }
        if (toNode == null) {
            throw new IllegalStateException();
        }
        adjacencyList.get(fromNode).add(toNode);
    }

    public void print() {
        for (Node source : adjacencyList.keySet()) {
            List target = adjacencyList.get(source);
            if (!target.isEmpty())
                System.out.println(source.toString() + " is connected to " + target);
        }
    }

    public void removeNode(String label) {
        // if we remove the node from the first hashmap then we could not able to access
        // the second hashmap coz its key is node
        Node source = nodes.get(label);
        if (source == null)
            return;
        for (Node eachNode : adjacencyList.keySet()) { // note this we getting the key set. ie., a list of keys
            List target = adjacencyList.get(eachNode);
            target.remove(source);
        }
        adjacencyList.remove(source);
        nodes.remove(label);
    }

    public void removeEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if (fromNode == null || toNode == null) {
            return;
        }
        adjacencyList.get(fromNode).remove(toNode);
    }
    // ------in recursive method---------
    // we will keep track of visited nodes using set in both approach
    // we visit the node and add to visisted set and loop through its relations
    // for each node in relation we will call the method provided that the node is
    // not already visited

    // -------in iterative method--------
    // same as recursive we will use set to keep track of visited nodes
    // we first add the given node to stack
    // then run a loop untill the stack becomes empty
    // we pop the element in stack and print if the node not already visisted
    // then we add its neighbours to stack
    // and repeat the above 2 steps untill the stack becomes empty
    public void traversalDFSrec(String root) {
        dfsRecursive(nodes.get(root), new HashSet<>());
    }

    private void dfsRecursive(Node root, Set<Node> visited) {
        if (root == null) {
            return;
        }
        System.out.println(root.toString());
        visited.add(root);
        for (Node NeighBours : adjacencyList.get(root)) {
            if (!visited.contains(NeighBours)) {
                dfsRecursive(NeighBours, visited);
            }
        }
    }

    // -----------------------------important note---------------------------------
    // a graph can have multiple dfs solution
    // take a graph
    // a
    // b c
    // d
    // a is connected to b and c
    // b is connected to d
    // d is connected to c
    // dfs may be any of two
    // a b d c (or) a c d b
    // both are valid answers
    public void traversalDFS(String root) {
        dfs(nodes.get(root));
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        stack.push(root);
        // System.out.println(root.toString());
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (visited.contains(current)) {
                continue;
            }
            System.out.println(current.toString());
            visited.add(current);
            for (Node neighBour : adjacencyList.get(current)) {
                if (!visited.contains(neighBour)) {
                    stack.push(neighBour);
                }
            }
        }
    }

    // bfs is same as dfs in implementation
    // instaed of using stack we use queue
    public void bfs(String root) {
        bfsItertaive(nodes.get(root));
    }

    private void bfsItertaive(Node root) {
        if (root == null) {
            return;
        }
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            if (visited.contains(current)) {
                continue;
            }
            System.out.println(current.toString());
            visited.add(current);
            for (Node neighBour : adjacencyList.get(current)) {
                if (!visited.contains(neighBour)) {
                    queue.add(neighBour);
                }
            }
        }
    }

    // suppose we have graph like
    // x
    // a b
    // p
    // assuming all nodes as process. the final process is p
    // for getting final process we need to undergo a and b
    // for undergoing a and b we need x
    // order we wanna visit is x a b p (or) x b a p
    // for each node we do dfs.
    // the final process will always be at the bottom of the stack
    // we will add the node to stack when we have visited all its following nodes
    // and doesnt have any node to visit
    // condition : the graph should be directed acyclic graph // for eg we have a
    // edge from p to x then for doing x we need final process p which is illogical
    // definition : ordering the nodes based on their process
    public List<String> topologicalSort() {
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        for (Node eachNod : nodes.values()) {
            topologicalSort(eachNod, stack, visited);
            // for above example we will get our stack when we start with x.
            // coz all nodes will be visited if we start from x. for remaining nodes we will
            // just return by checking the visisted nodes
        }
        List<String> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop().toString());
        }
        return result;
    }

    private void topologicalSort(Node eachnod, Stack<Node> stack, Set<Node> visited) {
        if (visited.contains(eachnod)) {
            return;
        }
        visited.add(eachnod);
        for (Node neighBour : adjacencyList.get(eachnod)) {
            topologicalSort(neighBour, stack, visited);
        }
        stack.push(eachnod);
    }

    // detect cycle in a directed graph
    // we will have 3 sets. all,visiting,visited
    // one will contains all nodes
    // if we start visiting one node and going to start dfs then we will add to
    // visiting set
    // once we visisted all its neighbour and done dfs then we add that particular
    // node to visited set.
    public boolean isCyclic() {
        Set<Node> all = new HashSet<>();
        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();
        all.addAll(nodes.values());
        // we gonna do dfs and check for cycle untill the all set becomes empty.when all
        // set becomes empty then we can checked all nodes
        while (!all.isEmpty()) {
            // we want to get each element from set in an order like we iterate in array.
            // set has iterator method which will return a object and we can call next
            // method on it to get all nodes in order
            Node current = all.iterator().next();
            // we will return immediately if we found any cycle on any of the node in all.
            // we dont need to visit remaining node

            if (isCyclic(current, all, visiting, visited)) {
                return true;
            }
        }
        return false;

    }

    private boolean isCyclic(Node root, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
        // while we start approaching a node we want to first move to visiting set
        all.remove(root);
        visiting.add(root);
        // after adding to visisted we wanna do dfs on that node
        for (Node neighbour : adjacencyList.get(root)) {
            // if the node is already visited then we want to continue
            if (visited.contains(neighbour)) {
                continue;
            }
            // if the node going to visit is alredy in visisting set then we confirm that
            // there is cycle
            // coz the exsisting node has there via some of previous nodes of neighbour and
            // we re visiting it.
            if (visiting.contains(neighbour)) {
                return true;
            }
            // if not both case then we recursively do dfs
            // the below function will return either true or false
            // if it is true then there is cycle so we immediately return
            if (isCyclic(neighbour, all, visiting, visited)) {
                return true;
            }
        }
        // if control comes here then we have done dfs on the node we got and we aint
        // found any cycle by doing dfs on that node
        // so we can add that to visisted
        // note : we can add a node a visisted only when we done dfs on that node and
        // all its neighbours are visited
        visited.add(root);
        visiting.remove(root);
        // we aint found any cycle on that node
        return false;
    }
}
