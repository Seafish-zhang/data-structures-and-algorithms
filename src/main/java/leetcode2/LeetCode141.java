package leetcode2;

import structure.link.LinkListTest;

public class LeetCode141 {

    public static void main(String[] args) {
        LinkListTest.Node node1 = new LinkListTest.Node(5);
        LinkListTest.Node node2 = new LinkListTest.Node(4);
        LinkListTest.Node node3 = new LinkListTest.Node(3);
        LinkListTest.Node node4 = new LinkListTest.Node(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node3;
        System.out.println(hasCycle(node1));
        LinkListTest.Node node = fistCycle(node1);
        System.out.println(node == null ? "null" : node.value);
    }

    /**
     * 检查是否有环
     *
     * @param head 头结点
     * @return 是否有环
     */
    private static boolean hasCycle(LinkListTest.Node head) {
        LinkListTest.Node slow = head;
        LinkListTest.Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 返回入环的第一个点
     *
     * @param head 头结点
     * @return 入环的第一个点
     */
    private static LinkListTest.Node fistCycle(LinkListTest.Node head) {
        LinkListTest.Node slow = head;
        LinkListTest.Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                LinkListTest.Node slow2 = head;
                while (slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}
