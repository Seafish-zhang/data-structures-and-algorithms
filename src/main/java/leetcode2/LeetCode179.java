package leetcode2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode179 {

    public static void main(String[] args) {
        System.out.println(maxNum(new int[]{10, 2}));
        System.out.println(maxNum(new int[]{3, 30, 34, 5, 9}));
    }

    /**
     * 最大的数
     * <p>输入一组非负整数，重新排列他们顺序，使其变成一个最大的数</p>
     *
     * @param nums 非负整数数组
     * @return 最大的数
     */
    private static String maxNum(int[] nums) {
        StringBuilder stringBuilder = new StringBuilder();

        List<String> list = new ArrayList<>();

        for (int num : nums) {
            list.add(String.valueOf(num));
        }

        Collections.sort(list);
        Collections.reverse(list);

        for (String s : list) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
