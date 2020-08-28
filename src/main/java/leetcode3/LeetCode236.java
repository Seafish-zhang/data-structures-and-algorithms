package leetcode3;

import structure.tree.BinaryTree;

public class LeetCode236 {

    private static BinaryTree.Node ancestor = null;

    public static void main(String[] args) {
        BinaryTree.Node node3 = new BinaryTree.Node(3);
        BinaryTree.Node node5 = new BinaryTree.Node(5);
        BinaryTree.Node node1 = new BinaryTree.Node(1);
        BinaryTree.Node node6 = new BinaryTree.Node(6);
        BinaryTree.Node node2 = new BinaryTree.Node(2);
        BinaryTree.Node node0 = new BinaryTree.Node(0);
        BinaryTree.Node node8 = new BinaryTree.Node(8);
        BinaryTree.Node node7 = new BinaryTree.Node(7);
        BinaryTree.Node node4 = new BinaryTree.Node(4);

        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node2.left = node7;
        node2.right = node4;

        try {
            commonAncestor(node3, 5, 1);
        } catch (IllegalStateException e) {
            System.out.println("find the ancestor");
        }
        if (ancestor != null) {
            System.out.println(ancestor.data);
        }
        try {
            commonAncestor(node3, 1, 8);
        } catch (IllegalStateException e) {
            System.out.println("find the ancestor");
        }
        if (ancestor != null) {
            System.out.println(ancestor.data);
        }
    }

    /**
     * 二叉树的最近公共祖先
     *
     * @param root 根节点
     * @param p    第一个值
     * @param q    第二个值
     * @return 当前节点包含两个值得数量
     */
    private static int commonAncestor(BinaryTree.Node root, int p, int q) {

        boolean current = false;
        int match = 0;
        if (root == null) {
            return 0;
        }
        if (root.data == p || root.data == q) {
            match++;
            current = true;
        }
        int left = commonAncestor(root.left, p, q);
        match += left;
        int right = commonAncestor(root.right, p, q);
        match += right;
        if (current && match == 2) {
            // 如果匹配两个时包括本身了
            ancestor = root;
            throw new IllegalStateException();
        } else if (match == 2) {
            ancestor = root;
        }
        return match;
    }
}
