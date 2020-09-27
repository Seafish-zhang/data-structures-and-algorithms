package leetcode5;

import java.util.Arrays;

public class LeetCode475 {

    public static void main(String[] args) {
        System.out.println(findRadius(new int[]{1, 2, 3}, new int[]{2}));
        System.out.println(findRadius(new int[]{1, 2, 3}, new int[]{1}));
        System.out.println(findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
    }

    /**
     * 供暖器
     *
     * @param houses  房屋数组
     * @param heaters 供暖器坐标
     * @return 最小供暖器半径
     */
    private static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int radius = Integer.MIN_VALUE;
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = ~index;
            }
            int distance1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int distance2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
            radius = Math.max(radius, Math.min(distance1, distance2));
        }
        return radius;
    }
}
