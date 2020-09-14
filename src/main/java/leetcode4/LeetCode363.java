package leetcode4;

import java.util.TreeSet;

public class LeetCode363 {


    public static void main(String[] args) {
        System.out.println(maxSumSubMatrix(new int[][]{
                {1, 0, 1},
                {0, -2, 3}
        }, 2));
        System.out.println(maxSumSubMatrix(new int[][]{
                {1, 0, 1},
                {0, -2, 3},
                {0, 2, -1},
                {3, 1, 0},
        }, 7));
    }

    /**
     * 矩形区域不超过K的最大数值和
     *
     * @param matrix 矩阵
     * @param k      k值
     * @return 最大数值和
     */
    private static int maxSumSubMatrix(int[][] matrix, int k) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;

        int m = Math.min(row, col);
        int n = Math.max(row, col);

        boolean colIsBig = col > row;

        int res = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            int[] array = new int[n];

            for (int j = i; j >= 0; j--) {
                int val = 0;

                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);

                for (int p = 0; p < n; p++) {
                    array[p] = array[p] + (colIsBig ? matrix[j][p] : matrix[p][j]);
                    val += array[p];
                    Integer ceiling = set.ceiling(val - k);
                    if (ceiling != null) {
                        res = Math.max(res, val - ceiling);
                    }
                    set.add(val);
                }
            }
        }
        return res;
    }
}
