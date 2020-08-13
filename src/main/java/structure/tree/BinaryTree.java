package structure.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {


    public static void main(String[] args) {

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
