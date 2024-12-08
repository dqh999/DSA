package dataStructure.graph;

import dataStructure.exception.ElementExistsException;
import dataStructure.exception.ElementNotFoundException;

import java.util.*;

public class AdjacencyListGraph<T> implements GraphADT<T> {
    private final Map<T, List<T>> adjacencyList;
    private int numVertices;

    public AdjacencyListGraph() {
        this.adjacencyList = new HashMap<>();
        this.numVertices = 0;
    }

    @Override
    public void addVertex(T vertex) {
        if (adjacencyList.containsKey(vertex)) {
            throw new ElementExistsException("Vertex '" + vertex + "' already exists in the dataStructures.graph.");
        }
        adjacencyList.put(vertex, new LinkedList<>());
        numVertices++;
    }

    @Override
    public void removeVertex(T vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            throw new ElementNotFoundException("Vertex '" + vertex + "' does not exist in the dataStructures.graph.");
        }
        adjacencyList.remove(vertex);
        numVertices--;

        for (T key : adjacencyList.keySet()) {
            adjacencyList.get(key).remove(vertex);
        }
    }

    @Override
    public void addEdge(T vertex1, T vertex2) {
        if (!adjacencyList.containsKey(vertex1)) {
            throw new ElementNotFoundException("Vertex '" + vertex1 + "' does not exist in the dataStructures.graph.");
        }
        if (!adjacencyList.containsKey(vertex2)) {
            throw new ElementNotFoundException("Vertex '" + vertex2 + "' does not exist in the dataStructures.graph.");
        }

        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);
    }

    @Override
    public void removeEdge(T vertex1, T vertex2) {
        if (!adjacencyList.containsKey(vertex1) || !adjacencyList.containsKey(vertex2)) {
            throw new ElementNotFoundException("One or both vertices do not exist in the dataStructures.graph.");
        }
        if (!adjacencyList.get(vertex1).contains(vertex2)) {
            throw new ElementNotFoundException("Edge between '" + vertex1 + "' and '" + vertex2 + "' does not exist.");
        }

        adjacencyList.get(vertex1).remove(vertex2);
        adjacencyList.get(vertex2).remove(vertex1);
    }

    @Override
    public Iterator<T> iteratorBFS(T startVertex) {
        if (!adjacencyList.containsKey(startVertex)) {
            throw new ElementNotFoundException("Start vertex '" + startVertex + "' does not exist in the dataStructures.graph.");
        }

        List<T> result = new ArrayList<>();
        Set<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();

        queue.add(startVertex);
        visited.add(startVertex);

        while (!queue.isEmpty()) {
            T current = queue.poll();
            result.add(current);

            for (T neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return result.iterator();
    }

    @Override
    public Iterator<T> iteratorDFS(T startVertex) {
        if (!adjacencyList.containsKey(startVertex)) {
            throw new ElementNotFoundException("Start vertex '" + startVertex + "' does not exist in the dataStructures.graph.");
        }

        List<T> result = new ArrayList<>();
        Set<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();

        stack.push(startVertex);

        while (!stack.isEmpty()) {
            T current = stack.pop();

            if (!visited.contains(current)) {
                visited.add(current);
                result.add(current);

                for (T neighbor : adjacencyList.get(current)) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }

        return result.iterator();
    }

    @Override
    public boolean isEmpty() {
        return numVertices == 0;
    }

    @Override
    public int size() {
        return numVertices;
    }
}
