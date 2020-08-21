package leetcode2;

import structure.tree.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode199 {

    public static void main(String[] args) {
        BinaryTree.Node node1 = new BinaryTree.Node(7);
        BinaryTree.Node node2 = new BinaryTree.Node(2);
        BinaryTree.Node node3 = new BinaryTree.Node(3);
        BinaryTree.Node node4 = new BinaryTree.Node(4);
        BinaryTree.Node node5 = new BinaryTree.Node(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node5;
        node3.right = node4;

        List<Integer> list = sideView(node1, true);
        list.forEach(System.out::println);
        list = sideView(node1, false);
        list.forEach(System.out::println);
    }

    /**
     * 二叉树的侧视图
     *
     * @param root  树根节点
     * @param right 是否右视图，true右视图，false左视图
     * @return 侧视图列表
     */
    private static List<Integer> sideView(BinaryTree.Node root, boolean right) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<BinaryTree.Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 一层一层来，获取当前层的长度
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTree.Node poll = queue.poll();
                assert poll != null;
                // 同一层最后一个，即最右一个
                if (right && i == size - 1) {
                    result.add(poll.data);
                } else if (!right && i == 0) {
                    result.add(poll.data);
                }

                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return result;
    }
}
