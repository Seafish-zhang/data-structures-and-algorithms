package leetcode2;

import leetcode.LeetCode49;

import java.util.ArrayList;
import java.util.List;

public class LeetCode131 {

    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        String sb = "aab";
        List<List<String>> listList = split(sb);
        LeetCode49.printlnDoubleList(listList);
        min = Integer.MAX_VALUE;
        sb = "aabbcddc";
        listList = split(sb);
        LeetCode49.printlnDoubleList(listList);
        System.out.println(min);
    }

    private static List<List<String>> split(String str) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        split(result, current, str, 0);
        return result;
    }

    private static void split(List<List<String>> result, List<String> current, String str, int start) {
        if (start == str.length()) {
            result.add(new ArrayList<>(current));
            min = Math.min(min, current.size());
            return;
        }
        for (int j = start + 1; j < str.length() + 1; j++) {
            String substring = str.substring(start, j);
            if (plalindrome(substring)) {
                // 如果是回文串，继续匹配后续切割的
                current.add(substring);
                split(result, current, str, j);
                current.remove(current.size() - 1);
            }
        }
    }

    /**
     * 判断是否回文串
     *
     * @param str 原字符串
     * @return 结果
     */
    private static boolean plalindrome(String str) {
        if (str.length() <= 1) {
            return true;
        }
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
