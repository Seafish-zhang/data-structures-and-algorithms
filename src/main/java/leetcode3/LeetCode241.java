package leetcode3;

import java.util.LinkedList;
import java.util.List;

public class LeetCode241 {

    public static void main(String[] args) {
        List<Integer> list = diffPriorityResult("2-1-1");
        list.forEach(System.out::println);
        System.out.println();
        list = diffPriorityResult("2*3-4*5");
        list.forEach(System.out::println);
    }

    /**
     * 为运算表达式设计优先级
     * <p>为表达式添加括号，改变其运算优先级，算出所有不同的结果</p>
     *
     * @param expression 表达式
     * @return 所有结果
     */
    private static List<Integer> diffPriorityResult(String expression) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+'
                    || expression.charAt(i) == '-'
                    || expression.charAt(i) == '/'
                    || expression.charAt(i) == '*') {
                String part1 = expression.substring(0, i);
                String part2 = expression.substring(i + 1);
                List<Integer> result1 = diffPriorityResult(part1);
                List<Integer> result2 = diffPriorityResult(part2);
                int answer = 0;
                for (Integer a1 : result1) {
                    for (Integer a2 : result2) {
                        switch (expression.charAt(i)) {
                            case '+':
                                answer = a1 + a2;
                                break;
                            case '-':
                                answer = a1 - a2;
                                break;
                            case '*':
                                answer = a1 * a2;
                                break;
                            case '/':
                                answer = a1 / a2;
                                break;
                            default:
                                break;
                        }
                        result.add(answer);
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.parseInt(expression));
        }
        return result;
    }
}
