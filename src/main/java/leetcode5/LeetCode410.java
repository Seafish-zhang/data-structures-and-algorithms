package leetcode5;

public class LeetCode410 {


    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{7, 2, 5, 10, 8}, 2));
        System.out.println(splitArray(new int[]{1, 8, 9, 3, 5, 7, 9, 3, 6, 7, 8}, 3));
    }

    /**
     * 分割数组的最大值
     * <p>给定一个非负整数数组和一个整数m</p>
     * <p>需要将这个数组分成m个非空的连续子数组</p>
     * <p>使m个子数组各自和的最大值最小</p>
     *
     * @param nums 数组
     * @param m    分成m个数组
     * @return 子数组各自和的最大值最小
     */
    private static int splitArray(int[] nums, int m) {

        int max = 0;
        long sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        if (m == 1) {
            return (int) sum;
        }

        long l = max;
        long r = sum;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (valid(mid, nums, m)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) l;
    }

    private static boolean valid(long target, int[] nums, int m) {
        int count = 1;
        int total = 0;
        // 如果这个数组中子数组超过目标值的数量大于指定数量（m）个，那么需要提高目标值
        // 否则缩小目标值
        for (int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}
