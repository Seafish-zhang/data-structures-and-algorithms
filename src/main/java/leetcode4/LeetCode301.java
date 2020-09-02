package leetcode4;

import java.util.*;

public class LeetCode301 {

    public static void main(String[] args) {
        List<String> list = deleteError("()())()");
        list.forEach(System.out::println);
        System.out.println();
        list = deleteError("(a)())()");
        list.forEach(System.out::println);
        System.out.println();
    }

    /**
     * 删除最小数量无效的括号
     *
     * @param str 字符串
     * @return 所有可能的结果
     */
    private static List<String> deleteError(String str) {
        List<String> result = new ArrayList<>();
        Set<String> exist = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer(str);
        exist.add(str);

        boolean found = false;

        while (!queue.isEmpty()) {
            String curr = queue.poll();

            if (isValid(curr)) {
                found = true;
                result.add(curr);
            }

            if (found) {
                // 符合标准，不用删除，因为问题是要最小删除的
                continue;
            }

            for (int i = 0; i < curr.length(); i++) {
                if (curr.charAt(i) != '(' && curr.charAt(i) != ')') {
                    continue;
                }

                String next = curr.substring(0, i) + curr.substring(i + 1);
                if (!exist.contains(next)) {
                    queue.offer(next);
                    exist.add(next);
                }
            }
        }
        return result;
    }

    private static boolean isValid(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            }
            if (str.charAt(i) == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
}
