package leetcode5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode435 {


    public static void main(String[] args) {
        System.out.println(minRemove(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
        System.out.println(minRemove(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
        System.out.println(minRemove(new int[][]{{1, 2}, {2, 3}}));
    }

    /**
     * 无重叠区间
     * <p>给定一个区间集合，找到需要移除的区间的最小数量，使剩余的区间互不重叠</p>
     * <p>可以认为区间的终点总是大于起点</p>
     *
     * @param intervals 区间集合
     * @return 最小移除数
     */
    private static int minRemove(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        int maxLength = intervals.length;
        List<int[]> single = new ArrayList<>();
        match(result, single, intervals, 0);
        System.out.println("========================");
        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }

        return maxLength - result.size();
    }

    private static void match(List<int[]> result, List<int[]> single, int[][] intervals, int start) {
        if (start < intervals.length) {
            for (int i = start; i < intervals.length; i++) {
                if (!intersect(single, intervals[i])) {
                    single.add(intervals[i]);
                    match(result, single, intervals, i + 1);
                    single.remove(intervals[i]);
                }
            }
        } else {
            if (single.size() > result.size()) {
                result.clear();
                result.addAll(single);
            }
        }
    }

    private static boolean intersect(List<int[]> list, int[] interval) {
        if (list == null || list.isEmpty()) {
            return false;
        } else {
            for (int[] ints : list) {
                if ((ints[1] > interval[0] && ints[0] < interval[1])
                        || (ints[1] < interval[0] && ints[0] > interval[1])) {
                    return true;
                }
            }
        }
        return false;
    }
}
