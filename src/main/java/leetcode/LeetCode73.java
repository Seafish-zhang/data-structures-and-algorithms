package leetcode;

import java.util.Arrays;

public class LeetCode73 {


    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        replaceZero(arr);
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static void replaceZero(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        boolean x = false;
        boolean y = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    //原地处理，需要转移0到开头，后面就可以根据开头（第一列和第一行）来判断是否替换为0
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                    // 用于判断第一行和列是否要置换为0
                    if (i == 0) {
                        x = true;
                    }
                    if (j == 0) {
                        y = true;
                    }
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][0] == 0 || arr[0][j] == 0) {
                    //有一个开头为0则置换成0
                    arr[i][j] = 0;
                }
            }
        }
        // 处理第一列和行
        if (y) {
            for (int i = 0; i < m; i++) {
                arr[i][0] = 0;
            }
        }
        if (x) {
            for (int j = 0; j < n; j++) {
                arr[0][j] = 0;
            }
        }
    }
}
