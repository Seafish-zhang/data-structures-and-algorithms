package leetcode2;

import java.util.Arrays;

public class LeetCode164 {
    public static void main(String[] args) {
        System.out.println(maxInterval(new int[]{1, 6, 9, 3}));
        System.out.println(maxInterval(new int[]{1, 2, 13, 9, 7}));
    }

    /**
     * 最大间距
     * <p>找出给定的无序数组在排序之后，相邻元素的最大间距</p>
     * <p>如果数组元素小于2个，则返回 0</p>
     *
     * @param arr 无序数组
     * @return 最大间距
     */
    private static int maxInterval(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        Arrays.sort(arr);
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i] - arr[i - 1]);
        }
        return max;
    }
}
