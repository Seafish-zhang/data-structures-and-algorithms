package leetcode;

import java.util.Arrays;

public class LeetCode85 {


    public static void main(String[] args) {
        System.out.println(maxArea(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }, false));
        System.out.println(maxArea(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }, true));

        System.out.println(maxSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));
    }

    /**
     * 二维数组中只包含1的最大矩形面积
     *
     * @param arr  二维数组
     * @param flag 是否正方形
     * @return 最大矩形面积
     */
    private static int maxArea(char[][] arr, boolean flag) {
        int m = arr.length;
        int n = arr[0].length;
        int maxArea = 0;


        // 当前行的构成有效矩形的高
        int[] height = new int[n];
        // 对应当前行“高”构成有效矩形的左边界
        int[] left = new int[n];
        // 对当前行“高”构成有效矩形的右边界
        int[] right = new int[n];
        // 对当前行“高”的最大有效矩形面积
        int[][] area = new int[m][n];
        // 初始化,右边界默认为坐标值+1,用于后续使用（right - left） * height 算出面积
        //Arrays.fill(left, 0);
        Arrays.fill(right, n);
        //Arrays.fill(left, 0);

        // 一行一行计算,算出 当前位置（i,j） 使用高度最大的值时，即height[j]时，最大有效矩形面积
        // 因为如果有不是最高的但是宽更长，则在计算别的位置时会计算到该面积
        for (int i = 0; i < m; i++) {
            int currentLeft = 0;
            int currentRight = n;

            for (int j = 0; j < n; j++) {
                if (arr[i][j] == '1') {
                    // 如果当前位置为'1'，则该位置的高在上行结果中+1，即使当前位置高度值最大
                    height[j]++;
                } else {
                    // 如果当前位置为'0',则此次高无效，重置为0，左边界重置，用于下一轮使用
                    height[j] = 0;
                }
            }

            for (int j = 0; j < n; j++) {
                if (arr[i][j] == '1') {
                    // 获取当前高度值最小有效左边界，即左边界值越大越小
                    left[j] = Math.max(left[j], currentLeft);
                } else {
                    left[j] = 0;
                    // 本轮后续有效左边界需要从下一个算起，因为此次为'0'，不可使用
                    currentLeft = j + 1;
                }
            }

            // 右边界，从后面算起
            for (int j = n - 1; j >= 0; j--) {
                if (arr[i][j] == '1') {
                    // 如果当前位置为'1'，则该位置的高在上行结果中+1， 即获取最小有效右边界需要和上行结果比较
                    right[j] = Math.min(right[j], currentRight);
                } else {
                    // 右边界重置，用于下一轮使用
                    right[j] = n;
                    // 本轮右边界有效位置得从本位置左边算起，由于默认+1，即 j - 1 + 1
                    currentRight = j;
                }
            }

            // 算出本行中，每个位置“高”最大时最大有效矩形面积
            for (int j = 0; j < n; j++) {
                int wight = right[j] - left[j];
                if (flag) {
                    int side = Math.min(wight, height[j]);
                    area[i][j] = side * side;
                } else {
                    area[i][j] = wight * height[j];
                }
                maxArea = Math.max(maxArea, area[i][j]);
            }
        }
        return maxArea;
    }

    private static int maxSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = Integer.MIN_VALUE;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = (matrix[i][j] == '1') ? 1 : 0;
                } else {
                    if (matrix[i][j] == '0') {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j],
                                Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}
