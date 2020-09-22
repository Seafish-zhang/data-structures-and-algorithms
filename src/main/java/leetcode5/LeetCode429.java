package leetcode5;

public class LeetCode429 {

    public static void main(String[] args) {
        int i = 1;
        Node node1 = new Node(i++);
        Node node2 = new Node(i++);
        Node node3 = new Node(i++);
        Node node4 = new Node(i++);
        Node node5 = new Node(i);
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node4.next = node5;
        node5.prev = node4;
        node2.last = node4;
        System.out.println(node1.print());
        flatten(node1);
        System.out.println(node1.print());

    }

    /**
     * 扁平化多级双向链表
     *
     * @param head 多级双向链表头节点
     */
    private static void flatten(Node head) {
        Node current = head;
        while (current != null) {
            if (current.last != null) {
                Node next = current.next;
                flatten(current.last);
                Node last = current.last;
                while (last.next != null) {
                    last = last.next;
                }
                current.next = current.last;
                current.next.prev = current;
                current.last = null;
                last.next = next;
                if (next != null) {
                    next.prev = last;
                }
            }
            current = current.next;
        }
    }

    private static class Node {

        int data;
        Node next;
        Node last;
        Node prev;

        Node(int data) {
            this.data = data;
        }

        String print() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(data).append("-");
            if (next != null) {
                stringBuilder.append(next.print());
            }
            return stringBuilder.toString();
        }
    }
}
