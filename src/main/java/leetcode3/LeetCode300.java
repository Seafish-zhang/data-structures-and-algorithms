package leetcode3;

import java.util.Arrays;

public class LeetCode300 {

    public static void main(String[] args) {
        System.out.println(maxOrderSub(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(maxOrderSub2(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    /**
     * 最长上升子序列
     *
     * @param nums 无序整数数组
     * @return 最长的子序列长度
     */
    private static int maxOrderSub(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            len = Math.max(dp[i], len);
        }
        return len;
    }

    private static int maxOrderSub2(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int index = Arrays.binarySearch(dp, 0, len, num);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = num;
            if (index == len) {
                len++;
            }
        }
        return len;
    }

}
