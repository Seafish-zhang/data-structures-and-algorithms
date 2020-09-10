package leetcode4;

public class LeetCode334 {

    public static void main(String[] args) {
        System.out.println(TripletSeqIncrease(new int[]{1, 2, 3, 4, 5}));
        System.out.println(TripletSeqIncrease(new int[]{5, 4, 3, 2, 1}));
        System.out.println(TripletSeqIncrease(new int[]{1, 5, 3, 2, 1}));
    }

    /**
     * 递增的三元子序列
     * <p>是否存在0 <= i < j < k <=n-1</p>
     * <p>使得 nums[i] < nums[j] < nums[k]</p>
     * <p>要求空间复杂度O（1）,时间复杂度O(n)</p>
     *
     * @param nums 未排序的数组
     * @return 是否存在长度为3的递增子序列
     */
    private static boolean TripletSeqIncrease(int[] nums) {

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
