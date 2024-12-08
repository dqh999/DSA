package dataStructure.heap;

import dataStructure.tree.BinaryTreeNode;

public class HeapNode<T extends Comparable<T>> extends BinaryTreeNode<T> {
    protected HeapNode<T> parent;

    public HeapNode(T obj) {
        super(obj);
    }

    public HeapNode<T> getParent() {
        return parent;
    }

    public void setParent(HeapNode<T> node) {
        parent = node;
    }

}
