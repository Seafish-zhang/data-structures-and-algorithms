package leetcode;

import java.util.Stack;

public class LeetCode71 {

    public static void main(String[] args) {
        System.out.println(simplePath("/home/app/../dev"));
        System.out.println(simplePath("/a/./b/../../c/"));
    }

    private static String simplePath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String str : split) {
            if (str.equals("..") && stack.size() > 0) {
                stack.pop();
            } else {
                if (!".".equals(str) && !"".equals(str)) {
                    stack.push(str);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (String singlePath : stack) {
            result.append("/").append(singlePath);
        }
        return "".equals(result.toString()) ? "/" : result.toString();
    }
}
