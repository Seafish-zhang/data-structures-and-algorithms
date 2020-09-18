package leetcode5;

import leetcode.LeetCode77;

import java.util.ArrayList;
import java.util.List;

public class LeetCode403 {

    public static void main(String[] args) {
        List<List<Integer>> list = frogPassRiver(new int[]{0, 1, 3, 5, 6, 8, 12, 17});
        LeetCode77.printlnDoubleList(list);
        System.out.println("============================");
        list = frogPassRiver(new int[]{0, 1, 2, 3, 4, 8, 9, 11});
        LeetCode77.printlnDoubleList(list);
    }

    /**
     * 青蛙过河
     * <p>青蛙只能跳上石头，不能跳入水中，给定石子位置数组 nums</p>
     * <p>青蛙开始站在第一个石子上，第一步只能跳一格</p>
     * <p>如果青蛙上一步跳了K格，那么下一步可以跳 k，k-1，k+1格</p>
     * <p>求青蛙是否能跳到最后一个石子</p>
     *
     * @param nums 石子位置数组
     * @return 青蛙跳的石子索引集合
     */
    private static List<List<Integer>> frogPassRiver(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> single = new ArrayList<>();
        match(result, single, 0, 0, nums);
        return result;
    }

    private static void match(List<List<Integer>> result, List<Integer> single, int current, int lastStep, int[] nums) {
        if (nums[nums.length - 1] >= nums[current] - 1
                && nums[nums.length - 1] <= nums[current] + 1) {
            result.add(new ArrayList<>(single));
        } else {
            for (int i = current + 1; i < nums.length; i++) {
                if (nums[i] >= nums[current] + lastStep - 1
                        && nums[i] <= nums[current] + lastStep + 1) {
                    single.add(i);
                    match(result, single, i, nums[i] - nums[current], nums);
                    single.remove(single.size() - 1);
                } else if (nums[i] > nums[current] + lastStep + 1) {
                    break;
                }
            }
        }
    }
}
