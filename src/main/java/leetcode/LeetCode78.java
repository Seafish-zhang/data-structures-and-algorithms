package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode78 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        LeetCode77.printlnDoubleList(subset(arr));
    }

    private static List<List<Integer>> subset(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        match(0, arr, current, result);
        return result;
    }

    private static void match(int start, int[] arr, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < arr.length; i++) {
            int size = current.size();
            current.add(arr[i]);
            match(i + 1, arr, current, result);
            current.remove(size);
        }
    }

}
