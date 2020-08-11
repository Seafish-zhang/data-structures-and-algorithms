package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode76 {

    public static void main(String[] args) {
        String str = "ADOBECODEBANC";
        String tar = "ABC";
        System.out.println(minCover(str, tar));
    }

    private static int min = Integer.MAX_VALUE;
    private static int startIndex = -1;
    private static int endIndex = -1;

    private static String minCover(String str, String tar) {
        char[] tarCharArray = tar.toCharArray();
        List<Character> notMatch = new ArrayList<>();
        for (char c : tarCharArray) {
            notMatch.add(c);
        }

        for (int i = 0; i < str.length(); i++) {
            //从各个位置作为开头匹配
            match(str, 0, i, i, notMatch);
        }
        if (min < Integer.MAX_VALUE) {
            // 匹配成功
            return str.substring(startIndex, endIndex);
        } else {
            return "";
        }
    }

    private static void match(String str, int matchCount, int start, int current, List<Character> notMatch) {

        if (current < str.length() && notMatch.size() > 0) {
            //字符串没循环结束且没匹配完所有目标字符
            for (int i = current; i < str.length(); i++) {
                char c = str.charAt(i);
                if (notMatch.contains(c)) {
                    matchCount++;
                    int indexOf = notMatch.indexOf(c);
                    notMatch.remove(indexOf);
                    //匹配成功，递归匹配剩下的
                    match(str, matchCount, start, i + 1, notMatch);
                    //还原
                    matchCount--;
                    notMatch.add(indexOf, c);
                }
            }
        } else {
            if (notMatch.size() == 0) {
                if ((current - start) < min) {
                    min = current - start;
                    startIndex = start;
                    endIndex = current;
                }
            }
        }
    }
}
