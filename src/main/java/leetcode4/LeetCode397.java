package leetcode4;

public class LeetCode397 {

    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        replace(8);
        System.out.println(min);
        min = Integer.MAX_VALUE;
        replace(7);
        System.out.println(min);
    }

    /**
     * 整数替换
     * <p>把num根据规则替换直到变为1，算出最小变化次数</p>
     * <p>如果n为偶数，则用n/2替换n</p>
     * <p>如果n为奇数，则可用n+1或在n-1替换n</p>
     *
     * @param num 起始正整数
     */
    private static void replace(int num) {
        match(num, 0);
    }

    private static void match(int num, int count) {
        if (count >= min) {
            return;
        }
        if (num == 1) {
            min = Math.min(min, count);
        } else {
            if (num % 2 == 0) {
                match(num / 2, count + 1);
            } else {
                match(num + 1, count + 1);
                match(num - 1, count + 1);
            }
        }
    }
}
