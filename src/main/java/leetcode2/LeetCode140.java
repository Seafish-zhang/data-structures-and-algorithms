package leetcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode140 {

    public static void main(String[] args) {
        String sb = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> listList = split(sb, wordDict);
        System.out.println(listList.size() > 0);
        listList.forEach(System.out::println);
        sb = "pineapplepenapple";
        wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        System.out.println(listList.size() > 0);
        listList = split(sb, wordDict);
        listList.forEach(System.out::println);
    }

    /**
     * 单词拆分
     * <p>把字符串拆分成单词，每个单词间用空格隔开</p>
     *
     * @param str      非空字符串
     * @param wordDict 字典
     * @return 所有拆分结果
     */
    private static List<String> split(String str, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        String current = "";
        split(result, current, wordDict, str, 0);
        return result;
    }

    private static void split(List<String> result, String current,
                              List<String> wordDict, String str, int start) {
        if (start == str.length()) {
            result.add(current);
            return;
        }
        for (int j = start + 1; j < str.length() + 1; j++) {
            String substring = str.substring(start, j);
            if (wordDict.contains(substring)) {
                // 如果是回文串，继续匹配后续切割的
                //current.add(substring);
                split(result, current + substring + " ", wordDict, str, j);
                //current.remove(current.size() - 1);
            }
        }
    }
}
