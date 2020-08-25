package leetcode3;

import java.util.Collections;
import java.util.PriorityQueue;

public class LeetCode215 {

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }


    /**
     * 数组中第K个最大元素
     *
     * @param nums 数组
     * @param k    第几个
     * @return 第K个最大元素
     */
    private static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            queue.offer(num);
        }

        while (k-- > 1) {
            queue.poll();
        }
        return queue.isEmpty() ? Integer.MIN_VALUE : queue.poll();
    }
}
