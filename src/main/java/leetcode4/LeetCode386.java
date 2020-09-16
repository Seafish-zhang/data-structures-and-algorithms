package leetcode4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LeetCode386 {

    public static void main(String[] args) {
        List<Integer> list = dictionaryOrder(15);
        printList(list);
        list = dictionaryOrder(8);
        printList(list);
        list = dictionaryOrderOptimize(25);
        printList(list);
        list = dictionaryOrderOptimize(8);
        printList(list);
    }

    private static void printList(List<?> list) {
        StringBuilder sb = new StringBuilder();
        for (Object o : list) {
            sb.append(o.toString()).append(",");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb.toString());
    }

    /**
     * 字典序排数
     * <p>给定一个整数 n，返回从1到n的字典排序</p>
     *
     * @param n 整数范围
     * @return 排好序的列表
     */
    private static List<Integer> dictionaryOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add(i);
        }
        // 转成字符串排序
        result.sort(Comparator.comparing(String::valueOf));

        return result;
    }

    private static List<Integer> dictionaryOrderOptimize(int n) {
        List<Integer> result = new ArrayList<>();

        int i = 1;

        while (true) {
            result.add(i);
            if (i * 10 <= n) {
                i *= 10;
            } else {
                while (i % 10 == 9 || i == n) {
                    i /= 10;
                }
                if (i == 0) {
                    return result;
                }
                i++;
            }
        }
    }
}
