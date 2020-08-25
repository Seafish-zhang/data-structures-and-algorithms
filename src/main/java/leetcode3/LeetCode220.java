package leetcode3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode220 {

    public static void main(String[] args) {
        System.out.println(existRepetition(new int[]{1, 2, 3, 1}));
        System.out.println(existRepetition(new int[]{1, 2, 3, 4}));
        System.out.println(repetitionInterval(new int[]{1, 2, 3, 1}, 3));
        System.out.println(repetitionInterval(new int[]{1, 0, 1, 1}, 1));
        System.out.println(repetitionInterval(new int[]{1, 2, 3, 1, 2, 3}, 2));

        System.out.println(repetitionMinInterval(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println(repetitionMinInterval(new int[]{1, 2, 1, 1}, 1, 2));
        System.out.println(repetitionMinInterval(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
    }


    /**
     * 是否存在重复元素
     *
     * @param nums 数组
     * @return 结果
     */
    private static boolean existRepetition(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        Set<Integer> exist = new HashSet<>();
        for (int num : nums) {
            if (!exist.add(num)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断数组中重复元素的索引的差绝对值最大是否为k
     *
     * @param nums 数组
     * @param k    k值
     * @return 结果
     */
    private static boolean repetitionInterval(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        Map<Integer, Integer> exist = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (exist.containsKey(nums[i])) {
                if (i - exist.get(nums[i]) <= k) {
                    return true;
                } else {
                    exist.put(nums[i], i);
                }
            } else {
                exist.put(nums[i], i);
            }
        }
        return false;
    }

    /**
     * 判断数组中存在num[i]和num[j]的差的绝对值最大为t，且此时i和j之间的差的绝对值最大为k
     *
     * @param nums 数组
     * @param k    k值
     * @param t    t值
     * @return 结果
     */
    private static boolean repetitionMinInterval(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[j] - nums[i]) <= t) {
                    if (j - i <= k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
