package leetcode5;

public class LeetCode421 {

    public static void main(String[] args) {
        System.out.println(maxXor(new int[]{3, 10, 5, 25, 2, 8}));
    }

    /**
     * 数组中两个数的最大异或值
     *
     * @param nums 数组
     * @return 最大异或值
     */
    private static int maxXor(int[] nums) {
        int x = 0;
        int y = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] ^ nums[j]) > max) {
                    x = nums[i];
                    y = nums[j];
                    max = nums[i] ^ nums[j];
                }
            }
        }
        System.out.println("x = " + x + " y = " + y);
        return max;
    }
}
