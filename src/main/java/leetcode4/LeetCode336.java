package leetcode4;

import leetcode.LeetCode77;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode336 {

    public static void main(String[] args) {
        List<List<Integer>> lists = palindromeParis(new String[]{"bat", "tab", "cat"});
        LeetCode77.printlnDoubleList(lists);

        lists = palindromeParis(new String[]{"abcd", "dcba", "lls", "s", "sssll"});
        LeetCode77.printlnDoubleList(lists);
    }

    /**
     * 回文对
     *
     * @param words 单词数组
     * @return 组成回文对的索引列表
     */
    private static List<List<Integer>> palindromeParis(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        List<String> palindromeStr = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPalindrome(words[i] + words[j])) {
                    result.add(Arrays.asList(i, j));
                    palindromeStr.add(words[i] + words[j]);
                }
                if (isPalindrome(words[j] + words[i])) {
                    result.add(Arrays.asList(j, i));
                    palindromeStr.add(words[j] + words[i]);
                }
            }
        }

        palindromeStr.forEach(System.out::println);
        return result;
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
