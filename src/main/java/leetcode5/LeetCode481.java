package leetcode5;

public class LeetCode481 {

    public static void main(String[] args) {
        System.out.println(miracleStr(6));
        System.out.println(miracleStr(8));
    }

    /**
     * 神奇字符串
     * <p>字符串S是神奇的，因为串联字符‘1’和‘2’的连续出现次数会生成字符串S（本身）</p>
     * <p>S:1221121221221121122...</p>
     * <p>出现次数:1 2 2 1 1 2 1 2 2 1 2 2 1 1 2 1 1 2 2 ...</p>
     * <p>给定一个整数n作为输入，返回神奇字符串S前n个数字中的‘1’的数目</p>
     *
     * @param n 前n个
     * @return ‘1’的数目
     */
    private static int miracleStr(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 3) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 2;
        int head = 2;
        int tail = 3;
        int num = 1;
        int result = 0;
        while (tail < n) {
            for (int i = 0; i < dp[head]; i++) {
                dp[tail] = num;
                if (num == 1 && tail < n) {
                    result++;
                }
                tail++;
            }
            num = num ^ 3;
            head++;
        }
        return result;
    }
}
