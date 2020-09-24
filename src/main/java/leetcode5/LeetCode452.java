package leetcode5;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode452 {

    public static void main(String[] args) {
        System.out.println(minShootCount(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
    }

    /**
     * 最小数量的箭引爆气球
     *
     * @param balloon 气球数组
     * @return 箭数量
     */
    private static int minShootCount(int[][] balloon) {
        if (balloon == null || balloon.length == 0) {
            return 0;
        }
        Arrays.sort(balloon, Comparator.comparingInt(a -> a[1]));

        int currentEnd = balloon[0][1];
        int count = 1;
        for (int[] ball : balloon) {
            if (ball[0] > currentEnd) {
                count++;
                currentEnd = ball[1];
            }
        }
        return count;
    }
}
