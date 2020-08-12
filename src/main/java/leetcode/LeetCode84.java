package leetcode;

public class LeetCode84 {

    private static int start = -1;
    private static int end = -1;

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(start + " " + end);
        System.out.println(maxArea(new int[]{5, 1, 5, 1, 6, 1}));
        System.out.println(start + " " + end);
    }

    /**
     * 柱状图中最大矩形面积.
     *
     * @param arr 各个柱子高度数组，每个柱子之间间隔单位为1
     * @return 最大面积
     */
    private static int maxArea(int[] arr) {
        int maxArea = 0;
        int current;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                current = (j - i) * Math.min(arr[i], arr[j]);
                if (current > maxArea) {
                    maxArea = current;
                    start = i;
                    end = j;
                }
            }
        }
        return maxArea;
    }
}
