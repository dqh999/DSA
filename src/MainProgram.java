import algorithm.sort.QuickSort;
import algorithm.sort.Sort;
import dataStructure.queue.LinkedQueue;
import dataStructure.queue.QueueADT;
import dataStructure.stack.LinkedStack;
import dataStructure.stack.StackADT;


public class MainProgram {
    public static void main(String[] args) {
        StackADT<String> linkedStack = new LinkedStack<>();

        linkedStack.push("Hello");
        linkedStack.push("World");
        linkedStack.push("Hello1");


        QueueADT<String> linkedQueue = new LinkedQueue<>();
        linkedQueue.enqueue("Hello");
        linkedQueue.enqueue("World");
        linkedQueue.enqueue("Hello1");
        linkedQueue.enqueue("Hello2");

        System.out.println(linkedQueue.dequeue());
        System.out.println(linkedQueue.size());


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
