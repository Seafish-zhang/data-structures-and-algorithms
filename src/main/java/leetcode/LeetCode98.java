package leetcode;

import structure.tree.BinaryTree;

public class LeetCode98 {

    public static void main(String[] args) {
        BinaryTree.Node node1 = new BinaryTree.Node(2);
        BinaryTree.Node node2 = new BinaryTree.Node(1);
        BinaryTree.Node node3 = new BinaryTree.Node(3);
        node1.left = node2;
        node1.right = node3;
        System.out.println(validBSTree(node1));
        BinaryTree.Node node21 = new BinaryTree.Node(5);
        BinaryTree.Node node22 = new BinaryTree.Node(1);
        BinaryTree.Node node23 = new BinaryTree.Node(4);
        BinaryTree.Node node24 = new BinaryTree.Node(3);
        BinaryTree.Node node25 = new BinaryTree.Node(6);
        node21.left = node22;
        node21.right = node23;
        node23.left = node24;
        node23.right = node25;
        System.out.println(validBSTree(node21));
    }

    /**
     * 判断是否二叉搜索树.
     *
     * @param root 树根节点
     * @return 是否二叉搜索树
     */
    private static boolean validBSTree(BinaryTree.Node root) {
        if (root == null) {
            return true;
        }
        return valid(root.left, Integer.MIN_VALUE, root.data)
                && valid(root.right, root.data, Integer.MAX_VALUE);
    }

    private static boolean valid(BinaryTree.Node node, int minValue, int maxValue) {
        if (node == null) {
            return true;
        }
        if (node.data <= minValue || node.data >= maxValue) {
            return false;
        }
        return valid(node.left, Integer.MIN_VALUE, node.data)
                && valid(node.right, node.data, Integer.MAX_VALUE);
    }
}
