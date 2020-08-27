package leetcode3;

import structure.tree.BinaryTree;

public class LeetCode230 {

    private static int count = 0;
    private static int result = Integer.MIN_VALUE;

    public static void main(String[] args) {
        BinaryTree.Node node1 = new BinaryTree.Node(7);
        BinaryTree.Node node2 = new BinaryTree.Node(4);
        BinaryTree.Node node3 = new BinaryTree.Node(9);
        BinaryTree.Node node4 = new BinaryTree.Node(2);
        BinaryTree.Node node5 = new BinaryTree.Node(8);
        BinaryTree.Node node6 = new BinaryTree.Node(11);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        kth(node1, 3);
        System.out.println(result);
        count = 0;
        kth(node1, 4);
        System.out.println(result);
    }

    /**
     * 二叉搜索树中第k小的元素.
     *
     * @param root 根节点
     * @param k    k
     */
    private static void kth(BinaryTree.Node root, int k) {
        inorder(root, k);
    }

    private static void inorder(BinaryTree.Node root, int k) {
        if (root == null) {
            return;
        }
        inorder(root.left, k);
        count++;
        if (count == k) {
            result = root.data;
            return;
        }
        inorder(root.right, k);
    }

}
