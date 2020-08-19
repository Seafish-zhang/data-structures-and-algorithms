package leetcode2;

import java.util.HashMap;
import java.util.Map;

public class LeetCode136 {

    public static void main(String[] args) {
        System.out.println(findOnce(new int[]{1, 1, 2, 3, 4, 3, 4}));
        System.out.println(findOnce(new int[]{1, 5, 2, 3, 4, 3, 4, 5, 2}));
        System.out.println(findOnce2ExtraSpace(new int[]{1, 1, 2, 3, 4, 3, 4, 1, 2, 3}));
        System.out.println(findOnce2(new int[]{1, 1, 2, 3, 4, 3, 4, 1, 2, 3, 2, 5}));
    }

    /**
     * 只出现一次的数字.
     * <p>只有一个数字只出现一次，其他的都是两次</p>
     *
     * @param arr 非空整数数组
     * @return 返回只出现一次的数字
     */
    private static int findOnce(int[] arr) {
        int result = 0;
        for (int number : arr) {
            // 异或操作，两次相同的异或会抵消
            result ^= number;
        }
        return result;
    }

    /**
     * 只出现一次的数字.
     * <p>只有一个数字只出现一次，其他的都是三次</p>
     *
     * @param arr 非空整数数组
     * @return 返回只出现一次的数字
     */
    private static int findOnce2(int[] arr) {
        int counter1 = 0;
        int counter2 = 0;
        int mask;
        for (int number : arr) {
            counter2 ^= counter1 & number;
            counter1 ^= number;
            mask = ~(counter1 & counter2);
            counter1 &= mask;
            counter2 &= mask;
        }
        return counter1;
    }

    /**
     * 只出现一次的数字.
     * <p>只有一个数字只出现一次，其他的都是三次</p>
     *
     * @param arr 非空整数数组
     * @return 返回只出现一次的数字
     */
    private static int findOnce2ExtraSpace(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : arr) {
            int value = 0;
            if (map.containsKey(number)) {
                value = map.get(number);
            }
            map.put(number, ++value);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 3) {
                return entry.getKey();
            }
        }
        return 0;
    }
}
