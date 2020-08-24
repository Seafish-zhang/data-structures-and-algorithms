package leetcode3;

import structure.link.LinkListTest;

public class LeetCode206 {

    public static void main(String[] args) {
        LinkListTest.Node node1 = new LinkListTest.Node(6);
        LinkListTest.Node node2 = new LinkListTest.Node(5);
        LinkListTest.Node node3 = new LinkListTest.Node(3);
        LinkListTest.Node node4 = new LinkListTest.Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(node1.print());
        System.out.println(reverse(node1).print());
    }

    /**
     * 反转链表.
     *
     * @param head 头结点
     * @return 反转后链表
     */
    private static LinkListTest.Node reverse(LinkListTest.Node head) {
        LinkListTest.Node newHead = null;
        while (head != null) {
            LinkListTest.Node next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
