package leetcode4;

import structure.link.LinkListTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LeetCode382 {

    public static void main(String[] args) {
        LinkListTest.Node node1 = new LinkListTest.Node(1);
        node1.next = new LinkListTest.Node(2);
        node1.next.next = new LinkListTest.Node(3);
        node1.next.next.next = new LinkListTest.Node(4);
        Solution solution = new Solution(node1);
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
    }

    /**
     * 链表随机节点
     */
    private static class Solution {
        private List<LinkListTest.Node> list = new ArrayList<>();
        private Random random = new Random();

        Solution(LinkListTest.Node head) {
            while (head != null) {
                list.add(head);
                head = head.next;
            }
        }

        int getRandom() {
            return list.get(random.nextInt(list.size())).value;
        }
    }
}
