package leetcode6;

/**
 * @Description 最长回文子序列
 * @Author zhy
 * @Date 2020/11/12 9:22
 **/
public class LeetCode516 {

    public static void main(String[] args) {
        System.out.println(longestPalindromSubSeq("bbbab"));
        System.out.println(longestPalindromSubSeq("cbbd"));
    }

    /**
     *	 最长回文子序列
     *
     * @param s 给定字符串
     * @return 长度
     */
    private static int longestPalindromSubSeq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

}
