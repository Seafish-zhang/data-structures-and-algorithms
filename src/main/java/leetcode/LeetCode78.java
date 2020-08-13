package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode78 {

    private static Set<String> exist = new HashSet<>();

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2};
        LeetCode77.printlnDoubleList(subset(arr));
    }

    private static List<List<Integer>> subset(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        match(0, arr, current, result);
        return result;
    }

    private static void match(int start, int[] arr, List<Integer> current, List<List<Integer>> result) {
        String key = listToString(current);
        if (!exist.contains(key)) {
            exist.add(key);
            result.add(new ArrayList<>(current));
        }
        for (int i = start; i < arr.length; i++) {
            int size = current.size();
            current.add(arr[i]);
            match(i + 1, arr, current, result);
            current.remove(size);
        }
    }

    private static String listToString(List<Integer> current) {
        StringBuilder sb = new StringBuilder();
        if (current != null && current.size() > 0)
            for (Integer integer : current) {
                sb.append(integer);
            }
        return sb.toString();
    }

}
