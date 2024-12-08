package tree;

import java.util.Iterator;

public interface BinaryTreeADT<T> {
    T getRootElement();

    boolean isEmpty();

    int size();

    boolean contains(T targetElement);

    String toString();

    Iterator<T> iterator();

    Iterator<T> iteratorPreOrder();

    Iterator<T> iteratorInOrder();

    Iterator<T> iteratorPostOrder();

    Iterator<T> iteratorLevelOrder();
}
