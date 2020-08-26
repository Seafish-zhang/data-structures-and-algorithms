package leetcode3;

import structure.tree.BinaryTree;

public class LeetCode222 {

    public static void main(String[] args) {
        BinaryTree.Node node1 = new BinaryTree.Node(6);
        BinaryTree.Node node2 = new BinaryTree.Node(7);
        BinaryTree.Node node3 = new BinaryTree.Node(5);
        BinaryTree.Node node4 = new BinaryTree.Node(3);
        BinaryTree.Node node5 = new BinaryTree.Node(1);
        BinaryTree.Node node6 = new BinaryTree.Node(0);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        System.out.println(nodeCount(node1));
    }

    private static int nodeCount(BinaryTree.Node root) {
        int leftHeight = getHeight(root, true);
        int rightHeight = getHeight(root, false);

        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        } else {
            return 1 + nodeCount(root.left) + nodeCount(root.right);
        }
    }

    private static int getHeight(BinaryTree.Node root, boolean left) {
        int height = 0;
        while (root != null) {
            height++;
            if (left) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return height;
    }
}
