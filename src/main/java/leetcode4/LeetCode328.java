package leetcode4;

import structure.link.LinkListTest;

public class LeetCode328 {

    public static void main(String[] args) {
        LinkListTest.Node head = LinkListTest.createListNode(new int[]{5, 6, 7, 8, 2, 3, 4});
        System.out.println(head.print());
        System.out.println(oddEvenList(head).print());
    }

    /**
     * 奇偶链表
     * <p>将所有的奇数节点编号（不是值）和偶数节点分别排在一起</p>
     *
     * @param head 头节点
     * @return 排好的链表
     */
    private static LinkListTest.Node oddEvenList(LinkListTest.Node head) {
        if (head != null) {
            LinkListTest.Node odd = head;
            LinkListTest.Node even = head.next;
            LinkListTest.Node evenHead = even;

            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
        }
        return head;
    }
}
