package structure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {


    public static void main(String[] args) {
        Node node1 = new Node(10);
        Node node2 = new Node(9);
        Node node3 = new Node(8);
        Node node4 = new Node(7);
        Node node5 = new Node(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        inOrder(node1);
        leftRotate(node3);
        rightRotate(node5);
        inOrder(node1);
    }

    /**
     * 按层次遍历树
     *
     * @param root 根节点
     */
    public static String printLevelOrder(BinaryTree.Node root) {
        StringBuilder result = new StringBuilder();
        if (root == null) {
            return "";
        }
        Queue<BinaryTree.Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTree.Node current = queue.poll();
                if (current != null) {
                    sb.append(current.data).append(", ");
                    result.append(current.data).append(",");
                    queue.offer(current.left);
                    queue.offer(current.right);
                } else {
                    sb.append("null").append(", ");
                    result.append("null").append(",");
                }
            }
            String string = sb.toString();
            System.out.println(string.substring(0, string.length() - 2));
        }
        String toString = result.toString();
        return toString.substring(0, toString.length() - 1);
    }

    /**
     * 按层级遍历还原
     *
     * @param levelOrder 层级遍历
     * @return 还原树根节点
     */
    public static BinaryTree.Node recoverLevelOrder(String levelOrder) {
        String[] split = levelOrder.split(",");
        if (split.length == 0) {
            return null;
        }
        Queue<BinaryTree.Node> queue = new LinkedList<>();
        BinaryTree.Node root = new BinaryTree.Node(Integer.parseInt(split[0].trim()));
        queue.offer(root);
        for (int i = 1; i < split.length; i++) {
            BinaryTree.Node current = queue.poll();
            assert current != null;
            if (!split[i].trim().equals("null")) {
                current.left = new BinaryTree.Node(Integer.parseInt(split[i].trim()));
                queue.offer(current.left);
            }
            if (!split[++i].trim().equals("null")) {
                current.right = new BinaryTree.Node(Integer.parseInt(split[i].trim()));
                queue.offer(current.right);
            }
        }
        return root;
    }

    public static void printTree(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        int current = 1;
        int next = 0;
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.print(String.format("%-4d", currentNode.data));
            current--;

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
                next++;
            }

            if (currentNode.right != null) {
                queue.offer(currentNode.right);
                next++;
            }

            if (current == 0) {
                System.out.println();
                current = next;
                next = 0;
            }
        }
        System.out.println();
    }

    private static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inOrder(node.left);
        }
        System.out.println(" " + node.data + " ");
        if (node.right != null) {
            inOrder(node.right);
        }
    }

    private static void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        if (x.parent != null) {
            y.parent = x.parent;
            if (x.parent.left == x) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        }
        y.left = x;
        x.parent = y;
    }

    private static void rightRotate(Node y) {

        Node x = y.left;
        y.left = x.right;
        if (x.right != null) {
            x.right.parent = x;
        }

        if (y.parent != null) {
            x.parent = y.parent;
            if (y.parent.left == y) {
                y.parent.left = x;
            } else {
                y.parent.right = x;
            }
        }
        x.right = y;
        y.parent = x;
    }

    public static class Node {

        public Node left;
        public Node right;
        public int data;
        // 同一层级对应右节点，用于116;
        public Node next;
        private Node parent;

        public Node(int data) {
            this.data = data;
        }
    }

}
