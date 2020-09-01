package leetcode3;

import structure.tree.BinaryTree;

public class LeetCode297 {

    public static void main(String[] args) {
        BinaryTree.Node node1 = new BinaryTree.Node(8);
        BinaryTree.Node node2 = new BinaryTree.Node(7);
        BinaryTree.Node node3 = new BinaryTree.Node(5);
        BinaryTree.Node node4 = new BinaryTree.Node(3);
        BinaryTree.Node node5 = new BinaryTree.Node(6);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        String order = BinaryTree.printLevelOrder(node1);
        System.out.println("======================");
        BinaryTree.Node recover = BinaryTree.recoverLevelOrder(order);
        BinaryTree.printLevelOrder(recover);
    }
}
