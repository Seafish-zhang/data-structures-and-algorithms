package leetcode;

import structure.link.LinkListTest;

public class LeetCode61 {

    public static void main(String[] args) {
        LinkListTest.Node node1 = new LinkListTest.Node(1);
        LinkListTest.Node node2 = new LinkListTest.Node(2);
        LinkListTest.Node node3 = new LinkListTest.Node(3);
        node1.next = node2;
        node2.next = node3;
        System.out.println(node1.print());
        node1 = rotate(node1, 2);
        System.out.println(node1.print());
        node1 = rotate(node1, 4);
        System.out.println(node1.print());
    }

    private static LinkListTest.Node rotate(LinkListTest.Node head, int k) {
        LinkListTest.Node headTemp = head;
        int length = 1;

        while (headTemp.next != null) {
            headTemp = headTemp.next;
            length++;
        }

        headTemp.next = head;

        for (int i = length - k % length; i > 1; i--) {
            head = head.next;
        }
        headTemp = head.next;
        head.next = null;
        return headTemp;
    }
}
