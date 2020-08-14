package leetcode2;

import leetcode.LeetCode77;
import structure.tree.BinaryTree;

import java.util.*;

public class LeetCode102 {

    public static void main(String[] args) {
        BinaryTree.Node node1 = new BinaryTree.Node(3);
        BinaryTree.Node node2 = new BinaryTree.Node(9);
        BinaryTree.Node node3 = new BinaryTree.Node(20);
        BinaryTree.Node node4 = new BinaryTree.Node(15);
        BinaryTree.Node node5 = new BinaryTree.Node(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        LeetCode77.printlnDoubleList(levelOrder(node1, false));
        LeetCode77.printlnDoubleList(levelOrder(node1, true));
    }

    /**
     * 按层次遍历树
     *
     * @param root 根节点
     * @param flag 是否锯齿形
     * @return 遍历列表
     */
    private static List<List<Integer>> levelOrder(BinaryTree.Node root, boolean flag) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        // 是否正序
        boolean order = true;
        Queue<BinaryTree.Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTree.Node current = queue.poll();
                assert current != null;
                currentLevel.add(current.data);
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            if (order) {
                result.add(currentLevel);
            } else {
                Collections.reverse(currentLevel);
                result.add(currentLevel);
            }
            // 如果有改变
            if (flag) {
                order = !order;
            }
        }
        return result;
    }
}
