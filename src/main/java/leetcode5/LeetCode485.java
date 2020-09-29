package leetcode5;

public class LeetCode485 {

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOne(new int[]{1, 1, 0, 0, 1, 1, 1}));
    }

    /**
     * 数组中连续1的最大个数
     *
     * @param nums 数组
     * @return 最大数量
     */
    private static int findMaxConsecutiveOne(int[] nums) {
        int result = 0;
        int current = 0;
        for (int num : nums) {
            current = num == 0 ? 0 : current + 1;
            result = Math.max(result, current);
        }
        return result;
    }
}
