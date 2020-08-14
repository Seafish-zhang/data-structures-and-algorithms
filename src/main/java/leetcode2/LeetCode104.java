package leetcode2;

import structure.tree.BinaryTree;

public class LeetCode104 {

    public static void main(String[] args) {
        BinaryTree.Node node1 = new BinaryTree.Node(10);
        BinaryTree.Node node2 = new BinaryTree.Node(9);
        BinaryTree.Node node3 = new BinaryTree.Node(8);
        BinaryTree.Node node4 = new BinaryTree.Node(7);
        BinaryTree.Node node5 = new BinaryTree.Node(6);
        node1.left = node2;
        node1.right = node3;
        node3.right = node4;
        node4.left = node5;
        System.out.println(maxDepth(node1));
    }

    /**
     * 二叉树的最大深度.
     *
     * @param root 根节点
     * @return 最大深度
     */
    private static int maxDepth(BinaryTree.Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
