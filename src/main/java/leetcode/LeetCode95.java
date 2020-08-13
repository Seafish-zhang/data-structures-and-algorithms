package leetcode;

import structure.tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LeetCode95 {

    public static void main(String[] args) {
        int n = new Random().nextInt(5) + 1;
        List<BinaryTree.Node> nodeList = generateTree(n);
        for (BinaryTree.Node node : nodeList) {
            BinaryTree.printTree(node);
        }
    }

    private static List<BinaryTree.Node> generateTree(int n) {
        return matchTree(1, n);
    }

    private static List<BinaryTree.Node> matchTree(int start, int end) {
        List<BinaryTree.Node> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        if (start == end) {
            result.add(new BinaryTree.Node(start));
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<BinaryTree.Node> leftList = matchTree(start, i - 1);
            List<BinaryTree.Node> rightList = matchTree(i + 1, end);
            for (BinaryTree.Node left : leftList) {
                for (BinaryTree.Node right : rightList) {
                    BinaryTree.Node root = new BinaryTree.Node(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
