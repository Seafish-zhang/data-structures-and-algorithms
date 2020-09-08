package leetcode4;

import java.util.HashSet;
import java.util.Set;

public class LeetCode318 {

    public static void main(String[] args) {
        System.out.println(maxLenghtMultiply(new String[]{"abcw", "baz", "foo", "xtfn", "abcdef"}));
    }


    /**
     * 最长单词长度乘积
     *
     * @param words 单词数组
     * @return 最大乘积
     */
    private static int maxLenghtMultiply(String[] words) {
        int max = 0;

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (hasRepeat(words[i], words[j])) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }

        return max;
    }

    private static boolean hasRepeat(String first, String second) {
        Set<Character> exist = new HashSet<>();

        for (char c : first.toCharArray()) {
            exist.add(c);
        }

        for (char c : second.toCharArray()) {
            if (exist.contains(c)) {
                return false;
            }
        }
        return true;
    }
}
