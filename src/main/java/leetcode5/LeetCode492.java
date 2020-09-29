package leetcode5;

import java.util.Arrays;

public class LeetCode492 {

    public static void main(String[] args) {
        System.out.println(reversalPair(new int[]{1, 3, 2, 3, 1}));
        System.out.println(reversalPair2(new int[]{1, 3, 2, 3, 1}));
    }


    /**
     * 翻转对
     * <p>如果 i < j 且 nums[i] > 2*nums[j]</p>
     * <p>则称i j 为一对翻转对，求数组中翻转对数量</p>
     *
     * @param nums 数组
     * @return 对数
     */
    private static int reversalPair(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > 2 * nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int reversalPair2(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int cnt = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);
        for (int i = start, j = mid + 1; i <= mid; i++) {
            while (j <= end && nums[i] > nums[j] * 2.0) {
                j++;
            }
            cnt += j - (mid + 1);
        }
        Arrays.sort(nums, start, end + 1);
        return cnt;
    }

}
