package leetcode5;

import structure.link.LinkListTest;

import java.util.Stack;

public class LeetCode445 {

    public static void main(String[] args) {
        System.out.println(sum(
                LinkListTest.createListNode(new int[]{7, 2, 4, 3}),
                LinkListTest.createListNode(new int[]{5, 6, 4})
        ).print());
    }

    /**
     * 两数相加Ⅱ
     * <p>给定两个非空的链表来代表两个非负整数</p>
     *
     * @param head1 第一个链表
     * @param head2 第二个链表
     * @return 相加结果链表
     */
    private static LinkListTest.Node sum(LinkListTest.Node head1, LinkListTest.Node head2) {
        Stack<LinkListTest.Node> stack1 = new Stack<>();
        Stack<LinkListTest.Node> stack2 = new Stack<>();
        while (head1 != null) {
            stack1.push(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            stack2.push(head2);
            head2 = head2.next;
        }
        Stack<LinkListTest.Node> stackSum = new Stack<>();

        int last = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int num1 = 0;
            int num2 = 0;
            if (!stack1.isEmpty()) {
                num1 = stack1.pop().value;
            }
            if (!stack2.isEmpty()) {
                num2 = stack2.pop().value;
            }
            LinkListTest.Node sum = new LinkListTest.Node(last + (num1 + num2) % 10);
            last = (num1 + num2) / 10;
            stackSum.push(sum);
        }
        LinkListTest.Node head = stackSum.pop();
        LinkListTest.Node current = head;
        while (!stackSum.isEmpty()) {
            current.next = stackSum.pop();
            current = current.next;
        }
        return head;
    }
}
