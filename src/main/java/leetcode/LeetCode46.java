package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode46 {

    //用来去除重复的
    private static Map<String, Integer> exist = new HashMap<>();

    public static void main(String[] args) {
        List<List<String>> listList = allPermutation(new int[]{1, 2, 3});
        for (List<String> list : listList) {
            StringBuilder sb = new StringBuilder();
            for (String s : list) {
                sb.append(s).append(" ");
            }
            System.out.println(sb.toString());
        }
    }

    static List<List<String>> allPermutation(int[] array) {
        List<String> current = new ArrayList<>();
        List<Integer> usedIndexList = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        permutation(result, current, array, usedIndexList);
        return result;
    }

    private static void permutation(List<List<String>> result, List<String> current, int[] array, List<Integer> usedIndexList) {

        for (int i = 0; i < array.length; i++) {
            if (usedIndexList.contains(i)) {
                continue;
            }
            current.add(array[i] + "");
            usedIndexList.add(i);
            permutation(result, current, array, usedIndexList);
            usedIndexList.remove(usedIndexList.size() - 1);
            current.remove(array[i] + "");
        }

        if (current.size() == array.length) {
            StringBuilder key = new StringBuilder();
            for (String s : current) {
                key.append(s);
            }

            if (!exist.containsKey(key.toString())) {
                exist.put(key.toString(), 1);
                result.add(new ArrayList<>(current));
            }
        }
    }
}
