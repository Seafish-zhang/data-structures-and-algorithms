package leetcode5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode451 {

    public static void main(String[] args) {
        System.out.println(orderByFrequency("tree"));
        System.out.println(orderByFrequency("ccc aaa"));
    }

    /**
     * 根据字符出现频率排序
     *
     * @param s 字符串
     * @return 排序后字符串
     */
    private static String orderByFrequency(String s) {
        Map<Character, Integer> exist = new HashMap<>();
        for (char c : s.toCharArray()) {
            exist.put(c, exist.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(exist.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            for (Integer i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();

    }
}
