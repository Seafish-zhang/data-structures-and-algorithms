package leetcode2;

import structure.tree.BinaryTree;

public class LeetCode101 {

    public static void main(String[] args) {
        BinaryTree.Node node1 = new BinaryTree.Node(7);
        BinaryTree.Node node2 = new BinaryTree.Node(2);
        BinaryTree.Node node3 = new BinaryTree.Node(2);
        BinaryTree.Node node4 = new BinaryTree.Node(3);
        BinaryTree.Node node5 = new BinaryTree.Node(4);
        BinaryTree.Node node6 = new BinaryTree.Node(4);
        BinaryTree.Node node7 = new BinaryTree.Node(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(symmetryBTree(node1));
        node2.left = null;
        node2.right = node4;
        node3.left = null;
        System.out.println(symmetryBTree(node1));
    }

    /**
     * 判断是否对称二叉树.
     *
     * @param root 根节点
     * @return 是否对称二叉树
     */
    private static boolean symmetryBTree(BinaryTree.Node root) {
        if (root == null) {
            return true;
        }
        return isSymmetry(root.left, root.right);
    }

    private static boolean isSymmetry(BinaryTree.Node left, BinaryTree.Node right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.data != right.data) {
            return false;
        }
        return isSymmetry(left.left, right.right) && isSymmetry(left.right, right.left);
    }

}
