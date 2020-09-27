package leetcode5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode480 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 4)));
    }

    /**
     * 滑动窗口中位数
     *
     * @param nums 数组
     * @param k    窗口大小
     * @return 中位数数组
     */
    private static double[] medianSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k == 0) {
            return new double[0];
        }

        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> min = new PriorityQueue<>(Comparator.comparingInt(o -> o));

        double[] result = new double[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                add(max, min, nums[i]);
                if (i == k - 1) {
                    result[0] = getMedian(max, min);
                }
            } else {
                remove(max, min, nums[i - k]);
                add(max, min, nums[i]);
                result[i - k] = getMedian(max, min);
            }
        }

        return result;
    }

    private static void remove(PriorityQueue<Integer> max, PriorityQueue<Integer> min, int num) {
        if (num < getMedian(max, min)) {
            max.remove(num);
        } else {
            min.remove(num);
        }
        if (max.size() > min.size()) {
            min.offer(max.poll());
        }
        if (min.size() - max.size() > 1) {
            max.offer(min.poll());
        }
    }

    private static void add(PriorityQueue<Integer> max, PriorityQueue<Integer> min, int num) {
        if (num < getMedian(max, min)) {
            max.offer(num);
        } else {
            min.offer(num);
        }
        if (max.size() > min.size()) {
            min.offer(max.poll());
        }
        if (min.size() - max.size() > 1) {
            max.offer(min.poll());
        }
    }

    private static double getMedian(PriorityQueue<Integer> max, PriorityQueue<Integer> min) {
        if (max.isEmpty() && min.isEmpty()) {
            return 0;
        } else if (max.size() == min.size()) {
            return (max.peek() + min.peek()) / 2.0;
        } else {
            return min.isEmpty() ? 0 : min.peek();
        }
    }
}
