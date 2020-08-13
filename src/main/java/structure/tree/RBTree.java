package structure.tree;

public class RBTree {


    public static void main(String[] args) {

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
        private boolean color;
        private Node parent;

        public Node(int data) {
            this.data = data;
        }
    }

}
