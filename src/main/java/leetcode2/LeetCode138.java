package leetcode2;

import java.util.HashMap;
import java.util.Map;

public class LeetCode138 {

    public static void main(String[] args) {
        RandomLinkedNode node1 = new RandomLinkedNode(1);
        RandomLinkedNode node2 = new RandomLinkedNode(2);
        RandomLinkedNode node3 = new RandomLinkedNode(3);
        node1.next = node2;
        node2.next = node3;
        node1.random = node3;
        node2.random = node1;
        node3.random = node1;
        System.out.println(node1.foreachString());
        RandomLinkedNode copy = copy(node1);
        System.out.println(copy.foreachString());
    }


    private static RandomLinkedNode copy(RandomLinkedNode head) {
        RandomLinkedNode node = head;
        Map<RandomLinkedNode, RandomLinkedNode> map = new HashMap<>();
        while (node != null) {
            map.put(node, new RandomLinkedNode(node.data));
            node = node.next;
        }
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }


    private static class RandomLinkedNode {
        int data;
        RandomLinkedNode next;
        RandomLinkedNode random;

        private RandomLinkedNode(int data) {
            this.data = data;
        }

        String foreachString() {
            StringBuilder sb = new StringBuilder();
            sb.append("data : ").append(data);
            if (random != null) {
                sb.append(" random : ").append(random.data).append("\n");
            }
            if (next != null) {
                sb.append(next.foreachString());
            }
            return sb.toString();
        }
    }
}
