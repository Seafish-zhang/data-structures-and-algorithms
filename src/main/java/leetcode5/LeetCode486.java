package leetcode5;

public class LeetCode486 {

    public static void main(String[] args) {
        System.out.println(canFirstWin(new int[]{1, 5, 2}));
    }

    /**
     * 预测赢家
     * <p>给定一个表示分数的数组，两名玩家轮流从数组两头任意一端拿去一个数字</p>
     * <p>最后数组为空时，判断两者分数，分数大者获胜</p>
     * <p>在双方的玩法都会使其获取最大数字，预测玩家1是否为赢家</p>
     *
     * @param nums 分数数组
     * @return 玩家1是否为赢家
     */
    private static boolean canFirstWin(int[] nums) {
        return helper(nums, 0, nums.length - 1, new Integer[nums.length][nums.length]) >= 0;
    }

    private static int helper(int[] nums, int start, int end, Integer[][] mem) {
        if (mem[start][end] == null) {
            mem[start][end] = start == end ?
                    nums[end] : Math.max(nums[end] - helper(nums, start, end - 1, mem),
                    nums[start] - helper(nums, start + 1, end, mem));
        }
        return mem[start][end];
    }
}
