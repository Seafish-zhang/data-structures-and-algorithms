package leetcode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode187 {

    public static void main(String[] args) {
        List<String> list = repeatSubList("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        list.forEach(System.out::println);

        System.out.println();

        list = repeatSubList("AAAAATTTTTTAAAAATTTTTTAAAAAGGGTTTAAAA");
        list.forEach(System.out::println);
    }


    /**
     * 重复的DNA序列
     * <p>查询DNA分子中所有出现超过一次的10个字母长度的序列</p>
     *
     * @param s DNA串
     * @return 重复序列
     */
    private static List<String> repeatSubList(String s) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length() - 9; i++) {
            String substring = s.substring(i, i + 10);
            map.put(substring, map.getOrDefault(substring, 0) + 1);
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
