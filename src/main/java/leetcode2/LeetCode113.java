package leetcode2;

import leetcode.LeetCode77;
import structure.tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class LeetCode113 {

    public static void main(String[] args) {
        BinaryTree.Node node1 = LeetCode112.getTestTreeNode();
        List<List<Integer>> listList = allPathSum(node1, 22);
        LeetCode77.printlnDoubleList(listList);
        listList = allPathSum(node1, 27);
        LeetCode77.printlnDoubleList(listList);
    }

    /**
     * 路径总和.
     * <p>二叉树中根到某个节点的和等于目标值的路径详情</p>
     *
     * @param node   根节点
     * @param target 目标值
     * @return 是否匹配
     */
    private static List<List<Integer>> allPathSum(BinaryTree.Node node, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        pathSum(node, target, result, current);
        return result;
    }

    private static void pathSum(BinaryTree.Node node, int target, List<List<Integer>> result, List<Integer> current) {
        if (node == null) {
            return;
        }
        current = new ArrayList<>(current);
        current.add(node.data);
        // 叶子节点
        if (node.left == null && node.right == null) {
            if (node.data == target) {
                result.add(current);
                return;
            }
        }
        pathSum(node.left, target - node.data, result, current);
        pathSum(node.right, target - node.data, result, current);
    }
}
