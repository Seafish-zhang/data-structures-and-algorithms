package leetcode3;

public class LeetCode233 {

    public static void main(String[] args) {
        System.out.println(oneCount(13));
        System.out.println(oneCount(2));
    }

    /**
     * 数字1的个数
     * <p>计算所有小于等于n的非负整数中数字1出现的个数</p>
     *
     * @param n n
     * @return 1的个数
     */
    private static int oneCount(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += getCount(i);
        }
        return count;
    }

    private static int getCount(int i) {
        int count = 0;
        String s = String.valueOf(i);
        for (int i1 = 0; i1 < s.length(); i1++) {
            if (s.charAt(i1) == '1') {
                count++;
            }
        }
        return count;
    }
}
