package leetcode;

public class LeetCode2 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("dhsahuhudnvadjw"));
    }

    /**
     * 最长回文子串.
     *
     * @param ori 给定字符串
     * @return 最长回文子串
     */
    private static String longestPalindrome(String ori) {
        if (ori == null || ori.length() < 1) {
            return "";
        }
        int longest = 0;
        String palindrome = "";
        int length = ori.length();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (isPalindrome(ori, i, j) && j - i > longest) {
                    longest = j - i;
                    palindrome = ori.substring(i, j + 1);
                }
            }
        }
        return palindrome;
    }

    private static boolean isPalindrome(String ori, int start, int end) {
        while (start < end && ori.charAt(start) == ori.charAt(end)) {
            start++;
            end--;
        }
        return start >= end;
    }
}
