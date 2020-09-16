package leetcode4;

import leetcode.LeetCode77;

import java.util.ArrayList;
import java.util.List;

public class LeetCode377 {

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum(new int[]{1, 2, 3}, 4);
        LeetCode77.printlnDoubleList(lists);

        lists = combinationSum(new int[]{1, 2, 3, 4}, 10);
        LeetCode77.printlnDoubleList(lists);
    }

    /**
     * 组合总和Ⅳ
     *
     * @param nums   正整数数组
     * @param target 目标值
     * @return 所有匹配组合列表
     */
    private static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        match(result, nums, new ArrayList<>(), target);
        return result;
    }

    private static void match(List<List<Integer>> result, int[] nums, List<Integer> single, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(single));
        } else if (target > 0) {
            for (int num : nums) {
                single.add(num);
                match(result, nums, single, target - num);
                single.remove(single.size() - 1);
            }
        }
    }
}
