package leetcode4;

public class LeetCode343 {

    public static void main(String[] args) {
        System.out.println(split(2));
        System.out.println(split(10));
        System.out.println(split(14));
    }

    /**
     * 整数拆分
     * <p>给定一个正整数n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化</p>
     *
     * @param n 正整数
     * @return 最大乘积结果
     */
    private static int split(int n) {

        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        } else if (n % 3 == 0) {
            return (int) Math.pow(3, n / 3.0);
        } else if (n % 3 == 1) {
            return 2 * 2 * (int) Math.pow(3, (n - 4) / 3.0);
        } else {
            return 2 * (int) Math.pow(3, n / 3.0);
        }
    }
}
