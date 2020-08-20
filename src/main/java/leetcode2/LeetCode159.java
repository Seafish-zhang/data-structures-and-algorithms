package leetcode2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode159 {

    private static int max = Integer.MIN_VALUE;
    private static List<Character> maxSub = new ArrayList<>();

    public static void main(String[] args) {
        lengthOfIncludeChar("eceba");
        maxSub.forEach(System.out::print);
        System.out.println();
        System.out.println(max);
        lengthOfIncludeChar("ccaabbb");
        maxSub.forEach(System.out::print);
        System.out.println();
        System.out.println(max);
    }

    /**
     * 至多包含两个不同字符的最长子串.
     *
     * @param str 字符串
     */
    private static void lengthOfIncludeChar(String str) {
        Set<Character> set = new HashSet<>();
        List<Character> current = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            match(str, i, current, set);
        }
    }

    private static void match(String str, int start, List<Character> current, Set<Character> set) {
        if (set.size() > 2) {
            // 字符超出两位，则最新添加的是超出值，需要减掉，返回
            if (current.size() - 1 > max) {
                max = current.size() - 1;
                maxSub = new ArrayList<>(current);
            }
        } else if (start >= str.length()) {
            // 字符串结束，直接返回
            if (current.size() > max) {
                max = current.size();
                maxSub = new ArrayList<>(current);
            }
        } else {
            set.add(str.charAt(start));
            current.add(str.charAt(start));
            match(str, start + 1, current, set);
            set.remove(str.charAt(start));
            current.remove(current.size() - 1);
        }
    }
}
