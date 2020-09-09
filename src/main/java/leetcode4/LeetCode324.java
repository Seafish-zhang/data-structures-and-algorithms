package leetcode4;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LeetCode324 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 1, 1, 6, 4};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 摆动排序Ⅱ
     * <p>给定无序数组，重新排列使其成为</p>
     * <p>nums[0] < nums[1] > nums[2] < nums[3]...</p>
     *
     * @param nums 无序数组
     */
    private static void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;
        int left = 0;
        int i = 0;
        int right = n - 1;

        while (i <= right) {
            if (nums[newIndex(i, n)] > median) {
                swap(nums, newIndex(left++, n), newIndex(i++, n));
            } else if (nums[newIndex(i, n)] < median) {
                swap(nums, newIndex(right--, n), newIndex(i, n));
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static int newIndex(int i, int n) {
        return (1 + 2 * i) % (n | 1);
    }

    private static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            maxHeap.offer(num);
        }
        while (k-- > 1) {
            maxHeap.poll();
        }
        assert !maxHeap.isEmpty();
        return maxHeap.poll();
    }
}
