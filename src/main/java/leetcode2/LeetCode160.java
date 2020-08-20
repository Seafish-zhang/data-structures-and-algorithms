package leetcode2;

import structure.link.LinkListTest;

public class LeetCode160 {

    public static void main(String[] args) {
        LinkListTest.Node node11 = new LinkListTest.Node(11);
        LinkListTest.Node node21 = new LinkListTest.Node(21);
        LinkListTest.Node node12 = new LinkListTest.Node(12);
        LinkListTest.Node node22 = new LinkListTest.Node(22);
        LinkListTest.Node node23 = new LinkListTest.Node(23);
        LinkListTest.Node node4 = new LinkListTest.Node(4);
        LinkListTest.Node node5 = new LinkListTest.Node(5);
        node11.next = node12;
        node12.next = node4;
        node4.next = node5;
        node21.next = node22;
        node22.next = node23;
        node23.next = node4;
        LinkListTest.Node node = getIntersectionNode(node11, node21);
        if (node != null) {
            System.out.println(node.value);
        }
        node = getIntersectionNode2(node11, node21);
        if (node != null) {
            System.out.println(node.value);
        }
    }


    /**
     * 相交链表
     *
     * @param head1 第一条链表
     * @param head2 第二条链表
     * @return 相交点
     */
    private static LinkListTest.Node getIntersectionNode(LinkListTest.Node head1, LinkListTest.Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        // 获取两个链表长度
        int len1 = getLen(head1);
        int len2 = getLen(head2);

        // 让长的先走，保持两者相等，相交点，一定在这块相等长度以内，因为一但两者相交后，后面的长度是一致的
        while (len1 < len2) {
            head2 = head2.next;
            len2--;
        }
        while (len1 > len2) {
            head1 = head1.next;
            len1--;
        }

        while (head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
    }

    /**
     * 获取链表的长度
     *
     * @param head 头结点
     * @return 链表的长度
     */
    private static int getLen(LinkListTest.Node head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    /**
     * 相交链表
     *
     * @param head1 第一条链表
     * @param head2 第二条链表
     * @return 相交点
     */
    private static LinkListTest.Node getIntersectionNode2(LinkListTest.Node head1, LinkListTest.Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        LinkListTest.Node a = head1;
        LinkListTest.Node b = head2;

        // 相交后长度为 z，hea1到相交点为 x，head2到相交点 y
        // a和b分别从两个链表同时走，当走到链尾时，继续从另一条链表开头走
        // 那么 a走到相交点时，第一次路程为 x，第二次为 x+z+y
        //  b走到相交点时，第一次路程为 y，第二次为 y+z+x
        // 可知，他们相遇时，就是相交点
        // 例如 hea1： 1-2-6-7 head2：3-4-5-6-7 相交点为 6
        // a b 分别走
        // a : 1-2-6-7-3-4-5-6-7
        // b : 3-4-5-6-7-1-2-6-7
        // 它们总会在相交处相等
        while (a != b) {
            a = a == null ? head2 : a.next;
            b = b == null ? head1 : b.next;
        }
        return a;
    }
}
