package leetcode4;

import java.util.Arrays;

public class LeetCode396 {

    public static void main(String[] args) {
        System.out.println(maxRotate(new int[]{4, 3, 2, 6}));
    }

    /**
     * 旋转函数
     * <p>函数：f = 0*a[0] + 1*a[1] + ....+ n-1*a[n-1]</p>
     *
     * @param a 整数数组
     * @return 最大函数值
     */
    private static int maxRotate(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int[] f = new int[a.length];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            f[i] = sum(a);
            max = Math.max(f[i], max);
            rotate(a);
        }
        System.out.println(Arrays.toString(f));
        return max;
    }

    private static void rotate(int[] b) {
        int first = b[0];
        System.arraycopy(b, 1, b, 0, b.length - 1);
        b[b.length - 1] = first;
    }

    private static int sum(int[] b) {
        int sum = 0;
        for (int i = 0; i < b.length; i++) {
            sum += i * b[i];
        }
        return sum;
    }
}
