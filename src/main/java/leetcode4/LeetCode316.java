package leetcode4;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode316 {

    public static void main(String[] args) {
        System.out.println(removeDuplicat("bcabc"));
        System.out.println(removeDuplicat("cbacdcbc"));
    }

    /**
     * 去除重复字母，保留字典顺序
     *
     * @param str 字符串
     * @return 去除重复字母的字符串
     */
    private static String removeDuplicat(String str) {
        int[] exist = new int[26];

        for (int i = 0; i < str.length(); i++) {
            exist[str.charAt(i) - 'a']++;
        }

        boolean[] visit = new boolean[26];
        Deque<Character> st = new ArrayDeque<>();
        int index;

        for (char c : str.toCharArray()) {
            index = c - 'a';
            exist[index]--;
            if (visit[index]) {
                continue;
            }
            while (!st.isEmpty() && c < st.peek() && exist[st.peek() - 'a'] != 0) {
                visit[st.pop() - 'a'] = false;
            }
            st.push(c);
            visit[index] = true;
        }

        StringBuilder result = new StringBuilder();

        while (!st.isEmpty()) {
            result.insert(0, st.pop());
        }
        return result.toString();
    }
}
