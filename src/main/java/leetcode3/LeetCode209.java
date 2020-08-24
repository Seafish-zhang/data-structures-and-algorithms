package leetcode3;

import java.util.ArrayList;
import java.util.List;

public class LeetCode209 {

    private static int min = Integer.MAX_VALUE;
    private static List<Integer> minList = null;

    public static void main(String[] args) {
        subArray(new int[]{2, 3, 1, 2, 4, 3}, 7);
        System.out.println(min);
        if (minList != null) {
            minList.forEach(System.out::print);
        }
        System.out.println();
        min = Integer.MAX_VALUE;
        minList = null;
        subArray(new int[]{2, 3, 1, 2, 4, 3}, 4);
        System.out.println(min);
        if (minList != null) {
            minList.forEach(System.out::print);
        }


    }

    /**
     * 长度最小的子数组
     * <p>子数组的和要大于或者等于目标值</p>
     *
     * @param nums 正整数数组
     * @param s    目标值
     */
    private static void subArray(int[] nums, int s) {
        List<Integer> current = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            match(current, nums, i, 0, s);
        }
    }

    private static void match(List<Integer> current,
                              int[] nums, int start, int sum, int target) {
        // 大于目标值就不用求后续了，因为后续肯定比当前长
        if (sum >= target) {
            if (min > current.size()) {
                min = current.size();
                minList = new ArrayList<>(current);
            }
        } else if (start < nums.length) {
            current.add(nums[start]);
            match(current, nums, start + 1, sum + nums[start], target);
            current.remove(current.size() - 1);
        }
    }

}
