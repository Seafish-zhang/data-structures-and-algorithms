package leetcode2;

import structure.tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class LeetCode129 {

    public static void main(String[] args) {
        BinaryTree.Node node1 = new BinaryTree.Node(1);
        BinaryTree.Node node2 = new BinaryTree.Node(2);
        BinaryTree.Node node3 = new BinaryTree.Node(3);
        BinaryTree.Node node6 = new BinaryTree.Node(6);
        BinaryTree.Node node7 = new BinaryTree.Node(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node6;
        node3.right = node7;
        System.out.println(sumAllPath(node1));
    }

    /**
     * 求根到叶子节点数字之和.
     * <p>例如：有树如下</p>
     * <p>      1    </p>
     * <p>  2       3</p>
     * <p>则路径有 1->2 和 1->3</p>
     * <p>那么和 = 12 + 13 = 15</p>
     *
     * @param root 根节点
     * @return 所有路径的和
     */
    private static int sumAllPath(BinaryTree.Node root) {
        List<String> allPath = new ArrayList<>();
        path(allPath, root, "");
        int sum = 0;
        for (String s : allPath) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }

    private static void path(List<String> allPath, BinaryTree.Node root, String current) {
        if (root == null) {
            return;
        }
        current += root.data;
        // 如果是叶子节点，则算本条路径已走完
        if (root.left == null && root.right == null) {
            allPath.add(current);
            return;
        }
        path(allPath, root.left, current);
        path(allPath, root.right, current);
    }
}
