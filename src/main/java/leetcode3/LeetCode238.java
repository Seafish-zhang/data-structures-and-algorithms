package leetcode3;

import java.util.Arrays;

public class LeetCode238 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(multiplyExcludeSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(multiplyExcludeSelf2(new int[]{1, 2, 3, 4})));
    }

    /**
     * 除自身以为的数组的乘积
     *
     * @param nums 数组
     * @return 结果数组
     */
    private static int[] multiplyExcludeSelf(int[] nums) {
        int[] output = new int[nums.length];
        int all = 1;
        for (int num : nums) {
            all *= num;
        }

        for (int i = 0; i < output.length; i++) {
            output[i] = all / nums[i];
        }
        return output;
    }

    private static int[] multiplyExcludeSelf2(int[] nums) {
        int[] output = new int[nums.length];
        output[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }
        int right = 1;
        int i = nums.length - 1;
        while (i >= 0) {
            output[i] *= right;
            right *= nums[i];
            i--;
        }
        return output;
    }

}
