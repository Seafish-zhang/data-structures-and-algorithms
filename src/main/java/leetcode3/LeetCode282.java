package leetcode3;

import java.util.ArrayList;
import java.util.List;

public class LeetCode282 {

    public static void main(String[] args) {
        List<String> match = match("123", 6);
        match.forEach(System.out::println);
        System.out.println("=====================================================================");
        match = match("105", 5);
        match.forEach(System.out::println);
        System.out.println("=====================================================================");
        match = match("00", 0);
        match.forEach(System.out::println);
        System.out.println("=====================================================================");
        match = match("3456237490", 9191);
        match.forEach(System.out::println);
    }

    /**
     * 给表达式添加运算符
     *
     * @param numStr 纯数字字符串
     * @return 符合目标值得表达式
     */
    private static List<String> match(String numStr, int target) {
        List<String> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        match(result, stringBuilder, numStr, 0, target, 0, 0);
        return result;
    }

    private static void match(List<String> result, StringBuilder stringBuilder,
                              String numStr, int pos, long target, long prev, long multi) {
        if (pos == numStr.length()) {
            if (target == prev) {
                result.add(stringBuilder.toString());
            }
            return;
        }

        for (int i = pos; i < numStr.length(); i++) {
            if (numStr.charAt(pos) == '0' && i != pos) {
                break;
            }
            long current = Long.parseLong(numStr.substring(pos, i + 1));
            int len = stringBuilder.length();
            if (pos == 0) {
                match(result, stringBuilder.append(current), numStr, i + 1, target, current, current);
                stringBuilder.setLength(len);
            } else {
                match(result, stringBuilder.append("+").append(current), numStr, i + 1, target,
                        prev + current, current);
                stringBuilder.setLength(len);
                match(result, stringBuilder.append("-").append(current), numStr, i + 1, target,
                        prev - current, -current);
                stringBuilder.setLength(len);
                match(result, stringBuilder.append("*").append(current), numStr, i + 1, target,
                        prev - multi + multi * current, multi * current);
                stringBuilder.setLength(len);
            }
        }
    }


}
