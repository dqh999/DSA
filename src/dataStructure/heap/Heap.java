package dataStructure.heap;

import dataStructure.exception.EmptyCollectionException;
import dataStructure.tree.LinkedBinaryTree;

public class Heap<T extends Comparable<T>> extends LinkedBinaryTree<T> implements HeapADT<T> {
    private HeapNode<T> lastNode;

    public Heap() {
        super();
    }

    @Override
    public void addElement(T obj) {
        HeapNode<T> node = new HeapNode<T>(obj);

        if (root == null) {
            root = node;
        } else {
            HeapNode<T> nextParent = getNextParentAdd();
            if (nextParent.getLeft() == null) {
                nextParent.setLeft(node);
            } else {
                nextParent.setRight(node);
            }
            node.setParent(nextParent);
        }

        lastNode = node;
        count++;
        if (count > 1)
            heapifyAdd();
    }

    @Override
    public T removeMin() {
        if (isEmpty())
            throw new EmptyCollectionException("Heap");

        T minElement = root.element;

        if (count == 1) {
            root = null;
            lastNode = null;
        } else {
            HeapNode<T> nextLast = getNewLastNode();
            if (lastNode.getParent().getLeft() == lastNode) {
                lastNode.getParent().setLeft(null);
            } else {
                lastNode.getParent().setRight(null);
            }

            root.element = lastNode.element;
            lastNode = nextLast;

            heapifyRemove();
        }

        count--;
        return minElement;
    }

    @Override
    public T findMin() {
        if (isEmpty())
            throw new EmptyCollectionException("Heap");
        return root.element;
    }

    private HeapNode<T> getNextParentAdd() {
        HeapNode<T> result = lastNode;
        while ((result != root) && (result.getParent().getLeft() != result)) {
            result = result.getParent();
        }

        if (result != root) {
            if (result.getParent().getRight() == null) {
                result = result.getParent();
            } else {
                result = (HeapNode<T>) result.getParent().getRight();
                while (result.getLeft() != null) {
                    result = (HeapNode<T>) result.getLeft();
                }
            }
        } else {
            while (result.getLeft() != null) {
                result = (HeapNode<T>) result.getLeft();
            }
        }

        return result;
    }

    private void heapifyAdd() {
        T temp;
        HeapNode<T> next = lastNode;

        temp = next.getElement();
        while ((next != root) && (temp.compareTo(next.getParent().getElement()) < 0)) {
            next.setElement(next.getParent().getElement());
            next = next.getParent();
        }

        next.setElement(temp);
    }

    private HeapNode<T> getNewLastNode() {
        HeapNode<T> result = lastNode;
        while ((result != root) && (result.getParent().getLeft() == result)) {
            result = result.getParent();
        }

        if (result != root) {
            result = (HeapNode<T>) result.getParent().getLeft();
        }

        while (result.getRight() != null) {
            result = (HeapNode<T>) result.getRight();
        }

        return result;
    }

    private void heapifyRemove() {
        T temp;
        HeapNode<T> node = (HeapNode<T>) root;
        HeapNode<T> left = (HeapNode<T>) node.getLeft();
        HeapNode<T> right = (HeapNode<T>) node.getRight();
        HeapNode<T> next;
        if (left == null && right == null) {
            next = null;
        } else if (left == null) {
            next = right;
        } else if (right == null) {
            next = left;
        } else if (left.getElement().compareTo(right.getElement()) < 0) {
            next = left;
        } else {
            next = right;
        }

        temp = node.getElement();
        while ((next != null) && (next.getElement().compareTo(temp) < 0)) {
            node.setElement(next.getElement());
            node = next;
            left = (HeapNode<T>) node.getLeft();
            right = (HeapNode<T>) node.getRight();
            if (left == null && right == null) {
                next = null;
            } else if (left == null) {
                next = right;
            } else if (right == null) {
                next = left;
            } else if (left.getElement().compareTo(right.getElement()) < 0) {
                next = left;
            } else {
                next = right;
            }
        }

        node.setElement(temp);
    }
}
