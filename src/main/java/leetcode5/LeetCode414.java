package leetcode5;

public class LeetCode414 {


    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{1, 2, 5, 6, 6, 7, 5, 3, 8}));
        System.out.println(thirdMax(new int[]{1, 2, 2, 1, 2, 1, 2, 1, 1}));
    }


    /**
     * 返回数组中第三大的数，如果没有第三大的，则返回第一大的数
     *
     * @param nums 数组
     * @return 结果
     */
    private static int thirdMax(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        for (int num : nums) {
            max1 = Math.max(max1, num);
        }
        for (int num : nums) {
            if (num == max1) {
                continue;
            }
            max2 = Math.max(max2, num);
        }
        for (int num : nums) {
            if (num == max1 || num == max2) {
                continue;
            }
            max3 = Math.max(max3, num);
        }

        return max3 == Integer.MIN_VALUE ? max1 : max3;
    }
}
