package leetcode5;

import leetcode.LeetCode77;

import java.util.ArrayList;
import java.util.List;

public class LeetCode456 {

    public static void main(String[] args) {
        System.out.println(has132Pattern(new int[]{1, 2, 3, 4}));
        System.out.println(has132Pattern(new int[]{3, 1, 4, 2}));
        System.out.println(has132Pattern(new int[]{-1, 3, 2, 0}));
    }

    /**
     * 132模式
     * <p>给定整数序列中，如果含有132模式序列就返回true，否则false</p>
     * <p>132模式指：存在i<j<k,使得a[i]<a[k]<a[j]</p>
     *
     * @param nums 整数数组
     * @return 是否含有132模式的子序列
     */
    private static boolean has132Pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        List<List<Integer>> result = new ArrayList<>();
        match(result, nums, 0, new ArrayList<>(3));
        LeetCode77.printlnDoubleList(result);
        return !result.isEmpty();
    }

    private static void match(List<List<Integer>> result, int[] nums, int start, ArrayList<Integer> single) {

        if (single.size() == 3) {
            result.add(new ArrayList<>(single));
        } else {
            for (int i = start; i < nums.length; i++) {
                if (single.size() == 0
                        || (single.size() == 1 && nums[i] > single.get(0))
                        || (single.size() == 2 && nums[i] > single.get(0) && nums[i] < single.get(1))) {
                    single.add(nums[i]);
                    match(result, nums, i + 1, single);
                    single.remove(single.size() - 1);
                }
            }
        }

    }

}
