package leetcode2;

import structure.tree.BinaryTree;

public class LeetCode112 {

    public static void main(String[] args) {
        BinaryTree.Node node1 = getTestTreeNode();
        System.out.println(pathSum(node1, 22));
        System.out.println(pathSum(node1, 27));
        System.out.println(pathSum(node1, 18));
        System.out.println(pathSum(node1, 17));
        System.out.println(pathSum(node1, 20));
    }

    static BinaryTree.Node getTestTreeNode() {
        BinaryTree.Node node1 = new BinaryTree.Node(5);
        BinaryTree.Node node2 = new BinaryTree.Node(4);
        BinaryTree.Node node3 = new BinaryTree.Node(8);
        BinaryTree.Node node4 = new BinaryTree.Node(11);
        BinaryTree.Node node5 = new BinaryTree.Node(13);
        BinaryTree.Node node6 = new BinaryTree.Node(4);
        BinaryTree.Node node7 = new BinaryTree.Node(7);
        BinaryTree.Node node8 = new BinaryTree.Node(2);
        BinaryTree.Node node9 = new BinaryTree.Node(5);
        BinaryTree.Node node10 = new BinaryTree.Node(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node6.left = node9;
        node6.right = node10;
        return node1;
    }

    /**
     * 路径总和.
     * <p>二叉树中根到某个节点的和是否等于目标值</p>
     *
     * @param node   根节点
     * @param target 目标值
     * @return 是否匹配
     */
    private static boolean pathSum(BinaryTree.Node node, int target) {
        if (node == null) {
            return false;
        }
        // 叶子节点
        if (node.left == null && node.right == null) {
            return node.data == target;
        }
        return pathSum(node.left, target - node.data) || pathSum(node.right, target - node.data);
    }
}
