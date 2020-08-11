package leetcode;

import java.util.Comparator;
import java.util.List;

public class LeetCode60 {


    public static void main(String[] args) {
        List<String> result = k(3, 3);
        System.out.println(listToString(result));
        result = k(4, 1);
        System.out.println(listToString(result));
    }

    private static List<String> k(int num, int k) {
        int[] arr = new int[num];
        for (int i = 1; i < num; i++) {
            arr[i - 1] = i;
        }
        List<List<String>> lists = LeetCode46.allPermutation(arr);
        lists.sort(Comparator.comparing(LeetCode60::listToString));
        return lists.get(k - 1);
    }

    private static String listToString(List<String> result) {
        StringBuilder sb = new StringBuilder();
        for (String s : result) {
            sb.append(s);
        }
        return sb.toString();
    }
}
