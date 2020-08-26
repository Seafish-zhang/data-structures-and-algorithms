package leetcode3;

import structure.tree.BinaryTree;

public class LeetCode226 {

    public static void main(String[] args) {
        BinaryTree.Node node1 = new BinaryTree.Node(4);
        BinaryTree.Node node2 = new BinaryTree.Node(2);
        BinaryTree.Node node3 = new BinaryTree.Node(7);
        BinaryTree.Node node4 = new BinaryTree.Node(1);
        BinaryTree.Node node5 = new BinaryTree.Node(3);
        BinaryTree.Node node6 = new BinaryTree.Node(6);
        BinaryTree.Node node7 = new BinaryTree.Node(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        BinaryTree.printLevelOrder(node1);
        invertTree(node1);
        BinaryTree.printLevelOrder(node1);
    }

    private static void invertTree(BinaryTree.Node root) {
        if (root == null) {
            return;
        }
        BinaryTree.Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
    }
}
