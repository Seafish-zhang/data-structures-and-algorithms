package leetcode4;

public class LeetCode329 {

    private static final int[] dirs = new int[]{0, 1, 0, -1, 0};

    public static void main(String[] args) {
        System.out.println(longestIncreasingPath(new int[][]{
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        }));
    }

    /**
     * 矩阵中最长递增路径
     *
     * @param matrix 矩阵
     * @return 最长路径数
     */
    private static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int max = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int len = dfs(matrix, i, j, cache);
                max = Math.max(len, max);
            }
        }
        return max;
    }

    private static int dfs(int[][] matrix, int row, int col, int[][] cache) {
        if (cache[row][col] != 0) {
            return cache[row][col];
        }

        int max = 1;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dirs[i];
            int nextCol = col + dirs[i + 1];

            if (nextRow < 0 || nextRow >= matrix.length
                    || nextCol < 0 || nextCol >= matrix[0].length
                    || matrix[nextRow][nextCol] <= matrix[row][col]) {
                continue;
            }

            int len = 1 + dfs(matrix, nextRow, nextCol, cache);
            max = Math.max(max, len);
        }
        cache[row][col] = max;
        return max;
    }
}
