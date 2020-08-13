package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode23 {

    public static void main(String[] args) {
        ListNode node1_1 = new ListNode(1);
        ListNode node1_2 = new ListNode(4);
        ListNode node1_3 = new ListNode(5);
        ListNode node2_1 = new ListNode(1);
        ListNode node2_2 = new ListNode(3);
        ListNode node2_3 = new ListNode(7);
        ListNode node3_1 = new ListNode(2);
        ListNode node3_2 = new ListNode(8);

        node1_1.next = node1_2;
        node1_2.next = node1_3;

        node2_1.next = node2_2;
        node2_2.next = node2_3;

        node3_1.next = node3_2;

        System.out.println(node1_1.toString());
        System.out.println(node2_1.toString());
        System.out.println(node3_1.toString());

        ListNode[] listNodes = {node1_1, node2_1, node3_1};
        System.out.println(merge(listNodes));
    }

    /**
     * 合并多个排序链表
     *
     * @param listNodes 链表头结点数组
     * @return 合并后链表头结点
     */
    private static ListNode merge(ListNode[] listNodes) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(
                Comparator.comparingInt(o -> o.value));

        for (ListNode listNode : listNodes) {
            if (listNode != null) {
                priorityQueue.offer(listNode);
            }
        }

        ListNode pre = new ListNode(-1);
        ListNode temp = pre;
        while (!priorityQueue.isEmpty()) {
            ListNode poll = priorityQueue.poll();

            temp.next = new ListNode(poll.value);
            if (poll.next != null) {
                priorityQueue.offer(poll.next);
            }
            temp = temp.next;
        }
        return pre.next;
    }

    static class ListNode {

        private ListNode next;
        private int value;

        ListNode(int value) {
            this.value = value;
        }

        public String toString() {
            String str = this.value + "->";
            if (next != null) {
                str += next.toString();
            }
            return str;
        }

    }
}
