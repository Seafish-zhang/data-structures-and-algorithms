package leetcode3;

import java.util.ArrayList;
import java.util.List;

public class LeetCode268 {

    public static void main(String[] args) {
        List<Integer> list = missNum(new int[]{3, 0, 1});
        list.forEach(System.out::println);

        System.out.println();

        list = missNum(new int[]{9, 0, 7, 8, 4, 2});
        list.forEach(System.out::println);
    }

    /**
     * 缺失数字
     *
     * @param nums 数组
     * @return 缺失数字列表
     */
    private static List<Integer> missNum(int[] nums) {
        int length = 0;

        for (int num : nums) {
            length = Math.max(length, num);
        }

        int[] exist = new int[length + 1];

        for (int num : nums) {
            exist[num]++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < exist.length; i++) {
            if (exist[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }
}
