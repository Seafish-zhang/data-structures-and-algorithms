package leetcode2;

import structure.tree.BinaryTree;
import structure.tree.BinaryTreeIterator;

public class LeetCode173 {

    public static void main(String[] args) {
        BinaryTree.Node node1 = new BinaryTree.Node(10);
        BinaryTree.Node node2 = new BinaryTree.Node(5);
        BinaryTree.Node node3 = new BinaryTree.Node(13);
        BinaryTree.Node node4 = new BinaryTree.Node(3);
        BinaryTree.Node node5 = new BinaryTree.Node(6);
        BinaryTree.Node node6 = new BinaryTree.Node(11);
        BinaryTree.Node node7 = new BinaryTree.Node(15);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        BinaryTreeIterator iterator = new BinaryTreeIterator(node1);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
