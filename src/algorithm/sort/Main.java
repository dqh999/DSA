package algorithm.sort;

public class Main {
    public static void main(String[] args) {
        Sort<Integer> mergeSort = new QuickSort<>();

        Integer[] array = {1,2,42,6,3,234,6,0,1};

        System.out.println("Array before sorting:");
        for (Integer str : array) {
            System.out.print(str + " ");
        }

        mergeSort.sort(array);

        System.out.println("\nArray after sorting:");
        for (Integer str : array) {
            System.out.print(str + " ");
        }
    }
}
