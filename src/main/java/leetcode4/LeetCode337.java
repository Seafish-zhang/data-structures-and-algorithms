package leetcode4;

import structure.tree.BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class LeetCode337 {

    public static void main(String[] args) {
        BinaryTree.Node node1 = new BinaryTree.Node(3);
        BinaryTree.Node node2 = new BinaryTree.Node(2);
        BinaryTree.Node node3 = new BinaryTree.Node(3);
        BinaryTree.Node node4 = new BinaryTree.Node(3);
        BinaryTree.Node node5 = new BinaryTree.Node(1);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.right = node5;
        System.out.println(robDp(node1));
        node2.data = 4;
        node3.data = 5;
        node2.left = new BinaryTree.Node(1);
        System.out.println(robDp(node1));

    }


    /**
     * 打家劫舍Ⅲ
     * <p>地区房子警报形成一个二叉树结构</p>
     * <p>两个直接相连的房子被打劫，会自动报警</p>
     *
     * @param root 二叉树根节点
     * @return 最大盗取金额
     */
    private static int robDp(BinaryTree.Node root) {
        Map<BinaryTree.Node, Integer> map = new HashMap<>();
        return getMaxValue(root, map);
    }

    private static int getMaxValue(BinaryTree.Node root, Map<BinaryTree.Node, Integer> map) {
        if (root == null) {
            return 0;
        }

        if (map.containsKey(root)) {
            return map.get(root);
        }

        int val = 0;

        if (root.left != null) {
            val += getMaxValue(root.left.left, map) + getMaxValue(root.left.right, map);
        }
        if (root.right != null) {
            val += getMaxValue(root.right.left, map) + getMaxValue(root.right.right, map);
        }
        int max = Math.max(root.data + val, getMaxValue(root.left, map) + getMaxValue(root.right, map));
        map.put(root, max);
        return max;
    }
}
