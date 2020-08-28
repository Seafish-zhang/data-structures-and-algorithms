package leetcode3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LeetCode239 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 4)));
    }

    /**
     * 滑动窗口最大值
     *
     * @param nums 数组
     * @param k    窗口大小
     * @return 最大值数组
     */
    private static int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                heap.offer(nums[i]);
                if (i == k - 1) {
                    assert heap.peek() != null;
                    result[0] = heap.peek();
                }
            } else {
                heap.remove(nums[i - k]);
                heap.offer(nums[i]);
                assert heap.peek() != null;
                result[i - k + 1] = heap.peek();
            }
        }

        return result;
    }
}
