package leetcode5;

import java.util.HashSet;
import java.util.Set;

public class LeetCode442 {

    public static void main(String[] args) {
        Set<Integer> duplicate = findDuplicate(new int[]{4, 3, 2, 7, 8, 2, 3, 1, 3});
        duplicate.forEach(System.out::println);
    }

    /**
     * 数组中重复的数据
     * <p>有部分重复两次，其余的只出现一次，找出这部分数字</p>
     *
     * @param nums 数组
     * @return 重复的列表
     */
    private static Set<Integer> findDuplicate(int[] nums) {
        Set<Integer> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                result.add(Math.abs(index + 1));
            } else {
                nums[index] = -nums[index];
            }
        }
        return result;
    }
}
