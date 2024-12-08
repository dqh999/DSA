package dataStructure.stack;

public interface StackADT<T> {

    void push(T element);

    T pop();

    T peek();

    boolean isEmpty();

    int size();
}