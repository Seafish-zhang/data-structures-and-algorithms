package leetcode3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeetCode223 {

    public static void main(String[] args) {
        System.out.println("1 + 1 = " + calculate("1 + 1"));
        System.out.println("2-1+2 = " + calculate("2-1+2"));
        System.out.println("(1+(4+5+2)-3)+(6+8) = " + calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    /**
     * 基本计算器
     * <p>计算表达式结果值</p>
     * <p>表达式包含非负整数，左“（”右“）”括号，和加“+”减“-”号</p>
     *
     * @param expression 表达式
     * @return 结果值
     */
    private static int calculate(String expression) {
        expression = expression.replaceAll(" ", "");
        if (isNumeric(expression)) {
            return Integer.parseInt(expression);
        }
        int result = 0;
        int bracketStart = -1;
        int bracketEnd = -1;
        int operatorStart = -1;
        int numStart = -1;
        int first = -1;
        int second;
        char operator = ' ';
        for (int i = 0; i < expression.length(); i++) {
            // 括号部分
            if (expression.charAt(i) == '(') {
                bracketStart = i;
            } else if (expression.charAt(i) == ')') {
                bracketEnd = i;
                break;
            } else if (bracketStart == -1) {

                if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                    int num = Integer.parseInt(expression.substring(numStart, i));
                    numStart = -1;
                    if (first == -1) {
                        first = num;
                        operator = expression.charAt(i);
                    } else {
                        second = num;
                        int current = calculate(first, second, operator);
                        return calculate(expression.substring(0, operatorStart)
                                + current + expression.substring(i));
                    }
                } else {
                    if (numStart == -1) {
                        numStart = i;
                        if (first == -1) {
                            operatorStart = i;
                        }
                    }
                    if (i == expression.length() - 1) {
                        second = Integer.parseInt(expression.substring(numStart, i + 1));
                        int current = calculate(first, second, operator);
                        return calculate(expression.substring(0, operatorStart)
                                + current);
                    }
                }
            }

        }
        // 先计算括号内的
        if (bracketEnd != -1 || bracketStart != -1) {
            int bracketResult = calculate(expression.substring(bracketStart + 1, bracketEnd));
            return calculate(expression.substring(0, bracketStart) + bracketResult + expression.substring(bracketEnd + 1));
        } else {
            return result;
        }
    }

    private static boolean isNumeric(String expression) {
        Pattern pattern = Pattern.compile("^-?[0-9]+");
        Matcher matcher = pattern.matcher(expression);
        return matcher.matches();
    }


    private static int calculate(int first, int second, char operator) {
        switch (operator) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            case '/':
                return first / second;
            case '%':
                return first % second;
            default:
                throw new IllegalArgumentException();
        }
    }
}
