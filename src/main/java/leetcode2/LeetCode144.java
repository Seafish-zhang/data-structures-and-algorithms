package leetcode2;

import structure.tree.BinaryTree;

import java.util.*;

public class LeetCode144 {

    public static void main(String[] args) {
        BinaryTree.Node node1 = new BinaryTree.Node(101);
        BinaryTree.Node node2 = new BinaryTree.Node(102);
        BinaryTree.Node node3 = new BinaryTree.Node(103);
        BinaryTree.Node node4 = new BinaryTree.Node(104);
        BinaryTree.Node node5 = new BinaryTree.Node(105);
        BinaryTree.Node node6 = new BinaryTree.Node(106);
        BinaryTree.Node node7 = new BinaryTree.Node(107);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(listToString(prevOrder(node1)));
        System.out.println(listToString(postOrder(node1)));
        System.out.println(listToString(inOrder(node1)));
    }

    private static String listToString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            sb.append(integer).append(" ");
        }
        return sb.toString();
    }

    /**
     * 先序遍历
     *
     * @param root 根节点
     * @return 遍历列表
     */
    private static List<Integer> prevOrder(BinaryTree.Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        } else {
            Stack<BinaryTree.Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                BinaryTree.Node poll = stack.pop();
                result.add(poll.data);

                if (poll.right != null) {
                    stack.push(poll.right);
                }
                if (poll.left != null) {
                    stack.push(poll.left);
                }
            }
        }
        return result;
    }

    /**
     * 后序遍历
     *
     * @param root 根节点
     * @return 遍历列表
     */
    private static List<Integer> postOrder(BinaryTree.Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        } else {
            Stack<BinaryTree.Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                BinaryTree.Node poll = stack.pop();
                result.add(poll.data);
                if (poll.left != null) {
                    stack.push(poll.left);
                }
                if (poll.right != null) {
                    stack.push(poll.right);
                }
            }
        }
        Collections.reverse(result);
        return result;
    }

    /**
     * 中序遍历
     *
     * @param root 根节点
     * @return 遍历列表
     */
    private static List<Integer> inOrder(BinaryTree.Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        } else {
            Map<BinaryTree.Node, Integer> exist = new HashMap<>();
            Stack<BinaryTree.Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                BinaryTree.Node poll = stack.pop();
                // 如果没有子节点或者子节点已在栈内，可以消费
                if ((poll.left == null || exist.containsKey(poll.left))
                        && (poll.right == null || exist.containsKey(poll.right))) {
                    result.add(poll.data);
                } else {
                    // 否则，则根据左中右的顺序推入栈
                    if (poll.left != null && !exist.containsKey(poll.left)) {
                        exist.put(poll.left, 1);
                        stack.push(poll.left);
                    }
                    stack.push(poll);
                    if (poll.right != null && !exist.containsKey(poll.right)) {
                        exist.put(poll.right, 1);
                        stack.push(poll.right);
                    }
                }
            }
        }
        Collections.reverse(result);
        return result;
    }


}
