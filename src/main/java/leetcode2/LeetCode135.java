package leetcode2;

import java.util.Arrays;

public class LeetCode135 {


    public static void main(String[] args) {
        System.out.println(minNeed(new int[]{1, 0, 2}));
        System.out.println(minNeed(new int[]{1, 2, 2}));
        System.out.println(minNeed(new int[]{1, 2}));
        System.out.println(minNeed(new int[]{1}));
        System.out.println(minNeed(new int[]{1, 2, 3, 4}));
    }

    /**
     * 分发糖果.
     * <p>每个小孩至少分配到一个糖果</p>
     * <p>相邻的孩子中，评分高的孩子必须获得更多糖果</p>
     *
     * @param arr 小孩评分数组
     * @return 最少需要的糖果数
     */
    private static int minNeed(int[] arr) {
        int length = arr.length;
        int[] candy = new int[length];
        Arrays.fill(candy, 1);
        for (int i = 0; i < length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                candy[i + 1] = candy[i] + 1;
            }
        }

        for (int i = length - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                candy[i - 1] = Math.max(candy[i - 1], candy[i] + 1);
            }
        }
        int need = 0;
        for (int i : candy) {
            need += i;
        }
        return need;
    }
}
