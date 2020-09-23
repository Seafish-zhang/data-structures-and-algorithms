package leetcode5;

import structure.tree.BinaryTree;

public class LeetCode437 {

    public static void main(String[] args) {
        BinaryTree.Node node1 = new BinaryTree.Node(10);
        BinaryTree.Node node2 = new BinaryTree.Node(5);
        BinaryTree.Node node3 = new BinaryTree.Node(-3);
        BinaryTree.Node node4 = new BinaryTree.Node(3);
        BinaryTree.Node node5 = new BinaryTree.Node(3);
        BinaryTree.Node node6 = new BinaryTree.Node(11);
        BinaryTree.Node node7 = new BinaryTree.Node(3);
        BinaryTree.Node node8 = new BinaryTree.Node(-2);
        BinaryTree.Node node9 = new BinaryTree.Node(0);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node5.right = node9;
        System.out.println(sumPath(node1, 8));
        System.out.println(sumPath(node1, 11));
    }

    /**
     * 路径总和Ⅲ
     * <p>给定一个二叉树，它的每个节点都存放着一个整数值</p>
     * <p>找出路径和等于给定数值的路径总数</p>
     *
     * @param root 二叉树
     * @param sum  给定数值
     * @return 路径和等于给定数值的总数
     */
    private static int sumPath(BinaryTree.Node root, int sum) {
        if (root == null) {
            return 0;
        }
        return sumPathFrom(root, sum) + sumPathFrom(root.left, sum) +
                sumPathFrom(root.right, sum);
    }

    private static int sumPathFrom(BinaryTree.Node root, int sum) {

        if (root == null) {
            return 0;
        }
        return (root.data == sum ? 1 : 0) + sumPath(root.left, sum - root.data)
                + sumPath(root.right, sum - root.data);
    }
}
