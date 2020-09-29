package leetcode5;

public class LeetCode483 {

    public static void main(String[] args) {
        System.out.println(smallestGoodBase("13"));
        System.out.println(smallestGoodBase("4681"));
        System.out.println(smallestGoodBase("1000000000000000000"));
    }


    /**
     * 最小好进制
     * <p>给定的整数n，如果n的k（k>=2）进制数的所有数位全为1</p>
     * <p>则称k 是 n 的一个好进制</p>
     * <p>求出k</p>
     * <p>例如： n：'13'那么 k = '3'此时 n 可以用 k进制表示为 111 (3^2+3^1+3^0 = 9 + 3 + 1 = 13）</p>
     *
     * @param n 字符串形式整数n
     * @return 最小好进制
     */
    private static String smallestGoodBase(String n) {
        // 进制全为1，假设 k表示基数，m表示全为1的个数
        // 那么 n = 1 + k + k^2 + k^3 + ....+ k^(m-1)
        // 根据数学公式 n =( k^m - 1)/(k-1)
        // 然后讨论m的上线，因为范围是[3,10^18],由于k最小是2，n最小是3，那么n最大只能为log2（n+1）
        long num = Long.parseLong(n);
        // 求k最小，那么从m最大开始算起
        // 又因为，当 k = n - 1时，一定可以表示为 11,此时m = 2，那么可以直接判断m>=2,必定会有结果
        for (long m = Double.valueOf(Math.log(num + 1) / Math.log(2)).intValue(); m >= 2; m--) {
            long left = 2;
            long right = Double.valueOf(Math.pow(num, 1.0 / (m - 1))).intValue() + 1;
            while (left < right) {
                long mid = left + (right - left) / 2;
                long sum = 0;
                for (int i = 0; i < m; i++) {
                    sum = sum * mid + 1;
                }
                if (sum == num) {
                    return String.valueOf(mid);
                }
                if (sum < num) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return String.valueOf(num - 1);
    }

}
