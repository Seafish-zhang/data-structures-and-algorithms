package leetcode2;

public class LeetCode172 {
    public static void main(String[] args) {
        System.out.println(factorialEndZero(125));
        System.out.println(factorialEndZero(25));
    }

    /**
     * n阶乘后的零
     *
     * @param n 给定一个数字
     * @return 返回结尾中零的数量
     */
    private static int factorialEndZero(int n) {
        int zeroCount = 0;
        while (n >= 5) {
            n /= 5;
            zeroCount += n;
        }
        return zeroCount;
    }
}
