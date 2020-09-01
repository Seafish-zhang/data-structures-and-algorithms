package leetcode3;

import java.util.Arrays;

public class LeetCode283 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 0, 6, 0, 12, 3, 5, 7};
        moveZero(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{1, 3, 2, 0, 6, 0, 12, 7};
        moveZero2(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 移动零到末尾
     *
     * @param nums 数组
     */
    private static void moveZero(int[] nums) {
        int zeroCount = 0;
        for (int i = 0; i < nums.length - zeroCount; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length - zeroCount; j++) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
                zeroCount++;
            }
        }
    }

    /**
     * 移动零到末尾
     *
     * @param nums 数组
     */
    private static void moveZero2(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
        }
        for (; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
