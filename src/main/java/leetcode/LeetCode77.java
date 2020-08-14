package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode77 {

    public static void main(String[] args) {
        List<List<Integer>> nk = nk(4, 2);
        printlnDoubleList(nk);
        System.out.println();
        nk = nk(5, 3);
        printlnDoubleList(nk);
    }

    public static void printlnDoubleList(List<List<Integer>> listList) {
        System.out.println("{");
        for (List<Integer> list : listList) {
            StringBuilder sb = new StringBuilder();
            sb.append("    [");
            for (Integer integer : list) {
                sb.append(integer).append(", ");
            }
            String s = sb.toString();
            if (s.endsWith(", ")) {
                s = s.substring(0, s.length() - 2);
            }
            System.out.println(s + "]");
        }
        System.out.println("}");
    }

    /**
     * 组合.
     * <p>返回1...n中所有可能的k个数的组合</p>
     *
     * @param n 数字范围整数
     * @param k 组合中个数
     * @return 组合的列表
     */
    private static List<List<Integer>> nk(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        match(1, n, k, current, result);
        return result;
    }

    private static void match(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        if (current.size() < k) {
            for (int i = start; i <= n; i++) {
                int size = current.size();
                current.add(i);
                match(i + 1, n, k, current, result);
                current.remove(size);
            }
        } else {
            result.add(new ArrayList<>(current));
        }
    }
}
