package leetcode2;

import structure.link.LinkListTest;

public class LeetCode147 {

    public static void main(String[] args) {
        LinkListTest.Node node1 = getTestNode();
        System.out.println(node1.print());
        System.out.println(insertSort(node1).print());
        node1 = getTestNode();
        System.out.println(mergeSort(node1).print());
    }

    private static LinkListTest.Node getTestNode() {
        LinkListTest.Node node1 = new LinkListTest.Node(7);
        LinkListTest.Node node2 = new LinkListTest.Node(5);
        LinkListTest.Node node3 = new LinkListTest.Node(2);
        LinkListTest.Node node4 = new LinkListTest.Node(4);
        LinkListTest.Node node5 = new LinkListTest.Node(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        return node1;
    }

    /**
     * 插入排序链表
     *
     * @param head 链表头结点
     * @return 排好序的链表
     */
    private static LinkListTest.Node insertSort(LinkListTest.Node head) {
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

    /**
     * 归并排序链表
     * <p>要求时间复杂度为O(n log n)</p>
     *
     * @param head 头结点
     * @return 排序后链表
     */
    private static LinkListTest.Node mergeSort(LinkListTest.Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 使用归并排序，时间复杂度为O(n log n）
        LinkListTest.Node slow = head;
        LinkListTest.Node fast = head;
        LinkListTest.Node prev = null;
        // 使用快慢前进步伐找出中间结点
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 去除第一段的后缀
        assert prev != null;
        prev.next = null;

        LinkListTest.Node front = mergeSort(head);
        LinkListTest.Node back = mergeSort(slow);
        return LinkListTest.merge(front, back);
    }
}
