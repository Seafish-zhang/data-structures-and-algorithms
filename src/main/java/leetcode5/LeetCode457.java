package leetcode5;

import java.util.HashSet;
import java.util.Set;

public class LeetCode457 {

    public static void main(String[] args) {
        System.out.println(hasLoop(new int[]{-1, 2}));
        System.out.println(hasLoop(new int[]{2, -1, 1, 2, 2}));
    }

    /**
     * 环形数组循坏
     * <p>判断一个环形数组是否有循环</p>
     * <p>给定数组中有正整数和负整数</p>
     * <p>如果当前索引对应的值n是正数，则向前移动n个索引</p>
     * <p>否则移动（-n）个索引</p>
     * <p>环形数组头尾相接</p>
     * <p>循环是指经过同一个方向移动后，所达到的索引重复</p>
     *
     * @param nums 环形数组
     * @return 是否有循环
     */
    private static boolean hasLoop(int[] nums) {
        boolean direction = true;
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) > nums[i]) {
                direction = false;
            }
            HashSet<Integer> set = new HashSet<>();
            set.add(i);
            boolean result = match(set, nums, i,
                    (i + nums[i] >= 0 ? (i + nums[i]) % nums.length : nums.length + ((i + nums[i]) % nums.length)), direction);
            if (result) {
                return true;
            }
        }
        return false;
    }

    private static boolean match(Set<Integer> single, int[] nums, int start, int current, boolean direction) {

        if (current == start) {
            return single.size() != 1;
        } else {
            boolean d = Math.abs(nums[current]) <= nums[current];
            if (direction == d) {
                single.add(current);
                return match(single, nums, start, (current + nums[current] >= 0
                        ? (current + nums[current]) % nums.length
                        : nums.length + ((current + nums[current]) % nums.length)), direction);
            } else {
                return false;
            }
        }
    }
}
