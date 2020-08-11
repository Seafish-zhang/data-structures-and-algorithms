package leetcode;

public class LeetCode64 {
    public static void main(String[] args) {

        System.out.println(pathCount(4, 4, new int[][]{
                {1, 2, 3, 4},
                {2, 3, 4, 3},
                {3, 4, 3, 2},
                {4, 3, 2, 1}
        }));
        System.out.println(pathCount(3, 5, new int[][]{
                {1, 2, 1, 1, 1},
                {2, 1, 4, 1, 1},
                {1, 3, 1, 1, 1}
        }));
    }

    private static int pathCount(int m, int n, int[][] weight) {
        for (int i = 1; i < m; i++) {
            weight[i][0] = weight[i - 1][0] + weight[i][0];
        }
        for (int i = 1; i < n; i++) {
            weight[0][i] = weight[0][i - 1] + weight[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                weight[i][j] = Math.min(weight[i][j - 1], weight[i - 1][j]) + weight[i][j];
            }
        }
        return weight[m - 1][n - 1];
    }
}
