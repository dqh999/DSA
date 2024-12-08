package tree;

import exception.ElementNotFoundException;
import exception.EmptyCollectionException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {
    protected BinaryTreeNode<T> root;
    protected int count;

    public LinkedBinaryTree() {
        root = null;
        count = 0;
    }

    public LinkedBinaryTree(T element, LinkedBinaryTree<T> leftSubTree, LinkedBinaryTree<T> rightSubTree) {
        count = 1;
        root = new BinaryTreeNode<>(element);
        if (leftSubTree != null) {
            count = count + leftSubTree.getCount();
            root.setLeft(leftSubTree.getRootNode());
        } else {
            root.setLeft(null);
        }

        if (rightSubTree != null) {
            count = count + rightSubTree.getCount();
            root.setRight(rightSubTree.getRootNode());
        } else {
            root.setRight(null);
        }
    }

    @Override
    public T getRootElement() {
        if (root == null)
            throw new EmptyCollectionException("LinkedBinaryTree is empty");
        return root.getElement();
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean contains(T targetElement) {
        try {
            find(targetElement);
            return true;
        } catch (ElementNotFoundException e) {
            return false;
        }
    }

    private T find(T targetElement) {
        BinaryTreeNode<T> result = findNode(targetElement, root);
        if (result == null)
            throw new ElementNotFoundException("Element not found");
        return result.getElement();
    }

    private BinaryTreeNode<T> findNode(T targetElement, BinaryTreeNode<T> node) {
        if (node == null)
            return null;
        if (node.getElement().equals(targetElement))
            return node;
        BinaryTreeNode<T> left = findNode(targetElement, node.getLeft());
        if (left != null)
            return left;
        return findNode(targetElement, node.getRight());
    }

    @Override
    public Iterator<T> iterator() {
        ArrayList<T> temp = new ArrayList<>();
        inOrder(root, temp);
        return temp.iterator();
    }

    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayList<T> temp = new ArrayList<>();
        preOrder(root, temp);
        return temp.iterator();
    }

    private void preOrder(BinaryTreeNode<T> node, ArrayList<T> temp) {
        if (node != null) {
            temp.add(node.getElement());
            preOrder(node.getLeft(), temp);
            preOrder(node.getRight(), temp);
        }
    }

    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayList<T> temp = new ArrayList<>();
        inOrder(root, temp);
        return temp.iterator();
    }

    private void inOrder(BinaryTreeNode<T> node, ArrayList<T> temp) {
        if (node != null) {
            inOrder(node.getLeft(), temp);
            temp.add(node.getElement());
            inOrder(node.getRight(), temp);
        }
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayList<T> temp = new ArrayList<>();
        postOrder(root, temp);
        return temp.iterator();
    }

    private void postOrder(BinaryTreeNode<T> node, ArrayList<T> temp) {
        if (node != null) {
            postOrder(node.getLeft(), temp);
            postOrder(node.getRight(), temp);
            temp.add(node.getElement());
        }
    }

    @Override
    public Iterator<T> iteratorLevelOrder() {
        ArrayList<T> result = new ArrayList<>();
        if (root == null)
            return null;

        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode<T> node = queue.poll();
            result.add(node.getElement());
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }

        return result.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<T> it = iteratorInOrder();
        while (it.hasNext()) {
            sb.append(it.next()).append(" ");
        }
        return sb.toString();
    }

    private BinaryTreeNode<T> getRootNode() {
        if (root == null)
            throw new EmptyCollectionException("Linked Binary Tree is empty");
        return root;
    }

    private int getCount() {
        return count;
    }
}
