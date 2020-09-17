package leetcode4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LeetCode398 {

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3, 3, 3, 4});
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(1));
        System.out.println(solution.pick(4));
    }

    /**
     * 随机数索引，不能太多用额外空间
     */
    private static class Solution {
        int[] nums;
        Random random;

        Solution(int[] nums) {
            this.nums = nums;
            random = new Random();
        }

        int pick(int value) {
            List<Integer> index = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == value) {
                    index.add(i);
                }
            }
            return index.get(random.nextInt(index.size()));
        }
    }
}
