package leetcode2;

public class LeetCode120 {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };
        minPath(arr);
        System.out.println(min);
    }

    private static void minPath(int[][] arr) {
        getPath(arr, 0, 0, 0);
    }

    /**
     * 三角形最小路径和.
     *
     * @param arr     三角形数组
     * @param level   当前层级
     * @param current 当前路径和
     * @param index   上层坐标
     */
    private static void getPath(int[][] arr, int level, int current, int index) {
        // 递归终止条件
        if (level == arr.length) {
            min = Math.min(min, current);
        } else {
            int[] ints = arr[level];
            for (int i = 0; i < ints.length; i++) {
                // 只能用相连的
                if (i == index || i == index + 1) {
                    current += ints[i];
                    getPath(arr, level + 1, current, i);
                    current -= ints[i];
                }
            }
        }

    }
}
