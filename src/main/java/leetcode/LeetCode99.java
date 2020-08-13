package leetcode;

import structure.tree.BinaryTree;

import java.util.Comparator;
import java.util.List;

public class LeetCode99 {
    private static BinaryTree.Node first = null;
    private static BinaryTree.Node second = null;
    // 用于中序遍历模式当前访问节点的前节点，即正确形式下 pre.data < current.data
    private static BinaryTree.Node prev = new BinaryTree.Node(Integer.MIN_VALUE);
    private static int index = 0;

    public static void main(String[] args) {
        BinaryTree.Node node1 = getNode();
        List<Integer> valueList = LeetCode94.inOrder(node1);
        System.out.print("原树中序遍历 ：");
        for (Integer integer : valueList) {
            System.out.print(integer + " ");
        }
        System.out.println();
        recoverEasy(node1);
        LeetCode94.inOrder(node1);
        valueList = LeetCode94.inOrder(node1);
        System.out.print("recoverEasy结果：");
        for (Integer integer : valueList) {
            System.out.print(integer + " ");
        }
        System.out.println();
        node1 = getNode();
        recover(node1);
        LeetCode94.inOrder(node1);
        valueList = LeetCode94.inOrder(node1);
        System.out.print("recover结果：");
        for (Integer integer : valueList) {
            System.out.print(integer + " ");
        }
    }

    private static BinaryTree.Node getNode() {
        BinaryTree.Node node1 = new BinaryTree.Node(3);
        BinaryTree.Node node2 = new BinaryTree.Node(1);
        BinaryTree.Node node3 = new BinaryTree.Node(4);
        BinaryTree.Node node4 = new BinaryTree.Node(2);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        return node1;
    }


    /**
     * 恢复二叉搜索树.
     * <p>简单的做法，中序遍历后排序再赋值，适用于多个错误的点</p>
     * <p>空间复杂度为O(n)</p>
     *
     * @param root 根节点
     */
    private static void recoverEasy(BinaryTree.Node root) {
        // 获取中序遍历的值
        List<Integer> valueList = LeetCode94.inOrder(root);
        // 排序
        valueList.sort(Comparator.comparingInt(Integer::intValue));
        // 再一次遍历赋值恢复
        recoverValue(root, valueList);
    }

    private static void recoverValue(BinaryTree.Node root, List<Integer> valueList) {
        if (root == null) {
            return;
        }
        recoverValue(root.left, valueList);
        root.data = valueList.get(index++);
        recoverValue(root.right, valueList);
    }

    /**
     * 恢复二叉搜索树.
     * <p>有且仅有两个节点被错误的交换</p>
     * <p>空间复杂度为常数</p>
     *
     * @param root 根节点
     */
    private static void recover(BinaryTree.Node root) {
        traverse(root);
        int temp = first.data;
        first.data = second.data;
        second.data = temp;
    }

    private static void traverse(BinaryTree.Node root) {
        if (root == null) {
            return;
        }
        // 按照中序遍历模式 左-当前-右
        traverse(root.left);

        // 找到第一个当前节点值小于前节点值，将前节点(prev)设置为交换的第一个节点，并保存起来
        if (first == null && prev.data >= root.data) {
            first = prev;
        }
        // 更新设置交换的第二个节点为当前节点（root）
        if (first != null && prev.data >= root.data) {
            second = root;
        }

        // 后面遍历的值以本次为中序遍历前节点
        prev = root;

        traverse(root.right);
    }
}
