package leetcode3;

public class LeetCode201 {

    public static void main(String[] args) {
        System.out.println(rangeBitWiseAnd(1, 2));
        System.out.println(rangeBitWiseAnd(2, 3));
        System.out.println(rangeBitWiseAnd2(2, 3));
        System.out.println(rangeBitWiseAnd2(1, 2));
    }

    private static int rangeBitWiseAnd(int m, int n) {
        int result = 0;
        if (m == 0) {
            return result;
        }
        result = m;
        for (int i = m + 1; i <= n; i++) {
            // 0和任何数&操作都是0
            if (result == 0) {
                return result;
            }
            result &= i;
        }
        return result;
    }

    private static int rangeBitWiseAnd2(int m, int n) {
        int i = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            i++;
        }
        return (n << i);
    }


}
