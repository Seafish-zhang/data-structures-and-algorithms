package leetcode5;

import leetcode.LeetCode77;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode491 {

    public static void main(String[] args) {
        List<List<Integer>> listList = increaseSubSeq(new int[]{4, 6, 7, 7});
        LeetCode77.printlnDoubleList(listList);
    }

    /**
     * 递增子序列
     *
     * @param nums 数组
     * @return 所有递增子序列
     */
    private static List<List<Integer>> increaseSubSeq(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        match(result, nums, new ArrayList<>(), 0, null);
        return new ArrayList<>(result);
    }

    private static void match(Set<List<Integer>> result, int[] nums, List<Integer> current, int start, Integer last) {

        if (current.size() > 1) {
            result.add(new ArrayList<>(current));
        }
        if (start < nums.length) {
            for (int i = start; i < nums.length; i++) {
                if (last == null || nums[i] >= last) {
                    current.add(nums[i]);
                    match(result, nums, current, i + 1, nums[i]);
                    current.remove(current.size() - 1);
                }
            }
        }
    }
}
