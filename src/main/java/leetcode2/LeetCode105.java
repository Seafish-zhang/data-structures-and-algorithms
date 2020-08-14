package leetcode2;

import structure.tree.BinaryTree;

import java.util.Arrays;
import java.util.List;

public class LeetCode105 {


    public static void main(String[] args) {
        List<Integer> prev = Arrays.asList(3, 9, 1, 2, 20, 15, 7);
        List<Integer> in = Arrays.asList(1, 9, 2, 3, 15, 20, 7);
        BinaryTree.Node node = recoverByPrevInOrder(prev, in);
        BinaryTree.printLevelOrder(node);
    }

    /**
     * 从还原二叉树
     *
     * @param prev 前序遍历
     * @param in   中序遍历
     * @return 二叉树根节点
     */
    private static BinaryTree.Node recoverByPrevInOrder(List<Integer> prev, List<Integer> in) {
        if (prev == null || prev.size() == 0 || in == null || in.size() == 0) {
            return null;
        }
        // 前序遍历第一个即当前根节点
        int rootData = prev.get(0);
        // 根结点坐标 中序遍历中根结点负责切分左右节点的遍历
        int rootIndex = in.indexOf(rootData);
        BinaryTree.Node root = new BinaryTree.Node(rootData);
        // 如果左边还有值，说明有左节点
        if (rootIndex > 0) {
            root.left = recoverByPrevInOrder(prev.subList(1, rootIndex + 1), in.subList(0, rootIndex));
        }
        // 如果右边还有值，说明有右节点
        if (rootIndex < in.size() - 1) {
            root.right = recoverByPrevInOrder(prev.subList(rootIndex + 1, prev.size()), in.subList(rootIndex + 1, in.size()));
        }
        return root;
    }
}
