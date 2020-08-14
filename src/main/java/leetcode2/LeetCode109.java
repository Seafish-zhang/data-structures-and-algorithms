package leetcode2;

import structure.link.LinkListTest;
import structure.tree.BinaryTree;

public class LeetCode109 {

    public static void main(String[] args) {
        LinkListTest.Node node1 = new LinkListTest.Node(1);
        LinkListTest.Node node2 = new LinkListTest.Node(3);
        LinkListTest.Node node3 = new LinkListTest.Node(4);
        LinkListTest.Node node4 = new LinkListTest.Node(7);
        LinkListTest.Node node5 = new LinkListTest.Node(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        BinaryTree.Node tree = buildTree(node1);
        BinaryTree.printLevelOrder(tree);
    }

    /**
     * 排序链表转为搜索二叉树
     *
     * @param head 链表头结点
     * @return 二叉树根节点
     */
    private static BinaryTree.Node buildTree(LinkListTest.Node head) {
        return buildTree(head, null);
    }

    private static BinaryTree.Node buildTree(LinkListTest.Node start, LinkListTest.Node end) {
        if (start == end) {
            return null;
        }
        LinkListTest.Node mid = start;
        LinkListTest.Node fast = start;
        while (fast != end && fast.next != end) {
            mid = mid.next;
            fast = fast.next.next;
        }
        BinaryTree.Node root = new BinaryTree.Node(mid.value);
        root.left = buildTree(start, mid);
        root.right = buildTree(mid.next, end);
        return root;
    }
}
