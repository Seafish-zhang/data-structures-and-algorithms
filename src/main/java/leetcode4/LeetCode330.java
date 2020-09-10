package leetcode4;

import java.util.ArrayList;
import java.util.List;

public class LeetCode330 {

    public static void main(String[] args) {
        List<Integer> list = minPatches(new int[]{1, 3}, 6);
        list.forEach(System.out::println);
        System.out.println("===============");
        list = minPatches(new int[]{1, 5, 10}, 20);
        list.forEach(System.out::println);
    }

    /**
     * 按要求补齐数组
     * <p>最小补充数组使数组间的和值能等于区间[1,n]之间任意一个值</p>
     *
     * @param nums 有序整数数组
     * @param n    区间范围
     * @return 最小补充数组列表
     */
    private static List<Integer> minPatches(int[] nums, int n) {
        int miss = 1;
        List<Integer> patches = new ArrayList<>();
        int i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                patches.add(miss);
                miss += miss;
            }
        }
        return patches;
    }
}
