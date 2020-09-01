package leetcode3;

import java.util.HashMap;
import java.util.Map;

public class LeetCode290 {

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
    }


    /**
     * 单词模式
     *
     * @param pattern 模式
     * @param str     单词串
     * @return 是否匹配
     */
    private static boolean wordPattern(String pattern, String str) {
        String[] split = str.split(" ");
        char[] chars = pattern.toCharArray();
        if (chars.length != split.length) {
            return false;
        }

        Map<Character, String> match = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            if (match.containsKey(chars[i])) {
                // 已存在模式对应的单词
                if (!match.get(chars[i]).equals(split[i])) {
                    // 本次与上次不匹配，错误
                    return false;
                }
            } else {
                // 还没有存在模式
                if (match.containsValue(split[i])) {
                    // 值对应多个模式，错误
                    return false;
                }
                match.put(chars[i], split[i]);
            }
        }
        return true;
    }
}
