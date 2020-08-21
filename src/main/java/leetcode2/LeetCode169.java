package leetcode2;

public class LeetCode169 {

    public static void main(String[] args) {
        System.out.println(modeNum(new int[]{2, 2, 3}));
        System.out.println(modeNum(new int[]{2, 2, 3, 3, 4, 4, 5, 5, 5, 5, 5, 5, 5}));
    }

    /**
     * 求众数
     * <p>把在数组中出现超过数组长度一半的数叫做众数</p>
     * <p>假设给定的数组总是存在众数</p>
     *
     * @param arr 给定数组
     * @return 众数
     */
    private static int modeNum(int[] arr) {

        int count = 0;
        int mode = Integer.MAX_VALUE;
        // 用mode来表示众数，count表示出现的次数，遍历数组，如果不是这个数，那么相当于抵消一次，
        // 如果count为0，则用新的数字来代替众数，在众数前提下，非众数比众数少，
        // 最终在抵消非众数后，剩下的一定是众数
        for (int value : arr) {
            if (count == 0) {
                count++;
                mode = value;
            } else if (mode == value) {
                count++;
            } else {
                count--;
            }
        }
        return mode;
    }
}
