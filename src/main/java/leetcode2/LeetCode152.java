package leetcode2;

public class LeetCode152 {

    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        maxMultiply(new int[]{2, 3, -2, 4});
        System.out.println(max);
        max = Integer.MIN_VALUE;
        maxMultiply(new int[]{-2, 0, -1});
        System.out.println(max);
        max = Integer.MIN_VALUE;
        maxMultiply(new int[]{2, 3, 4, 5, 6, -1, 8});
        System.out.println(max);
    }

    /**
     * 乘积最大子序列.
     *
     * @param nums 整数数组
     */
    private static void maxMultiply(int[] nums) {
        if (nums == null || nums.length == 0) {
            max = 0;
        } else {
            multiply(nums, 0, null);
        }
    }

    private static void multiply(int[] nums, int start, Integer current) {
        if (current != null) {
            if (current <= max) {
                return;
            } else {
                max = current;
            }
        }
        for (int i = start; i < nums.length; i++) {
            if (current == null) {
                multiply(nums, i + 1, nums[i]);
            } else {
                if (i == start)
                    multiply(nums, i + 1, current * nums[i]);
            }
        }
    }
}
