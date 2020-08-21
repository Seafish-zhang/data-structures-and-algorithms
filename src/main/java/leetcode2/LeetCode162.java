package leetcode2;

public class LeetCode162 {

    public static void main(String[] args) {
        System.out.println(getPeekIndex(new int[]{1, 2, 3, 1}));
        System.out.println(getPeekIndex(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }


    /**
     * 寻找峰值.
     * <p>数组可能有多个峰值，返回任何一个峰值索引就行</p>
     * <p>时间复杂度应该为 ： O (log N)</p>
     *
     * @param nums 数组
     * @return 峰值索引
     */
    private static int getPeekIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //O (log N) 二分法
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return (left == nums.length - 1 || nums[left] > nums[left + 1]) ? left : right;
    }
}
