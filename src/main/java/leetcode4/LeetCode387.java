package leetcode4;

public class LeetCode387 {

    public static void main(String[] args) {
        System.out.println(firstIndex("leetcode"));
        System.out.println(firstIndex("loveleetcode"));
    }

    /**
     * 字符串中的第一个唯一字母
     *
     * @param s 字符串
     * @return 第一个唯一字母索引
     */
    private static int firstIndex(String s) {
        int[] exist = new int[26];
        for (int i = 0; i < s.length(); i++) {
            exist[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (exist[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
