package leetcode5;

import structure.tree.BinaryTree;

public class LeetCode450 {

    public static void main(String[] args) {
        BinaryTree.Node node = BinaryTree.buildByIntArr(new Integer[]{5, 3, 6, 2, 4, null, 7});
        BinaryTree.printLevelOrder(node);
        deleteNode(node, 3);
        BinaryTree.printLevelOrder(node);
    }

    /**
     * 删除二叉搜索树中的节点
     *
     * @param root 二叉树根节点
     * @param key  指定删除的值
     * @return 删除后二叉树
     */
    private static BinaryTree.Node deleteNode(BinaryTree.Node root, int key) {
        if (root == null) {
            return null;
        }
        if (root.data > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.data < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            BinaryTree.Node minNode = getMin(root.right);
            root.data = minNode.data;
            root.right = (deleteNode(root.right, root.data));
        }
        return root;
    }

    private static BinaryTree.Node getMin(BinaryTree.Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
