package leetcode2;

import structure.link.LinkListTest;
import structure.tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class LeetCode114 {

    public static void main(String[] args) {
        BinaryTree.Node root = getTestTree();
        BinaryTree.printLevelOrder(root);
        LinkListTest.Node node = flattenExtraSpace(root);
        if (node != null) {
            System.out.println(node.print());
        }
        flatten(root);
        BinaryTree.printLevelOrder(root);
    }

    private static BinaryTree.Node getTestTree() {
        BinaryTree.Node node1 = new BinaryTree.Node(1);
        BinaryTree.Node node2 = new BinaryTree.Node(2);
        BinaryTree.Node node3 = new BinaryTree.Node(3);
        BinaryTree.Node node4 = new BinaryTree.Node(4);
        BinaryTree.Node node5 = new BinaryTree.Node(5);
        BinaryTree.Node node6 = new BinaryTree.Node(6);
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node1.right = node5;
        node5.right = node6;
        return node1;
    }


    /**
     * 二叉树展开成链表
     * <p>将原二叉树变成只有右儿子节点的树</p>
     *
     * @param root 根节点
     */
    private static void flatten(BinaryTree.Node root) {
        while (root != null) {
            if (root.left != null) {
                BinaryTree.Node previous = root.left;
                while (previous.right != null) {
                    previous = previous.right;
                }
                previous.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    /**
     * 二叉树展开成链表
     * <p>使用了额外的空间</p>
     *
     * @param root 根节点
     * @return 链表
     */
    private static LinkListTest.Node flattenExtraSpace(BinaryTree.Node root) {
        List<Integer> list = new ArrayList<>();
        prevOrder(root, list);
        if (list.size() == 0) {
            return null;
        }
        LinkListTest.Node head = new LinkListTest.Node(list.get(0));
        LinkListTest.Node next = head;
        for (int i = 1; i < list.size(); i++) {
            next.next = new LinkListTest.Node(list.get(i));
            next = next.next;
        }
        return head;
    }

    private static void prevOrder(BinaryTree.Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.data);
        prevOrder(root.left, result);
        prevOrder(root.right, result);
    }
}
