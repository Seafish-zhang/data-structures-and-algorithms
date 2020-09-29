package leetcode5;

public class LeetCode493 {

    public static void main(String[] args) {
        System.out.println(targetSum(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(targetSum(new int[]{1, 1, 1, 1, 1}, 5));
    }

    /**
     * 目标和
     * <p>给定一个非负整数数组,调整：在数组任意整数前面加+或者-</p>
     * <p>算出调整后最终数组和为目标值s</p>
     *
     * @param nums 数组
     * @param s    目标和
     * @return 所有可能的调整后数组数量
     */
    private static int targetSum(int[] nums, int s) {
        return match(0, nums, s);
    }

    private static int match(int i, int[] nums, int sum) {
        if (i == nums.length) {
            if (sum == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        return match(i + 1, nums, sum + nums[i]) + match(i + 1, nums, sum - nums[i]);
    }
}
