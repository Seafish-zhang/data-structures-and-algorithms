package leetcode6;

import structure.tree.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 寻找树每一行最大值
 * @Author zhy
 * @Date 2020/11/12 9:14
 **/
public class LeetCode515 {

    public static void main(String[] args) {
        BinaryTree.Node root = BinaryTree.buildByIntArr(new Integer[]{1, 3, 2, 5, 3, 5, 9, null, 7});
        maxEachRow(root).forEach(System.out::println);
    }

    /**
     * 寻找树每一行最大值
     *
     * @param root 根节点
     * @return 每行最大值数组
     */
    private static List<Integer> maxEachRow(BinaryTree.Node root) {
        Queue<BinaryTree.Node> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = 0;
            for (int i = 0; i < size; i++) {
                BinaryTree.Node curr = queue.poll();
                assert curr != null;
                max = Math.max(max, curr.data);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}
