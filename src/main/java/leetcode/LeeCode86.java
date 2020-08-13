package leetcode;

import structure.link.LinkListTest;

public class LeeCode86 {


    public static void main(String[] args) {
        LinkListTest.Node node1 = new LinkListTest.Node(1);
        LinkListTest.Node node2 = new LinkListTest.Node(5);
        LinkListTest.Node node3 = new LinkListTest.Node(3);
        LinkListTest.Node node4 = new LinkListTest.Node(4);
        LinkListTest.Node node5 = new LinkListTest.Node(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println("原链表 ：" + node1.print());
        node1 = separate(node1, 1);
        System.out.println("x = 1 : " + node1.print());
        node1 = separate(node1, 4);
        System.out.println("x = 4 : " + node1.print());
    }

    /**
     * 分隔链表.
     *
     * @param head 链表头结点
     * @param x    分隔值
     * @return 返回分隔后链表的头结点
     */
    private static LinkListTest.Node separate(LinkListTest.Node head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        // 建立左右链表，将链表中以 x 切割分别关联到两边
        LinkListTest.Node left = new LinkListTest.Node(0);
        LinkListTest.Node right = new LinkListTest.Node(0);
        LinkListTest.Node leftCurrent = left;
        LinkListTest.Node rightCurrent = right;
        while (head != null) {
            if (head.value < x) {
                // 分到左边
                leftCurrent.next = head;
                // 继续下一个
                leftCurrent = leftCurrent.next;
            } else {
                // 同理
                rightCurrent.next = head;
                rightCurrent = rightCurrent.next;
            }
            head = head.next;
        }
        //去除循环引用
        rightCurrent.next = null;
        // 联和左边链表
        leftCurrent.next = right.next;
        // 返回开头
        return left.next;
    }
}
