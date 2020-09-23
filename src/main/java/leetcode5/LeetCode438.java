package leetcode5;

import java.util.ArrayList;
import java.util.List;

public class LeetCode438 {

    public static void main(String[] args) {
        List<Integer> list = findStartIndex("cbaebabacd", "abc");
        list.forEach(System.out::println);
        System.out.println("=================================");
        list = findStartIndex("abab", "ab");
        list.forEach(System.out::println);
        System.out.println("=================================");
    }

    /**
     * 找到字符串中所有字母异位词
     * <p>异位词指字母相同，排序不同的字符串</p>
     *
     * @param s 字符串
     * @param p 异位词子串
     * @return 异位词子串索引列表
     */
    private static List<Integer> findStartIndex(String s, String p) {
        List<Integer> startIndexResult = new ArrayList<>();
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            String substring = s.substring(i, i + p.length());
            if (isMatch(substring, p)) {
                startIndexResult.add(i);
            }
        }
        return startIndexResult;
    }

    private static boolean isMatch(String substring, String p) {
        int[] exist = new int[26];
        char[] pchars = p.toCharArray();
        for (char pchar : pchars) {
            exist[pchar - 'a']++;
        }
        char[] schars = substring.toCharArray();
        for (char schar : schars) {
            if (--exist[schar - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
