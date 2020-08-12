package leetcode;

import java.util.Arrays;

public class LeetCode86 {


    public static void main(String[] args) {
        System.out.println(max(new char[][]{
                {'1', '0', '1', '0'},
                {'1', '0', '1', '1'}
        }));
    }

    /**
     * 二维数组中只包含1的最大矩形面积
     *
     * @param arr 二维数组
     * @return 最大矩形面积
     */
    private static int maxArea(char[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int maxArea = 0;

        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];

        Arrays.fill(left, 0);
        Arrays.fill(right, n);
        Arrays.fill(left, 0);

        for (int i = 0; i < m; i++) {
            int currentLeft = 0;
            int currentRight = n;

            for (int j = 0; j < n; j++) {
                if (arr[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            for (int j = 0; j < n; j++) {
                if (arr[i][j] == '1') {
                    left[j] = Math.max(left[j], currentLeft);
                } else {
                    left[j] = 0;
                    currentLeft = j + 1;
                }
            }

            for (int j = n - 1; j >= 0; j--) {
                if (arr[i][j] == '1') {
                    right[j] = Math.min(right[j], currentRight);
                } else {
                    right[j] = n;
                    currentRight = j;
                }
            }

            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
            }
        }
        return maxArea;
    }

    private static int max(char[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int maxArea = 1;

        int[][] area = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (arr[i][0] == '1') {
                area[i][0] = 1;
            }
        }
        for (int j = 0; j < n; j++) {
            if (arr[0][j] == '1') {
                area[0][j] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == '1') {
                    area[i][j] = Math.min(area[i - 1][j - 1], Math.max(area[i][j - 1], area[i - 1][j])) + 1;
                }
                maxArea = Math.max(area[i][j], maxArea);
            }
        }
        return maxArea;
    }

    private static int getArea(String[][] arr, int i, int j, int m, int n) {
        // 超界或者当前值为0，返回 0
        if (i < 0 || i == m || j < 0 || j == n || "0".equals(arr[i][j])) {
            return 0;
        }
        int wide = i;
        int hight = j;
        while (wide < m && hight < n) {
            if (arr[wide + 1][hight].equals("1")
                    && arr[wide][hight + 1].equals("1")
                    && arr[wide + 1][hight + 1].equals("1")) {
                wide++;
                hight++;
            } else if (arr[wide + 1][hight].equals("1")) {
                wide++;
            } else if (arr[wide][hight + 1].equals("1")) {
                hight++;
            } else {
                break;
            }
        }
        return (wide - i) * (hight - 1);
    }
}
