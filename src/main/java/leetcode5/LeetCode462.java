package leetcode5;

import java.util.Arrays;

public class LeetCode462 {

    public static void main(String[] args) {
        System.out.println(minMove(new int[]{1, 2, 3}));
        System.out.println(minMove(new int[]{1, 2, 3, 4}));
    }

    /**
     * 最少移动次数使数据元素相等Ⅱ
     * <p>整数数组中元素每次移动可将选定一个元素加1或者减1</p>
     *
     * @param nums 数组
     * @return 最少移动次数
     */
    private static int minMove(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        if (nums.length % 2 != 0) {
            int median = nums[nums.length / 2];
            for (int num : nums) {
                result += Math.abs(num - median);
            }
        } else {
            int median = nums[nums.length / 2];
            for (int num : nums) {
                result += Math.abs(num - median);
            }
            int result2 = 0;
            median = nums[nums.length / 2 - 1];
            for (int num : nums) {
                result2 += Math.abs(num - median);
            }
            result = Math.min(result, result2);
        }
        return result;
    }
}
