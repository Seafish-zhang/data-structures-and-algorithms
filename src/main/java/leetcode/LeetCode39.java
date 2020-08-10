package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode39 {

    public static void main(String[] args) {
        List<List<Integer>> combination = combination(8, new int[]{2, 5, 3});
        print2DList(combination);
    }

    private static void print2DList(List<List<Integer>> combination) {
        for (List<Integer> integers : combination) {
            StringBuilder sb = new StringBuilder();
            for (Integer integer : integers) {
                sb.append(integer).append(" ");
            }
            System.out.println(sb.toString());
        }
    }

    private static List<List<Integer>> combination(int target, int[] candidates) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> single = new ArrayList<>();
        // start参数用于去除重复,既在某个start之前的所有组合已经考虑了
        dealCombination(candidates, target, 0, single, result);
        return result;
    }

    private static void dealCombination(int[] candidates, int target, int start,
                                        List<Integer> single, List<List<Integer>> result) {
        if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                if (target < candidates[i]) {
                    continue;
                }
                single.add(candidates[i]);
                dealCombination(candidates, target - candidates[i], i, single, result);
                single.remove(single.size() - 1);
            }
        } else if (target == 0) {
            result.add(new ArrayList<>(single));
        }
    }
}
