package structure.tree;

import java.util.Stack;

/**
 * 二叉树迭代器
 */
public class BinaryTreeIterator {
    private Stack<BinaryTree.Node> stack;

    public BinaryTreeIterator(BinaryTree.Node root) {
        stack = new Stack<>();
        pushToStack(root);
    }

    private void pushToStack(BinaryTree.Node root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        BinaryTree.Node pop = stack.pop();
        pushToStack(pop.right);
        return pop.data;
    }
}
