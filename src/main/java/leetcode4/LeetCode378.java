package leetcode4;

public class LeetCode378 {

    public static void main(String[] args) {
        System.out.println(kthMatrix(new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        }, 8));
        System.out.println(kthMatrix(new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        }, 6));
    }

    /**
     * 有序矩阵中第K小的元素
     *
     * @param matrix 有序矩阵
     * @param k      第K值
     * @return 结果
     */
    private static int kthMatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = matrix[0][0];
        int hight = matrix[m - 1][n - 1];
        while (low < hight) {
            int mid = low + (hight - low) / 2;
            int count = 0;
            int j = n - 1;
            for (int[] ints : matrix) {
                while (j >= 0 && ints[j] > mid) {
                    j--;
                }
                count += (j + 1);
            }
            if (count < k) {
                low = mid + 1;
            } else {
                hight = mid;
            }
        }
        return low;
    }
}
