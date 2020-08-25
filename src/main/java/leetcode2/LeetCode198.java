package leetcode2;

public class LeetCode198 {

    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {

        maxMoney(new int[]{2, 3, 2}, false);
        System.out.println(max);
        max = Integer.MIN_VALUE;
        maxMoney(new int[]{1, 2, 3, 1}, false);
        System.out.println(max);
        max = Integer.MIN_VALUE;
        maxMoney(new int[]{2, 3, 2}, true);
        System.out.println(max);
        max = Integer.MIN_VALUE;
        maxMoney(new int[]{1, 2, 3, 1}, true);
        System.out.println(max);
    }

    /**
     * 打家劫舍
     * <p>相邻的房屋会有相连的防盗系统，即不能偷相连的</p>
     *
     * @param arr 房屋金额
     */
    private static void maxMoney(int[] arr, boolean circle) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            steal(arr, i, sum, i, circle);
        }
    }

    private static void steal(int[] arr, int start, int sum, int base, boolean circle) {
        if (start >= arr.length) {
            max = Math.max(max, sum);
        } else {
            for (int i = start; i < arr.length; i++) {
                if (circle && base == arr.length - 1 - i) {
                    continue;
                }
                steal(arr, i + 2, sum + arr[i], base, circle);
            }
        }
    }
}
