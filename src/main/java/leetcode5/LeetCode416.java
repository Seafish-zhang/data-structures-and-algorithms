package leetcode5;

import leetcode.LeetCode77;

import java.util.ArrayList;
import java.util.List;

public class LeetCode416 {

    public static void main(String[] args) {
        System.out.println(canSpiltSameSumSub(new int[]{1, 5, 11, 5}));
    }

    /**
     * 数组是否能分为两个和相等的子数组
     *
     * @param nums 数组
     * @return 是否
     */
    private static boolean canSpiltSameSumSub(int[] nums) {

        int all = 0;
        for (int num : nums) {
            all += num;
        }
        if (all % 2 != 0) {
            return false;
        }
        int half = all / 2;
        List<List<Integer>> result = new ArrayList<>();
        match(result, nums, 0, 0, half, new ArrayList<>());
        LeetCode77.printlnDoubleList(result);
        return !result.isEmpty();
    }

    private static void match(List<List<Integer>> result, int[] nums, int start, int sum, int target, List<Integer> single) {
        if (sum == target) {
            result.add(new ArrayList<>(single));
        } else if (sum < target) {
            for (int i = start; i < nums.length; i++) {
                if (sum + nums[i] <= target) {
                    single.add(nums[i]);
                    match(result, nums, i + 1, sum + nums[i], target, single);
                    single.remove(single.size() - 1);
                }
            }
        }
    }
}
