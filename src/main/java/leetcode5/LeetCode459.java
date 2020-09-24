package leetcode5;

public class LeetCode459 {

    public static void main(String[] args) {
        System.out.println(repeatedSubString("abab"));
        System.out.println(repeatedSubString("aba"));
        System.out.println(repeatedSubString("abcabcabcabc"));
    }

    /**
     * 重复的子字符串
     * <p>给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成</p>
     *
     * @param s 给定字符串
     * @return 是否重复
     */
    private static boolean repeatedSubString(String s) {
        for (int i = s.length() / 2; i >= 1; i--) {
            String subStr = s.substring(0, i);
            if (s.length() % i == 0) {
                String repeatedStr = repeatSub(subStr, s.length() / i);
                if (repeatedStr.equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static String repeatSub(String subStr, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(subStr);
        }
        return sb.toString();
    }
}
