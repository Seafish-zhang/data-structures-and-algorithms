package leetcode3;

import java.util.HashMap;
import java.util.Map;

public class LeetCode202 {

    public static void main(String[] args) {
        System.out.println(happyNum(19));
        System.out.println(happyNum(2));
    }


    /**
     * 判断一个数是否是快乐数.
     * <p>快乐数定义：对于一个正整数，每次将该数替换为它的每个位置的数字的平方和，直到这个数字变为1</p>
     * <p>如果无限循环但容易不为1，则不是快乐数</p>
     *
     * @param num 一个正整数
     * @return 是否是快乐数
     */
    private static boolean happyNum(int num) {
        Map<String, Integer> exist = new HashMap<>();
        int sum = num;
        exist.put(String.valueOf(num), 1);
        while (sum != 1) {
            String current = String.valueOf(sum);
            sum = 0;
            for (int i = 0; i < current.length(); i++) {
                int parseInt = Integer.parseInt(current.charAt(i) + "");
                sum += Math.pow(parseInt, 2);
            }
            System.out.println(sum);
            if (exist.containsKey(String.valueOf(sum))) {
                return false;
            } else {
                exist.put(String.valueOf(sum), 1);
            }
        }
        return true;
    }
}
