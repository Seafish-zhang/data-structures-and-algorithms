package leetcode4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode310 {


    public static void main(String[] args) {
        List<Integer> list = minHeight(4, new int[][]{
                {1, 0},
                {1, 2},
                {1, 3}
        });
        list.forEach(System.out::println);
        System.out.println();
        list = minHeight(6, new int[][]{
                {0, 3},
                {1, 3},
                {2, 3},
                {4, 3},
                {5, 4}
        });
        list.forEach(System.out::println);

    }

    /**
     * 最小高度数
     *
     * @param n     节点数
     * @param edges 边数组
     * @return 最小高度节点列表
     */
    private static List<Integer> minHeight(int n, int[][] edges) {
        List<Set<Integer>> sides = new ArrayList<>(n);
        Set<Integer> values = new HashSet<>();
        for (int i = 0; i < n; i++) {
            sides.add(new HashSet<>());
            values.add(i);
        }

        for (int[] edge : edges) {
            sides.get(edge[0]).add(edge[1]);
            sides.get(edge[1]).add(edge[0]);
        }

        List<Integer> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Set<Integer> copy = new HashSet<>(values);
            int count = findAll(sides, i, copy, 0);
            if (count < min) {
                min = count;
                result.clear();
                result.add(i);
            } else if (count == min) {
                result.add(i);
            }
        }
        return result;
    }

    private static int findAll(List<Set<Integer>> sides, int i, Set<Integer> values, int height) {
        if (values.isEmpty()) {
            return height;
        } else {
            values.remove(i);
            Set<Integer> notMatch = new HashSet<>(values);
            height += 1;
            values.removeAll(sides.get(i));
            if (values.isEmpty()) {
                return height;
            } else {
                int min = Integer.MAX_VALUE;
                for (Integer integer : sides.get(i)) {
                    if (notMatch.contains(integer)) {
                        int all = findAll(sides, integer, notMatch, height);
                        min = Math.min(all, min);
                    }
                }
                return min;
            }
        }
    }
}
