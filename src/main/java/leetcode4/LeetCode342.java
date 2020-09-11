package leetcode4;

public class LeetCode342 {

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(20));
    }

    /**
     * 判断给定的整数是否4的幂
     *
     * @param n 整数
     * @return 结果
     */
    private static boolean isPowerOfFour(int n) {
        return Integer.toString(n, 4).matches("^10*$");
    }
}
