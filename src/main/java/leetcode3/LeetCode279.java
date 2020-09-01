package leetcode3;

public class LeetCode279 {

    public static void main(String[] args) {
        System.out.println(minCompose(12));
        System.out.println(minCompose(13));
    }


    /**
     * 完全平方数
     * <p>用最少的完全平方数和得到目标正整数</p>
     * <p>完全平方数： 1、4、9、16....</p>
     *
     * @param n 目标值
     * @return 最少数量
     */
    private static int minCompose(int n) {
        // 最多全由 1 组成，共num个
        int result = n;
        int num = 2;
        while (num * num <= n) {
            int temp1 = n / (num * num);
            int temp2 = n % (num * num);
            result = Math.min(result, temp1 + minCompose(temp2));
            num++;
        }
        return result;
    }
}
