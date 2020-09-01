package leetcode3;

public class LeetCode287 {

    public static void main(String[] args) {
        System.out.println(repetitionNum(new int[]{1, 3, 4, 2, 5, 6, 7, 8, 6}));
        System.out.println(repetitionNum2(new int[]{1, 3, 4, 2, 5, 6, 7, 8, 6}));
        System.out.println(repetitionNum(new int[]{1, 3, 4, 3, 2}));
    }

    /**
     * 寻找重复数
     * <p>不能更改原数组</p>
     * <p>只能使用额外的O(1)空间</p>
     * <p>时间复杂度小于O（n2）</p>
     * <p>数组中只有一个重复的数字，但它可能不止重复出现一次</p>
     *
     * @param nums 数组
     * @return 返回一个重复数
     */
    private static int repetitionNum(int[] nums) {

        //只能使用额外的O(1)空间,说明不能用map或者set去判断
        int current = nums[0];

        while (nums[current] != current) {
            int temp = nums[current];
            // 错误，不能改变原数组
            nums[current] = current;
            current = temp;
        }
        return current;
    }

    private static int repetitionNum2(int[] nums) {

        int slow = 0;
        int fast = 0;
        int find = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];

        } while (slow != fast);

        while (true) {
            slow = nums[slow];
            find = nums[find];
            if (slow == find) {
                return find;
            }
        }
    }
}
