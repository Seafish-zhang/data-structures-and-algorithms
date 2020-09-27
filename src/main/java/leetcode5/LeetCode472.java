package leetcode5;

import java.util.ArrayList;
import java.util.List;

public class LeetCode472 {

    public static void main(String[] args) {
        List<String> list = linkWord(new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatdog", "hippopotamuses", "rat", "ratcatdogcat"});
        list.forEach(System.out::println);
    }

    /**
     * 连接词
     *
     * @param strArr 不含重复单词的列表
     * @return 返回给定单词列表中所有的连接词（一个字符串完全是由至少两个给定数组中的单词组成）
     */
    private static List<String> linkWord(String[] strArr) {
        List<String> result = new ArrayList<>();
        List<String> wordList = new ArrayList<>();
        int maxLength = 0;
        for (String s : strArr) {
            maxLength = Math.max(maxLength, s.length());
            wordList.add(s);
        }
        match(result, wordList, "", 0, maxLength);
        return result;
    }

    private static void match(List<String> result, List<String> wordList, String current, int count, int maxLength) {
        if (current.length() > maxLength) {
            return;
        }
        if (wordList.contains(current) && count > 1) {
            result.add(current);
        } else {
            for (int i = 0; i < wordList.size(); i++) {
                if (wordList.get(i).length() + current.length() <= maxLength) {
                    match(result, wordList, current + wordList.get(i), count + 1, maxLength);
                }
            }
        }
    }
}
