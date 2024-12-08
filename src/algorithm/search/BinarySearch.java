package algorithm.search;

public class BinarySearch<T extends Comparable<T>> implements Search<T> {

    @Override
    public int search(T[] array, T element) {
        return binarySearch(array, element, 0, array.length - 1);
    }

    private int binarySearch(T[] array, T element, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        if (array[mid].compareTo(element) == 0) {
            return mid;
        }

        if (array[mid].compareTo(element) > 0) {
            return binarySearch(array, element, low, mid - 1);
        }

        return binarySearch(array, element, mid + 1, high);
    }
}
