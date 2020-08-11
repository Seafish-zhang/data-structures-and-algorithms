package leetcode;

public class LeetCode63 {

    public static void main(String[] args) {
        System.out.println(pathCount(4, 4, new int[][]{
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        }));
        System.out.println(pathCount(3, 5, new int[][]{
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        }));
    }

    private static int pathCount(int m, int n, int[][] array) {
        for (int i = 0; i < m; i++) {
            if (array[i][0] == 0) {
                array[i][0] = 1;
            } else {
                array[i][0] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            if (array[0][i] == 0) {
                array[0][i] = 1;
            } else {
                array[0][i] = 0;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (array[i][j] == 1) {
                    array[i][j] = 0;
                } else {
                    array[i][j] = array[i][j - 1] + array[i - 1][j];
                }
            }
        }
        return array[m - 1][n - 1];
    }
}
