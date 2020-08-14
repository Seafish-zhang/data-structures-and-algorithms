package structure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {


    public static void main(String[] args) {

    }

    /**
     * 按层次遍历树
     *
     * @param root 根节点
     * @return 遍历列表
     */
    public static void printLevelOrder(BinaryTree.Node root) {
        if (root == null) {
            return;
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
                    queue.offer(current.left);
                    queue.offer(current.right);
                } else {
                    sb.append("null").append(", ");
                }
            }
            String string = sb.toString();
            System.out.println(string.substring(0, string.length() - 2));
        }
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
        private Node parent;

        public Node(int data) {
            this.data = data;
        }
    }

}
