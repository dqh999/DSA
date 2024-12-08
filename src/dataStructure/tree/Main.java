package dataStructure.tree;

import java.util.Iterator;


public class Main {
    public static void main(String[] args) {
        LinkedBinaryTree<Integer> leftSubTree = new LinkedBinaryTree<>(2, null, null);
        LinkedBinaryTree<Integer> rightSubTree = new LinkedBinaryTree<>(3, null, null);
        LinkedBinaryTree<Integer> tree2 = new LinkedBinaryTree<>(4, null, null);  // New subtree
        LinkedBinaryTree<Integer> tree3 = new LinkedBinaryTree<>(5, null, null);  // New subtree
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>(1, leftSubTree, rightSubTree);
        LinkedBinaryTree<Integer> largerTree = new LinkedBinaryTree<>(6, tree, tree2);
        largerTree = new LinkedBinaryTree<>(7, largerTree, tree3);

        // PreOrder traversal (Root -> Left -> Right)
        System.out.print("PreOrder traversal: ");
        Iterator<Integer> preOrderIterator = largerTree.iteratorPreOrder();
        while (preOrderIterator.hasNext()) {
            System.out.print(preOrderIterator.next() + " ");
        }
        System.out.println(); // Expected: 7 6 1 2 3 4 5

        // InOrder traversal (Left -> Root -> Right)
        System.out.print("InOrder traversal: ");
        Iterator<Integer> inOrderIterator = largerTree.iteratorInOrder();
        while (inOrderIterator.hasNext()) {
            System.out.print(inOrderIterator.next() + " ");
        }
        System.out.println(); // Expected: 2 1 3 6 4 7 5

        // PostOrder traversal (Left -> Right -> Root)
        System.out.print("PostOrder traversal: ");
        Iterator<Integer> postOrderIterator = largerTree.iteratorPostOrder();
        while (postOrderIterator.hasNext()) {
            System.out.print(postOrderIterator.next() + " ");
        }
        System.out.println(); // Expected: 2 3 1 4 5 6 7

        // LevelOrder traversal (By level)
        System.out.print("LevelOrder traversal: ");
        Iterator<Integer> levelOrderIterator = largerTree.iteratorLevelOrder();
        while (levelOrderIterator.hasNext()) {
            System.out.print(levelOrderIterator.next() + " ");
        }
        System.out.println(); // Expected: 7 6 1 2 3 4 5
    }
}
