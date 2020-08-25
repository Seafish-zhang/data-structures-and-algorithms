package leetcode3;

import leetcode.LeetCode77;

import java.util.ArrayList;
import java.util.List;

public class LeetCode216 {

    public static void main(String[] args) {
        List<List<Integer>> lists = allCombination(3, 7);
        LeetCode77.printlnDoubleList(lists);
        lists = allCombination(2, 9);
        LeetCode77.printlnDoubleList(lists);
    }

    /**
     * 组合总和Ⅲ
     * <p>找出所有相加之和为n的k个数的组合，数组中只允许1-9</p>
     * <p>解集不能包括重复组合</p>
     *
     * @param k 组合中数组数量
     * @param n 组合中的数的和
     * @return 所有组合的列表
     */
    private static List<List<Integer>> allCombination(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> single = new ArrayList<>();
        match(result, single, 1, 0, k, n);
        return result;
    }

    private static void match(List<List<Integer>> result, List<Integer> single,
                              int start, int sum, int k, int n) {
        if (sum == n && single.size() == k) {
            result.add(new ArrayList<>(single));
        } else {
            if (sum < n && single.size() < k) {
                for (int i = start; i <= 9 && i <= n - sum; i++) {
                    sum += i;
                    single.add(i);
                    match(result, single, i + 1, sum, k, n);
                    single.remove(single.size() - 1);
                    sum -= i;
                }
            }
        }
    }
}
