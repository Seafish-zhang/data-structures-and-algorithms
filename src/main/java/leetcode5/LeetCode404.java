package leetcode5;

import structure.tree.BinaryTree;

public class LeetCode404 {

    public static void main(String[] args) {
        BinaryTree.Node node1 = new BinaryTree.Node(300);
        BinaryTree.Node node2 = new BinaryTree.Node(9);
        BinaryTree.Node node3 = new BinaryTree.Node(10);
        BinaryTree.Node node4 = new BinaryTree.Node(15);
        BinaryTree.Node node5 = new BinaryTree.Node(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(sumOfLeftLeves(node1));
    }


    /**
     * 左叶子节点的和
     *
     * @param root 根节点
     * @return 和
     */
    private static int sumOfLeftLeves(BinaryTree.Node root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        if (root.left != null) {
            //左叶子节点
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.data;
            } else {
                sum += sumOfLeftLeves(root.left);
            }
            if (root.right != null) {
                sum += sumOfLeftLeves(root.right);
            }
        }
        return sum;
    }
}
