package dataStructure.tree;

public class BinaryTreeNode<T> {
    private T element;
    private BinaryTreeNode<T> left, right;

    public BinaryTreeNode(T obj) {
        element = obj;
        left = null;
        right = null;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }
}
