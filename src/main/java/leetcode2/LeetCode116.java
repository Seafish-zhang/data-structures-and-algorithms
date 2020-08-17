package leetcode2;

import structure.tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode116 {

    public static void main(String[] args) {
        BinaryTree.Node node1 = new BinaryTree.Node(7);
        BinaryTree.Node node2 = new BinaryTree.Node(6);
        BinaryTree.Node node3 = new BinaryTree.Node(5);
        BinaryTree.Node node4 = new BinaryTree.Node(4);
        BinaryTree.Node node5 = new BinaryTree.Node(3);
        BinaryTree.Node node6 = new BinaryTree.Node(2);
        BinaryTree.Node node7 = new BinaryTree.Node(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        fillSameLevel(node1);
        fillSameLevel2(node1);
        BinaryTree.printLevelOrder(node1);
    }

    /**
     * 填充同一层的兄弟节点.
     * <p>例如，下面这个二叉树,填充next节点为右兄弟节点</p>
     * <p>   1  </p>
     * <p> 2   3 </p>
     * <p>4 5 6 7 </p>
     * <p>结果：1->null 2->3->null 4->5->6->7-null</p>
     *
     * @param root 根节点
     */
    private static void fillSameLevel(BinaryTree.Node root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTree.Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            BinaryTree.Node current = new BinaryTree.Node(-1);
            for (int i = 0; i < size; i++) {
                BinaryTree.Node next = queue.poll();
                if (next != null) {
                    queue.offer(next.left);
                    queue.offer(next.right);
                    current.next = next;
                    current = next;
                }
            }
        }
    }

    /**
     * 填充同一层的兄弟节点.
     * <p>空间复杂度低</p>
     *
     * @param root 根节点
     */
    private static void fillSameLevel2(BinaryTree.Node root) {
        // 下一层级的头节点
        BinaryTree.Node head = null;
        BinaryTree.Node prev = null;
        // 当前节点
        BinaryTree.Node current = root;

        while (current != null) {
            while (current != null) {
                if (current.left != null) {
                    if (prev != null) {
                        prev.next = current.left;
                    } else {
                        head = current.left;
                    }
                    prev = current.left;
                }

                if (current.right != null) {
                    if (prev != null) {
                        prev.next = current.right;
                    } else {
                        head = current.right;
                    }
                    prev = current.right;
                }
                current = current.next;
            }
            current = head;
            head = null;
            prev = null;
        }
    }
}
