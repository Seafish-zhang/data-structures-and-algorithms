package leetcode6;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode503 {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})));
    }

    /**
     * 下一个更大的元素
     *
     * @param nums 给定的循环数组
     * @return 返回每一位下一个更大元素的数组
     */
    private static int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int length = nums.length;
        Stack<Integer> stack = new Stack<>();
        {
            int i = length - 1;
            while (i >= 0) {
                stack.push(i);
                i++;
            }
        }

        int[] result = new int[length];

        for (int i = length - 1; i >= 0; i--) {
            result[i] = -1;
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = nums[stack.peek()];
            }
            stack.push(i);
        }
        return result;
    }
}
