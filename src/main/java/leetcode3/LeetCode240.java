package leetcode3;

public class LeetCode240 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println(match(matrix, 5));
        System.out.println(match(matrix, 20));
    }


    /**
     * 搜索二维矩阵
     *
     * @param matrix 矩阵
     * @param target 目标数
     * @return 是否存在
     */
    private static boolean match(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;


        int x = 0;
        int y = n - 1;

        while (x < m && y >= 0) {
            if (target == matrix[x][y]) {
                return true;
            } else if (target > matrix[x][y]) {
                x++;
            } else {
                y--;
            }
        }
        return false;
    }
}
