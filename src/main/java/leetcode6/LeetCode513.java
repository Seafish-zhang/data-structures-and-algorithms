package leetcode6;

import structure.tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode513 {

    public static void main(String[] args) {
        BinaryTree.Node root = BinaryTree.buildByIntArr(new Integer[]{1, 2, 3, 4, null, 5, 6, null, 7});
        System.out.println(findBottomLeftValue(root));
    }

    /**
     * 寻找树最下面最左节点
     *
     * @param root 根节点
     * @return 目标节点的值
     */
    private static int findBottomLeftValue(BinaryTree.Node root) {
        Queue<BinaryTree.Node> queue = new LinkedList<>();
        queue.offer(root);
        // 最左节点
        BinaryTree.Node leftMost = root;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTree.Node curr = queue.poll();
                if (i == 0) {
                    leftMost = curr;
                }
                assert curr != null;
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
        return leftMost.data;
    }
}
