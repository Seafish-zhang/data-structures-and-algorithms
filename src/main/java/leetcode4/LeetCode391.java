package leetcode4;

import java.util.Arrays;

public class LeetCode391 {

    public static void main(String[] args) {
        int[][] rectangles = new int[][]{
                {1, 1, 3, 3},
                {3, 1, 4, 2},
                {3, 2, 4, 4},
                {1, 3, 2, 4},
                {2, 3, 3, 4}
        };
        System.out.println("各块坐标：");
        for (int[] rectangle : rectangles) {
            System.out.println(Arrays.toString(rectangle));
        }
        System.out.println(perfectRectangle(rectangles));
    }

    /**
     * 完美矩阵
     * <p>刚好完全覆盖各块矩阵结合的矩阵</p>
     *
     * @param rectangles 各小块矩阵坐标集合
     * @return 是否完美矩阵
     */
    private static boolean perfectRectangle(int[][] rectangles) {
        int rowMin = Integer.MAX_VALUE;
        int rowMax = Integer.MIN_VALUE;
        int colMin = Integer.MAX_VALUE;
        int colMax = Integer.MIN_VALUE;
        for (int[] rectangle : rectangles) {
            rowMin = Math.min(rectangle[0], rowMin);
            rowMax = Math.max(rectangle[2], rowMax);
            colMin = Math.min(rectangle[1], colMin);
            colMax = Math.max(rectangle[3], colMax);
        }
        boolean[][] cover = new boolean[rowMax - rowMin + 1][colMax - colMin + 1];
        int[] chunkArea = new int[rectangles.length];
        int sumArea = 0;

        for (int i = 0; i < rectangles.length; i++) {
            // 覆盖块内的点
            chunkArea[i] = coverArea(cover, rectangles[i], rowMin, colMin);
            sumArea += chunkArea[i];
        }

        for (int i = 0; i < rowMax - rowMin; i++) {
            for (int j = 0; j < colMax - colMin; j++) {
                if (!cover[i][j]) {
                    return false;
                }
            }
        }
        // 单纯看边覆盖点不行，得加上面积判断
        int area = (rowMax - rowMin) * (colMax - colMin);
        System.out.println("矩形面积：" + area);
        System.out.println("各块面积：" + Arrays.toString(chunkArea));
        System.out.println("各块面积和：" + sumArea);
        return sumArea == area;
    }

    private static int coverArea(boolean[][] cover, int[] rectangle, int rowMin, int colMin) {
        for (int i = rectangle[0]; i <= rectangle[2]; i++) {
            for (int j = rectangle[1]; j <= rectangle[3]; j++) {
                cover[i - rowMin][j - colMin] = true;
            }
        }
        return (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]);
    }
}
