package algorithm.sort;

/**
 * Sorts an array using the Bubble Sort algorithm.
 *
 * @param <T> The type of elements in the array, which must be comparable (Comparable).
 */
public class BubbleSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
