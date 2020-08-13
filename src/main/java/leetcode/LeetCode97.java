package leetcode;

public class LeetCode97 {

    public static void main(String[] args) {
        System.out.println(staggerStr("aab", "bca", "abacab"));
        System.out.println(staggerStr("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(staggerStr("aabcc", "dbbca", "aadbbbaccc"));
    }

    private static boolean staggerStr(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        return match(s1, s2, s3, 0, 0, 0);
    }

    private static boolean match(String s1, String s2, String s3, int i1, int i2, int i3) {
        // 递归正确条件
        if (i3 == s3.length()) {
            return true;
        }
        char c = s3.charAt(i3);
        // s1用完，只能匹配s2
        if (i1 == s1.length()) {
            if (s2.charAt(i2) == c) {
                return match(s1, s2, s3, i1, i2 + 1, i3 + 1);
            } else {
                return false;
            }
        }
        // s2用完，只能匹配s1
        if (i2 == s2.length()) {
            if (s1.charAt(i1) == c) {
                return match(s1, s2, s3, i1 + 1, i2, i3 + 1);
            } else {
                return false;
            }
        }
        if (s1.charAt(i1) == c && s2.charAt(i2) == c) {
            // 两个字符串都符合，两条路走
            return match(s1, s2, s3, i1 + 1, i2, i3 + 1)
                    || match(s1, s2, s3, i1, i2 + 1, i3 + 1);
        } else if (s2.charAt(i2) == c) {
            // 当前只能匹配s2
            return match(s1, s2, s3, i1, i2 + 1, i3 + 1);
        } else if (s1.charAt(i1) == c) {
            // 当前只能匹配s1
            return match(s1, s2, s3, i1 + 1, i2, i3 + 1);
        } else {
            // 当前没有匹配
            return false;
        }
    }
}
