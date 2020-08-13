package leetcode;

import structure.tree.BinaryTree;

public class LeetCode100 {

    public static void main(String[] args) {
        // System.out.println(null == null);
        BinaryTree.Node node11 = new BinaryTree.Node(1);
        BinaryTree.Node node12 = new BinaryTree.Node(2);
        BinaryTree.Node node13 = new BinaryTree.Node(3);
        node11.left = node12;
        node11.right = node13;
        BinaryTree.Node node21 = new BinaryTree.Node(1);
        BinaryTree.Node node22 = new BinaryTree.Node(2);
        BinaryTree.Node node23 = new BinaryTree.Node(3);
        node21.left = node22;
        node21.right = node23;
        System.out.println(isSameTree(node11, node21));
        node21.right = node22;
        System.out.println(isSameTree(node11, node21));
    }

    /**
     * 判断两个是否相同的二叉树
     *
     * @param root1 第一个二叉树
     * @param root2 第二个二叉树
     * @return 是否相同
     */
    private static boolean isSameTree(BinaryTree.Node root1, BinaryTree.Node root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }
        return root1.data == root2.data && isSameTree(root1.left, root2.left)
                && isSameTree(root1.right, root2.right);
    }
}
