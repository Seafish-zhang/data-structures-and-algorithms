package leetcode4;

public class LeetCode313 {


    public static void main(String[] args) {
        System.out.println(superUglyNum(12, new int[]{2, 7, 13, 19}));
        System.out.println(superUglyNum(13, new int[]{2, 7, 13, 19}));
        System.out.println(superUglyNum(14, new int[]{2, 7, 13, 19}));
        System.out.println(superUglyNum(15, new int[]{2, 7, 13, 19}));
    }

    /**
     * 超级丑数
     * <p>查找第n个超级丑数</p>
     * <p>超级丑数是指所有质因数都在长度为k的质数列表 primes 中的正整数</p>
     *
     * @param n      第N个
     * @param primes 限定质数列表
     * @return 第n个超级丑数
     */
    private static int superUglyNum(int n, int[] primes) {
        int c = 0;

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (isUglyNum(i, primes)) {
                c++;
            }
            if (c == n) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isUglyNum(int num, int[] primes) {
        if (num == 0) {
            return false;
        }

        for (int divisor : primes) {
            while (num % divisor == 0) {
                num /= divisor;
            }
        }
        return num == 1;
    }
}
