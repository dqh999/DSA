package dataStructure.queue;

import dataStructure.exception.EmptyCollectionException;

public class Main {
    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        System.out.println("Enqueuing elements 1, 2, and 3...");
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Queue after enqueuing 1, 2, 3:");
        System.out.println(queue);  // Expected: 1\n2\n3\n

        // Check the first element
        try {
            System.out.println("First element in the queue: " + queue.first());  // Expected: 1
        } catch (EmptyCollectionException e) {
            System.out.println(e.getMessage());
        }

        // Dequeue elements from the queue
        try {
            System.out.println("Dequeued element: " + queue.dequeue());  // Expected: 1
            System.out.println("Dequeued element: " + queue.dequeue());  // Expected: 2
        } catch (EmptyCollectionException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("Dequeued element: " + queue.dequeue());  // Expected: 3
        } catch (EmptyCollectionException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Is the queue empty? " + queue.isEmpty());  // Expected: true
    }
}
