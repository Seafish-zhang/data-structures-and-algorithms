package leetcode5;

import java.util.Arrays;

public class LeetCode473 {

    public static void main(String[] args) {
        System.out.println(makeSquare(new int[]{1, 1, 2, 2, 2}));
        System.out.println(makeSquare(new int[]{3, 3, 3, 3, 4}));
    }

    /**
     * 火柴拼正方形
     *
     * @param nums 火柴长度数组
     * @return 是否能在使用完情况下拼出一个完整的正方形
     */
    private static boolean makeSquare(int[] nums) {
        if (nums == null || nums.length < 4) {
            return false;
        }

        Arrays.sort(nums);
        reverse(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }

        return dfs(nums, new int[4], 0, sum / 4);
    }

    private static boolean dfs(int[] nums, int[] sums, int start, int target) {
        if (start == nums.length) {
            return sums[0] == target && sums[1] == target & sums[2] == target;
        }
        for (int i = 0; i < 4; i++) {
            if (sums[i] + nums[start] > target) {
                continue;
            }
            sums[i] += nums[start];
            if (dfs(nums, sums, start + 1, target)) {
                return true;
            }
            sums[i] -= nums[start];
        }
        return false;
    }

    private static void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            right--;
            left++;
        }
    }
}
