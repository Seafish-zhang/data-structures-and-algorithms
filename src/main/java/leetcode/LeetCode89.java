package leetcode;

import java.util.Arrays;

public class LeetCode89 {

    public static void main(String[] args) {
        int n = 3;
        int[] grayCode = grayCode(n);
        System.out.println(Arrays.toString(grayCode));
    }

    private static int[] grayCode(int n) {
        int[] result = new int[1 << n];
        for (int i = 0; i < (1 << n); i++) {
            result[i] = (i ^ (i >> 1));
        }
        return result;
    }
}
