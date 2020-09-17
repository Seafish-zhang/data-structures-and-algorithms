package leetcode4;

import java.util.Stack;

public class LeetCode394 {

    public static void main(String[] args) {
        System.out.println(decoded("3[a]2[bc]"));
        System.out.println(decoded("3[a2[c]]"));
    }

    /**
     * 字符串解码
     *
     * @param s 加密串
     * @return 解码
     */
    private static String decoded(String s) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                StringBuilder count = new StringBuilder();
                while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    count.append(s.charAt(i));
                    i++;
                }
                i--;
                stack.push(count.toString());
            } else if (']' == c) {
                StringBuilder str = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    str.insert(0, stack.pop());
                }
                stack.pop();
                int count = Integer.parseInt(stack.pop());
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < count; j++) {
                    temp.append(str.toString());
                }
                stack.push(temp.toString());
            } else {
                String substring = s.substring(i, i + 1);
                stack.push(substring);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();

    }

}
