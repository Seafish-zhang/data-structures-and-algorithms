package leetcode4;

import java.util.Arrays;

public class LeetCode315 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rightSmallCountArr(new int[]{5, 2, 6, 1})));
    }

    /**
     * 计算右侧小于当前元素的个数
     *
     * @param nums 整数数组
     * @return 右侧小于当前元素的个数数组
     */
    private static int[] rightSmallCountArr(int[] nums) {
        int[] counts = new int[nums.length];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    counts[i]++;
                }
            }
        }
        return counts;
    }
}
