package leetcode5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode417 {

    public static void main(String[] args) {
        List<int[]> ints = pacificAtlantic(new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        });
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }

    /**
     * 太平洋大西洋水流问题
     * <p>给定非负整数矩阵表示大陆各个单元格高度</p>
     * <p>太平洋位于左边界和上边界，大西洋位于右边界和下边界</p>
     * <p>水流只能按照上下左右流动，且只能从高到低或者在同等高度上流动</p>
     * <p>找出那些既可以流到太平洋也能流到大西洋的单元坐标</p>
     *
     * @param matrix 大陆高度矩阵
     * @return 符合要求的坐标集合
     */
    private static List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, n - 1);
        }

        for (int i = 0; i < n; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }

    private static void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (x < 0 || y < 0 || x >= m || y >= n || matrix[x][y] < height || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        dfs(matrix, visited, matrix[x][y], x + 1, y);
        dfs(matrix, visited, matrix[x][y], x - 1, y);
        dfs(matrix, visited, matrix[x][y], x, y + 1);
        dfs(matrix, visited, matrix[x][y], x, y - 1);
    }
}
