package leetcode;

public class LeetCode62 {

    public static void main(String[] args) {
        System.out.println(pathCount(3, 2));
        System.out.println(pathCount(4, 3));
    }

    private static int pathCount(int m, int n) {
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            array[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            array[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                array[i][j] = array[i][j - 1] + array[i - 1][j];
            }
        }

        return array[m - 1][n - 1];
    }
}
