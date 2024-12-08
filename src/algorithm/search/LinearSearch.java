package algorithm.search;

public class LinearSearch<E extends Comparable<E>> implements Search<E> {
    @Override
    public int search(E[] array, E element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(element) == 0) {
                return i;
            }
        }
        return -1;
    }
}
