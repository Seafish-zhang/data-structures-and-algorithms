package leetcode4;

public class LeetCode372 {

    public static void main(String[] args) {
        System.out.println(superPow(1336, new int[]{3}, 1337));
        System.out.println(superPow(2, new int[]{1, 0}, 1337));
        System.out.println(superPow(3, new int[]{2}, 2467));
    }

    /**
     * 超级次方
     *
     * @param a   a值
     * @param b   幂数组
     * @param mod 取模值
     * @return 结果
     */
    private static int superPow(int a, int[] b, int mod) {
        if (a % mod == 0) {
            return 0;
        }

        int p = 0;
        for (int i : b) {
            p = (p * 10 + i) % 1140;
        }

        if (p == 0) {
            p += 1140;
        }

        return power(a, p, mod);
    }

    private static int power(int a, int n, int mod) {
        a %= mod;
        int result = 1;
        while (n != 0) {
            if ((n & 1) != 0) {
                result = result * a % mod;
            }
            a = a * a % mod;
            n >>= 1;
        }
        return result;
    }
}
