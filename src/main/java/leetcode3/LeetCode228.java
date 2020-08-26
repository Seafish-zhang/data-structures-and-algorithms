package leetcode3;

import java.util.ArrayList;
import java.util.List;

public class LeetCode228 {

    public static void main(String[] args) {
        List<String> list = collectRange(new int[]{1, 2, 4, 5, 7});
        list.forEach(System.out::println);
        list = collectRange(new int[]{0, 2, 3, 4, 6, 8, 9});
        list.forEach(System.out::println);
    }

    /**
     * 汇总区间
     *
     * @param arr 整数数组
     * @return 区间
     */
    private static List<String> collectRange(int[] arr) {
        List<String> result = new ArrayList<>();
        int start = arr[0];
        StringBuilder s = new StringBuilder(String.valueOf(start));
        boolean con = false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == start + 1) {
                start = arr[i];
                con = true;
            } else {
                if (con) {
                    s.append("->").append(start);
                }
                result.add(s.toString());
                start = arr[i];
                s = new StringBuilder(String.valueOf(start));
                con = false;
            }
            if (i == arr.length - 1) {
                if (con) {
                    s.append("->").append(start);
                }
                result.add(s.toString());
                start = arr[i];
                s = new StringBuilder(String.valueOf(start));
                con = false;
            }
        }


        return result;
    }
}
