package leetcode4;

public class LeetCode392 {

    public static void main(String[] args) {
        System.out.println(isSubSeq("ahbgdc", "abc"));
        System.out.println(isSubSeq("ahbgdcd", "axc"));
    }

    /**
     * 判断子序列
     * <p>检验字符串s是否为t的子序列（可以是原字符串删除一些也可以不删除，不改变字符的相对位置）</p>
     *
     * @param t 原字符串
     * @param s 目标序列
     * @return 是否为子序列
     */
    private static boolean isSubSeq(String t, String s) {
        int match = 0;
        for (int i = 0; i < t.length() && match < s.length(); i++) {
            if (t.charAt(i) == s.charAt(match)) {
                match++;
            }
        }
        return match == s.length();
    }
}
