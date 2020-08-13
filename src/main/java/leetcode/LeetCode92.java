package leetcode;

import structure.link.LinkListTest;

public class LeetCode92 {

    public static void main(String[] args) {
        LinkListTest.Node node = LinkListTest.Node.commonUser();
        System.out.println(node.print());
        node = reversalPart(node, 2, 4);
        System.out.println(node.print());
        node = LinkListTest.Node.commonUser();
        node = reversalPart(node, 1, 3);
        System.out.println(node.print());
    }


    private static LinkListTest.Node reversalPart(LinkListTest.Node head, int m, int n) {
        LinkListTest.Node sentry = new LinkListTest.Node(-1);
        sentry.next = head;
        LinkListTest.Node front = sentry;
        // 找到开始反转的前一个位置
        for (int i = 0; i < m - 1; i++) {
            front = front.next;
        }
        LinkListTest.Node next1 = front.next;
        LinkListTest.Node next2 = next1.next;
        // 反转这部分
        for (int i = m; i < n; i++) {
            next1.next = next2.next;
            next2.next = front.next;
            front.next = next2;
            next2 = next1.next;
        }
        return sentry.next;
    }
}
