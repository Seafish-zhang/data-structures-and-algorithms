package leetcode2;

import structure.tree.BinaryTree;

public class LeetCode108 {

    public static void main(String[] args) {
        BinaryTree.Node tree = buildTree(new int[]{1, 3, 4, 7, 8, 9});
        BinaryTree.printLevelOrder(tree);
    }

    /**
     * 排序数组转为搜索二叉树
     *
     * @param arr 数组
     * @return 二叉树根节点
     */
    private static BinaryTree.Node buildTree(int[] arr) {
        return buildTree(arr, 0, arr.length - 1);
    }

    private static BinaryTree.Node buildTree(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        BinaryTree.Node root = new BinaryTree.Node(arr[mid]);
        root.left = buildTree(arr, start, mid - 1);
        root.right = buildTree(arr, mid + 1, end);
        return root;
    }
}
