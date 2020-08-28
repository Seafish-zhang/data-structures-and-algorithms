package leetcode3;

import structure.link.LinkListTest;

public class LeetCode237 {


    public static void main(String[] args) {
        LinkListTest.Node node1 = new LinkListTest.Node(6);
        LinkListTest.Node node2 = new LinkListTest.Node(7);
        LinkListTest.Node node3 = new LinkListTest.Node(1);
        LinkListTest.Node node4 = new LinkListTest.Node(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(node1.print());
        deleteNode(node2);
        System.out.println(node1.print());
        deleteNode(node1);
        System.out.println(node1.print());
    }

    /**
     * 删除链表中的结点
     *
     * @param node 要删除的结点
     */
    private static void deleteNode(LinkListTest.Node node) {
        if (node.next == null) {
            throw new IllegalArgumentException("当前结点为结尾结点，非法");
        }

        node.value = node.next.value;
        node.next = node.next.next;
    }
}
