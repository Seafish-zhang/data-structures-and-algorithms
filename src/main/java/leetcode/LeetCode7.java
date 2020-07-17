package leetcode;

public class LeetCode7 {

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("mississippi", "mis*is*p*."));
        System.out.println(isMatch("abccccabbd", "abc*ab*."));
        System.out.println(isMatch("abccccabbd", "abc*ab*.q"));
    }

    private static boolean isMatch(String str, String pattern) {
        int n = 0, m = 0;
        while (m < str.length()) {
            if (n >= pattern.length()) {
                if (pattern.charAt(n - 1) == '*' && str.charAt(m) == pattern.charAt(n - 1)) {
                    m++;
                } else {
                    return false;
                }
            }
            if (pattern.charAt(n) == '.' || str.charAt(m) == pattern.charAt(n)) {
                m++;
                n++;
            } else {
                if (pattern.charAt(n) == '*') {
                    if (n < 1) throw new IllegalArgumentException("违法");
                    if (str.charAt(m) == pattern.charAt(n - 1) || pattern.charAt(n - 1) == '.') {
                        m++;
                    } else {
                        n++;
                    }
                } else {
                    if (pattern.charAt(n + 1) == '*') {
                        n += 2;
                    } else if (str.charAt(m) == pattern.charAt(n + 1)) {
                        n++;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
