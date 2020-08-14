package leetcode2;

import structure.tree.BinaryTree;

import java.util.Arrays;
import java.util.List;

public class LeetCode106 {


    public static void main(String[] args) {
        List<Integer> post = Arrays.asList(1, 9, 7, 20, 3);
        List<Integer> in = Arrays.asList(1, 9, 3, 20, 7);
        BinaryTree.Node node = recoverByPostInOrder(post, in);
        BinaryTree.printLevelOrder(node);
    }

    /**
     * 从还原二叉树
     *
     * @param post 后序遍历
     * @param in   中序遍历
     * @return 二叉树根节点
     */
    private static BinaryTree.Node recoverByPostInOrder(List<Integer> post, List<Integer> in) {
        if (post == null || post.size() == 0 || in == null || in.size() == 0) {
            return null;
        }
        // 后序遍历最后一个即当前根节点
        int rootData = post.get(post.size() - 1);
        // 根结点坐标 中序遍历中根结点负责切分左右节点的遍历
        int rootIndex = in.indexOf(rootData);
        BinaryTree.Node root = new BinaryTree.Node(rootData);
        // 如果左边还有值，说明有左节点
        if (rootIndex > 0) {
            root.left = recoverByPostInOrder(post.subList(0, rootIndex), in.subList(0, rootIndex));
        }
        // 如果右边还有值，说明有右节点
        if (rootIndex < in.size() - 1) {
            root.right = recoverByPostInOrder(post.subList(rootIndex, post.size() - 1), in.subList(rootIndex + 1, in.size()));
        }
        return root;
    }
}
