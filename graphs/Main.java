public class Main{
    public static void main(String[] args) {
        // Graph graph = new Graph();
        // graph.addNode("Krishnaswammy");
        // graph.addNode("Rukmani");
        // graph.addNode("Kannan");
        // graph.addNode("Latha");
        // graph.addNode("Jayesh Krishna");
        // graph.addNode("Suba Lakshmi");
        // graph.addEdges("Krishnaswammy", "Rukmani");
        // graph.addEdges("Krishnaswammy", "Kannan");
        // // graph.addEdges("Rukmani", "Krishnaswammy");
        // graph.addEdges("Rukmani", "Kannan");
        // graph.addEdges("Kannan", "Latha");
        // graph.addEdges("Kannan","Jayesh Krishna");
        // graph.addEdges("Kannan", "Suba Lakshmi");
        // // graph.addEdges("Latha", "Kannan");
        // graph.addEdges("Latha", "Jayesh Krishna");
        // graph.addEdges("Latha", "Suba Lakshmi");
        // graph.addEdges("Jayesh Krishna", "Suba Lakshmi");
        // // graph.addEdges("Suba Lakshmi", "Jayesh Krishna");
        // graph.addNode("A");
        // graph.addNode("B");
        // graph.addNode("C");
        // graph.addNode("D");
        // graph.addEdges("A", "B");
        // graph.addEdges("B", "D");
        // graph.addEdges("D", "C");
        // graph.addEdges("A", "C");
        // graph.print();
        // System.out.println("  ");
        // // graph.removeNode("Jayesh Krishna");
        // // graph.print();
        // // System.out.println("  ");
        // // graph.removeEdge("Krishnaswammy", "Rukmani");
        // // graph.print();
        // graph.traversalDFSrec("A");
        // System.out.println(" ");
        // graph.traversalDFS("A");
        // System.out.println(" ");
        // graph.bfs("A");
        //-----for topological sort------
        // graph.addNode("x");
        // graph.addNode("a");
        // graph.addNode("b");
        // graph.addNode("p");
        // graph.addEdges("x", "a");
        // graph.addEdges("x", "b");
        // graph.addEdges("a", "p");
        // graph.addEdges("b", "p");
        // System.out.println(graph.topologicalSort());  
        //------for checking cycle-------------
        // graph.addNode("A");
        // graph.addNode("B");
        // graph.addNode("C");
        // graph.addNode("D");
        // graph.addEdges("A", "B");
        // graph.addEdges("B", "C");
        // graph.addEdges("C", "A");
        // graph.addEdges("D", "A");
        // System.out.println(graph.isCyclic());

        //------------------------------------------------------------------------------------------------------------

        //undirected weighted graph
        // WeightedGraph graph = new WeightedGraph();
        // graph.addNode("A");
        // graph.addNode("B");
        // graph.addNode("C");
        // graph.addEdge("A", "B",4);
        // graph.addEdge("A", "C", 3);
        // graph.print();  

        //uisng oops
        WeightedGraphUsingOOPS graph = new WeightedGraphUsingOOPS();
        // graph.addNode("A");
        // graph.addNode("B");
        // graph.addNode("C");
        // graph.addEdge("A", "B",4);
        // graph.addEdge("A", "C", 3);
        // graph.print(); 

        //for dijkstra algo
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "C", 4);
        graph.addEdge("A", "D", 2);
        graph.addEdge("B", "D", 6);
        graph.addEdge("B", "E", 1);
        graph.addEdge("C", "D", 1);
        graph.addEdge("D", "E", 5);
        System.out.println(graph.shortestDistance("A", "E"));
        System.out.println(graph.shortestPath("A", "E"));
        System.out.println(graph.hasCycle());
    }
}