package leetcode5;

import java.util.ArrayList;
import java.util.List;

public class LeetCode474 {

    public static void main(String[] args) {
        System.out.println("result = " + maxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
        System.out.println("result = " + maxForm(new String[]{"10", "0001", "111001", "1", "0"}, 1, 4));
    }

    /**
     * 一和零
     * <p>有m个0和n个1，返回由这些1和0能组成只含有0和1组成的strArr字符串数组中的字符串</p>
     *
     * @param strArr 字符串数组
     * @param m      0的个数
     * @param n      1的个数
     * @return 所有能组成的值
     */
    private static int maxForm(String[] strArr, int m, int n) {
        List<String> result = new ArrayList<>();
        for (String str : strArr) {
            int[] count = count(str);
            if (m >= count[0] && n >= count[1]) {
                result.add(str);
            }
        }
        result.forEach(System.out::println);
        return result.size();
    }

    private static int[] count(String str) {
        int[] count = new int[2];
        for (char c : str.toCharArray()) {
            count[c - '0']++;
        }
        return count;
    }
}
