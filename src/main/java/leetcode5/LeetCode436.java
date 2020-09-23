package leetcode5;

import java.util.Arrays;

public class LeetCode436 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findFirstRightInterval(new int[][]{{1, 2}})));
        System.out.println(Arrays.toString(findFirstRightInterval(new int[][]{{3, 4}, {2, 3}, {1, 2}})));
        System.out.println(Arrays.toString(findFirstRightInterval(new int[][]{{1, 4}, {2, 3}, {3, 4}})));
    }

    /**
     * 寻找右区间
     *
     * @param intervals 区间集合
     * @return 每个区间的右方区间的最小索引集合
     */
    private static int[] findFirstRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int first = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < intervals.length; j++) {
                if (i == j) {
                    continue;
                }
                if (intervals[j][0] >= intervals[i][1]) {
                    if (intervals[j][0] < min) {
                        min = intervals[j][0];
                        first = j;
                    }
                }
            }
            result[i] = first;
        }
        return result;
    }
}
