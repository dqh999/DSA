import graph.AdjacencyListGraph;
import graph.GraphADT;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        GraphADT<String> graph = new AdjacencyListGraph<>();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");

        System.out.println("Size of the graph: " + graph.size());

        System.out.println("BFS Traversal from A:");
        Iterator<String> bfs = graph.iteratorBFS("A");
        while (bfs.hasNext()) {
            System.out.print(bfs.next() + " ");
        }

        System.out.println("\n");

        System.out.println("DFS Traversal from A:");
        Iterator<String> dfs = graph.iteratorDFS("A");
        while (dfs.hasNext()) {
            System.out.print(dfs.next() + " ");
        }

        System.out.println("\n");

        System.out.println("Removing edge between A and B...");
        graph.removeEdge("A", "B");

        System.out.println("Removing vertex C...");
        graph.removeVertex("C");

        System.out.println("Size of the graph after modifications: " + graph.size());
    }
}
