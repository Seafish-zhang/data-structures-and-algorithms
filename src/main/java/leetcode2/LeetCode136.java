package leetcode2;

public class LeetCode136 {

    public static void main(String[] args) {
        System.out.println(findOnce(new int[]{1, 1, 2, 3, 4, 3, 4}));
        System.out.println(findOnce(new int[]{1, 5, 2, 3, 4, 3, 4, 5, 2}));
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
        for (int value : arr) {
            // 异或操作，两次相同的异或会抵消
            result ^= value;
        }
        return result;
    }
}
