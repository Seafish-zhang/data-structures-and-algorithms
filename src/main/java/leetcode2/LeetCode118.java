package leetcode2;

import java.util.Arrays;

public class LeetCode118 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(yangHuiTriangle(4)));
        System.out.println(Arrays.toString(yangHuiTriangle(7)));
    }

    /**
     * 返回杨辉三角第K层.
     *
     * @param k 层数
     * @return 第k层数组
     */
    private static int[] yangHuiTriangle(int k) {
        int[] arr = new int[k];
        if (k == 1) {
            arr[0] = 1;
        } else if (k >= 2) {
            arr[0] = 1;
            arr[1] = 1;
        }
        for (int i = 2; i < k; i++) {
            for (int j = 0; j < i; j++) {
                arr[i - j] = arr[i - j] + arr[i - j - 1];
            }
        }
        return arr;
    }
}
