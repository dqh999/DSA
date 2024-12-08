package graph;
import java.util.Iterator;

public interface GraphADT<T> {
    void addVertex(T vertex);

    void removeVertex(T vertex);

    void addEdge(T vertex1, T vertex2);

    void removeEdge(T vertex1, T vertex2);

    Iterator<T> iteratorBFS(T startVertex);

    Iterator<T> iteratorDFS(T startVertex);

    boolean isEmpty();

    int size();
}
