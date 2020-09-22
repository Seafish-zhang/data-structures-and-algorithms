package leetcode5;

public class LeetCode424 {

    public static void main(String[] args) {
        System.out.println(longestRepeatChar("ABABABABABABABAB", 2));
        System.out.println(longestRepeatChar("AABABBA", 1));
    }

    /**
     * 替换后的最长重复字符
     * <p>原字符串在经过最多替换 k 次后，包含重复字母的最长子串的长度</p>
     *
     * @param s 源字符串
     * @param k 替换次数
     * @return 最长长度值
     */
    private static int longestRepeatChar(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0;
        int maxCount = 0;
        int longest = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);

            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            longest = Math.max(longest, end - start + 1);
        }
        return longest;
    }
}
