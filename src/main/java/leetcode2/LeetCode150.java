package leetcode2;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LeetCode150 {

    public static void main(String[] args) {
        System.out.println(rpn(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(rpn(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(rpn(new String[]{"10", "6", "9", "3", "+",
                "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    /**
     * 逆波兰表达式（也称 后缀表达式）求值
     *
     * @param arr 逆波兰表达式输入值
     * @return 运算结果
     */
    private static int rpn(String[] arr) {

        List<String> operator = Arrays.asList("+", "-", "*", "/");
        Stack<Integer> stack = new Stack<>();
        for (String s : arr) {
            if (!operator.contains(s)) {
                stack.push(Integer.parseInt(s));
            } else {
                Integer value1 = stack.pop();
                Integer value2 = stack.pop();
                int num = operation(value2, value1, s);
                stack.push(num);
            }
        }
        return stack.pop();
    }

    private static int operation(Integer value1, Integer value2, String s) {
        switch (s) {
            case "-":
                return value1 - value2;
            case "*":
                return value1 * value2;
            case "/":
                return value1 / value2;
            default:
                return value1 + value2;
        }
    }
}
