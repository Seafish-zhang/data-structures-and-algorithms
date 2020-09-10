package leetcode4;

import java.util.Arrays;

public class LeetCode338 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bitCount(5)));
        System.out.println(Arrays.toString(bitCount(7)));
    }

    /**
     * bit位计数
     * <p>计算0<= i <= num 中每个数字i的二进制中1的数目</p>
     * <p>并将它们作为数组返回</p>
     *
     * @param num 范围
     * @return 二进制中1数目的数组
     */
    private static int[] bitCount(int num) {
        int[] count = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            count[i] = count[i >> 1] + (i & 1);
        }
        return count;
    }
}
