package leetcode;

import java.util.*;

public class LeetCode49 {

    public static void main(String[] args) {
        String[] strArray = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> group = group(strArray);
        printlnDoubleList(group);

    }

    static void printlnDoubleList(List<List<String>> listList) {
        System.out.println("{");
        for (List<String> stringList : listList) {
            StringBuilder sb = new StringBuilder();
            sb.append(" [");
            for (String s : stringList) {
                sb.append(s).append(", ");
            }
            String toString = sb.toString();
            if (toString.endsWith(", ")) {
                toString = toString.substring(0, toString.length() - 2);
            }
            System.out.println(toString + "]");
        }
        System.out.println("}");
    }

    private static List<List<String>> group(String[] array) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> value;
        for (String str : array) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (map.containsKey(key)) {
                value = map.get(key);
            } else {
                value = new ArrayList<>();
                map.put(key, value);
            }
            value.add(str);
        }
        return new ArrayList<>(map.values());
    }
}
