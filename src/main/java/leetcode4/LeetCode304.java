package leetcode4;

public class LeetCode304 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
        System.out.println(numMatrix.sumRegion(2, 2, 4, 4));
    }

    /**
     * 二维区域和检索
     */
    private static class NumMatrix {

        int[][] tot;

        NumMatrix(int[][] matrix) {

            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return;
            }

            tot = new int[matrix.length + 1][matrix[0].length + 1];

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    tot[i + 1][j + 1] = matrix[i][j] + tot[i + 1][j] + tot[i][j + 1] - tot[i][j];
                }
            }

        }

        int sumRegion(int row1, int col1, int row2, int col2) {
            return tot[row2 + 1][col2 + 1] - tot[row2 + 1][col1] - tot[row1][col2 + 1] + tot[row1][col1];
        }
    }
}
