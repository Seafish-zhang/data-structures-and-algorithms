package leetcode3;

import structure.link.LinkListTest;

public class LeetCode234 {

    public static void main(String[] args) {
        LinkListTest.Node node1 = new LinkListTest.Node(5);
        LinkListTest.Node node2 = new LinkListTest.Node(3);
        LinkListTest.Node node3 = new LinkListTest.Node(7);
        LinkListTest.Node node4 = new LinkListTest.Node(3);
        LinkListTest.Node node5 = new LinkListTest.Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(isPalindrom(node1));
        node4.value = 6;
        System.out.println(isPalindrom(node1));
    }

    /**
     * 是否回文链表
     *
     * @param head 头结点
     * @return 结果
     */
    private static boolean isPalindrom(LinkListTest.Node head) {

        if (head == null) {
            return true;
        }
        LinkListTest.Node slow = head;
        LinkListTest.Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        LinkListTest.Node reverse = LeetCode206.reverse(slow.next);
        LinkListTest.Node firstHead = head;
        while (firstHead != null && reverse != null) {
            if (firstHead.value != reverse.value) {
                return false;
            }
            firstHead = firstHead.next;
            reverse = reverse.next;
        }
        return true;
    }
}
