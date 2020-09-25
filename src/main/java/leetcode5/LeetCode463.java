package leetcode5;

public class LeetCode463 {

    public static void main(String[] args) {
        System.out.println(islandPerimeter(new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        }));
    }

    /**
     * 岛屿的周长
     * <p>计算二维网络中岛屿的周长，其中1表示岛屿</p>
     *
     * @param matrix 二维网络
     * @return 岛屿的周长
     */
    private static int islandPerimeter(int[][] matrix) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    result += 4;
                    if (i > 0 && matrix[i - 1][j] == 1) {
                        result -= 2;
                    }
                    if (j > 0 && matrix[i][j - 1] == 1) {
                        result -= 2;
                    }
                }
            }
        }
        return result;
    }
}
