package leetcode3;

public class LeetCode264 {

    public static void main(String[] args) {
        System.out.println(isUglyNum(6));
        System.out.println(isUglyNum(8));
        System.out.println(isUglyNum(14));
        System.out.println(nthUglyNum(10));
        System.out.println(nthUglyNum(12));
    }

    /**
     * 是否丑数
     * <p>丑数就是只包含质因数 2,3,5的正整数</p>
     *
     * @param num 需要判断的正整数
     * @return 是否丑数
     */
    private static boolean isUglyNum(int num) {
        if (num == 0) {
            return false;
        }

        int[] divisors = new int[]{5, 3, 2};

        for (int divisor : divisors) {
            while (num % divisor == 0) {
                num /= divisor;
            }
        }
        return num == 1;
    }

    /**
     * 第N个丑数
     * <p>丑数就是只包含质因数 2,3,5的正整数</p>
     *
     * @param n 第n个
     * @return 丑数
     */
    private static int nthUglyNum(int n) {
        int count = 0;
        int uglyNum = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (isUglyNum(i)) {
                count++;
                uglyNum = i;
            }
            if (count == n) {
                break;
            }
        }
        return uglyNum;
    }
}
