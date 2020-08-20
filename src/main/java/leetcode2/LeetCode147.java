package leetcode2;

import structure.link.LinkListTest;

public class LeetCode147 {

    public static void main(String[] args) {
        LinkListTest.Node node1 = new LinkListTest.Node(7);
        LinkListTest.Node node2 = new LinkListTest.Node(5);
        LinkListTest.Node node3 = new LinkListTest.Node(2);
        LinkListTest.Node node4 = new LinkListTest.Node(4);
        LinkListTest.Node node5 = new LinkListTest.Node(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(node1.print());
        System.out.println(sort(node1).print());
    }

    /**
     * 插入排序链表
     *
     * @param head 链表头结点
     * @return 排好序的链表
     */
    private static LinkListTest.Node sort(LinkListTest.Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkListTest.Node temp = new LinkListTest.Node(-99);
        temp.next = head;
        LinkListTest.Node current;
        LinkListTest.Node prev = temp;
        LinkListTest.Node nextPrev = head;
        LinkListTest.Node next = head.next;
        while (next != null) {
            current = temp.next;
            while (current.value < next.value) {
                prev = current;
                current = current.next;
            }
            if (current.value > next.value) {
                nextPrev.next = next.next;
                prev.next = next;
                next.next = current;
                next = current.next;
            } else {
                nextPrev = next;
                next = next.next;
            }
        }
        return temp.next;
    }
}
