package leetcode4;

import java.util.ArrayList;
import java.util.List;

public class LeetCode327 {

    public static void main(String[] args) {
        System.out.println(areaSumIn(new int[]{-2, 5, -1}, -2, 2));
        System.out.println(areaSumIn(new int[]{-2, 5, -1}, -6, 6));
    }


    /**
     * 区间和的个数
     * <p>算出整数数组nums中区间的和在范围[lower，upper]间的个数</p>
     *
     * @param nums  数组
     * @param lower 范围
     * @param upper 范围
     * @return 个数
     */
    private static int areaSumIn(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum >= lower && sum <= upper) {
                list.add(i + "," + i);
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= lower && sum <= upper) {
                    list.add(i + "," + j);
                }
            }
        }
        list.forEach(System.out::println);
        return list.size();
    }
}
