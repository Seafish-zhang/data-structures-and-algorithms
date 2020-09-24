package leetcode5;

import java.util.HashSet;
import java.util.Set;

public class LeetCode448 {

    public static void main(String[] args) {
        Set<Integer> set = notExist(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        set.forEach(System.out::println);
    }

    /**
     * 找到所有数组中消失的数字
     * <p>给定1<= nums[i] <= n 整数数组nums,其中n是数组的长度</p>
     * <p>[1,n]范围在数组中有些数字可能出现过一次或两次，有些则没有出现</p>
     *
     * @param nums 给定整数数组
     * @return 没出现的数字列表
     */
    private static Set<Integer> notExist(int[] nums) {
        Set<Integer> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
