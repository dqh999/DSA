package dataStructure.heap;

/**
 * An interface for the Heap data structure.
 *
 * @param <T> The type of elements in the heap, which must be comparable (Comparable).
 */
public interface HeapADT<T extends Comparable<T>> {

    /**
     * Inserts a new element into the heap.
     *
     * @param element The element to be inserted.
     */
    void insert(T element);

    /**
     * Removes and returns the root element of the heap.
     *
     * @return The root element of the heap.
     */
    T remove();

    /**
     * Peeks at the root element of the heap without removing it.
     *
     * @return The root element.
     */
    T peek();

    /**
     * Checks whether the heap is empty.
     *
     * @return True if the heap is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Gets the size of the heap.
     *
     * @return The number of elements in the heap.
     */
    int size();
}
