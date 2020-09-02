package leetcode4;

public class LeetCode303 {

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
        System.out.println(numArray.sumRange(5, 0));
        System.out.println(numArray.sumRange(5, 8));
    }

    /**
     * 区域和检索
     */
    private static class NumArray {
        int[] sums;
        int length;

        NumArray(int[] nums) {
            length = nums.length;
            if (length != 0) {
                sums = new int[nums.length];
                sums[0] = nums[0];
                for (int i = 1; i < nums.length; i++) {
                    sums[i] = sums[i - 1] + nums[i];
                }
            }
        }

        int sumRange(int i, int j) {
            if (i >= j || j >= length) {
                throw new IllegalArgumentException();
            }
            if (i == 0) {
                return sums[j];
            }
            return sums[j] - sums[i - 1];
        }
    }

}
