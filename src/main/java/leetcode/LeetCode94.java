package leetcode;

import structure.tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode94 {

    public static void main(String[] args) {
        BinaryTree.Node node1 = new BinaryTree.Node(1);
        BinaryTree.Node node2 = new BinaryTree.Node(2);
        BinaryTree.Node node3 = new BinaryTree.Node(3);
        BinaryTree.Node node4 = new BinaryTree.Node(4);
        node1.left = node2;
        node1.right = node3;
        node3.right = node4;
        List<Integer> inOrder = inOrder(node1);
        for (Integer integer : inOrder) {
            System.out.println(integer);
        }
    }

    /**
     * 中序遍历，不用递归形式.
     *
     * @param root 树根节点
     * @return 中序遍历列表
     */
    private static List<Integer> inOrder(BinaryTree.Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<BinaryTree.Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            while (root.left != null) {
                stack.push(root.left);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.data);
            if (root.right != null) {
                stack.push(root.right);
                root = root.right;
            }

        }
        return result;
    }
}
