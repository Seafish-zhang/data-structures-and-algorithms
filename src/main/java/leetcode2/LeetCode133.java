package leetcode2;

import java.util.*;

public class LeetCode133 {

    public static void main(String[] args) {
        UndirectedGraphNode node0 = new UndirectedGraphNode(0);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        node0.neighbors.add(node1);
        node0.neighbors.add(node2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node2);
        System.out.println(node0.foreachString());
        UndirectedGraphNode clone = clone(node0);
        System.out.println(clone.foreachString());
    }

    private static UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(root.label, root);
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode poll = queue.poll();
            for (UndirectedGraphNode neighbor : poll.neighbors) {
                if (!map.containsKey(neighbor.label)) {
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.offer(neighbor);
                }
                map.get(poll.label).neighbors.add(map.get(neighbor.label));
            }
        }
        return root;
    }

    private static class UndirectedGraphNode {
        private int label;
        private List<UndirectedGraphNode> neighbors = new ArrayList<>();

        UndirectedGraphNode(int label) {
            this.label = label;
        }

        String foreachString() {
            StringBuilder sb = new StringBuilder();
            sb.append("label : ").append(label).append(" neighbors : [");
            for (UndirectedGraphNode neighbor : neighbors) {
                sb.append(neighbor.label).append(" ");
            }
            sb.append("]\n");
            for (UndirectedGraphNode neighbor : neighbors) {
                sb.append("label : ").append(neighbor.label).append(" neighbors : [");
                for (UndirectedGraphNode neighbor1 : neighbor.neighbors) {
                    sb.append(neighbor1.label).append(" ");
                }
                sb.append("]\n");
            }
            return sb.toString();

        }
    }
}
