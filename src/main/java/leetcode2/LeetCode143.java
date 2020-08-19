package leetcode2;

import structure.link.LinkListTest;

public class LeetCode143 {

    public static void main(String[] args) {
        LinkListTest.Node node1 = new LinkListTest.Node(11);
        LinkListTest.Node node2 = new LinkListTest.Node(12);
        LinkListTest.Node node3 = new LinkListTest.Node(13);
        LinkListTest.Node node4 = new LinkListTest.Node(14);
        LinkListTest.Node node5 = new LinkListTest.Node(15);
        LinkListTest.Node node6 = new LinkListTest.Node(16);
        LinkListTest.Node node7 = new LinkListTest.Node(17);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        System.out.println(node1.print());
        reset(node1);
        System.out.println(node1.print());
    }

    /**
     * 重排链表
     * <p>原链表：node(1)->node(2)->node(3)->...node(n-1)->node(n)</p>
     * <p>重排后链表：node(1)->node(n)->node(2)->node(n-1)->...</p>
     *
     * @param head 头结点
     */
    private static void reset(LinkListTest.Node head) {
        LinkListTest.Node slow = head;
        LinkListTest.Node fast = head;
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            } else {
                break;
            }
            slow = slow.next;
        }
        LinkListTest.Node head2 = slow.next;
        slow.next = null;
        LinkListTest.Node current = head2;
        assert current != null;
        LinkListTest.Node post = current.next;
        current.next = null;
        while (post != null) {
            LinkListTest.Node temp = post.next;
            post.next = current;
            current = post;
            post = temp;
        }
        head2 = current;

        LinkListTest.Node p = head;
        LinkListTest.Node q = head2;
        while (q != null) {
            assert p != null;
            LinkListTest.Node temp1 = p.next;
            LinkListTest.Node temp2 = q.next;
            p.next = q;
            q.next = temp1;
            p = temp1;
            q = temp2;
        }
    }
}
