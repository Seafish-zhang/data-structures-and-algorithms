package leetcode2;

import structure.tree.BinaryTree;

public class LeetCode124 {

    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        BinaryTree.Node node1 = new BinaryTree.Node(-10);
        BinaryTree.Node node2 = new BinaryTree.Node(91);
        BinaryTree.Node node3 = new BinaryTree.Node(10);
        BinaryTree.Node node4 = new BinaryTree.Node(17);
        BinaryTree.Node node5 = new BinaryTree.Node(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(maxPathBRTree(node1));
        System.out.println(max);
    }

    /**
     * 二叉树中的最大路径和.
     *
     * @param root 二叉树根节点
     * @return 最大路径和
     */
    private static int maxPathBRTree(BinaryTree.Node root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(maxPathBRTree(root.left), 0);
        int right = Math.max(maxPathBRTree(root.right), 0);
        max = Math.max(max, root.data + left + right);
        // 最大路径只能走一边
        return root.data + Math.max(left, right);
    }

}
