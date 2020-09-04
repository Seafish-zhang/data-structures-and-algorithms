package leetcode4;

import java.util.HashSet;
import java.util.Set;

public class LeetCode312 {

    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        maxCoins(new int[]{3, 1, 5, 8});
        System.out.println(max);
    }

    /**
     * 戳气球
     * <p>有n个气球，分别有一个数字，存于数组nums中</p>
     * <p>要求戳破所有气球，没戳破一个气球，获取气球数字*左边*右边的积的硬币</p>
     * <p>如果气球缺少一边，那么这边可视数字为 1</p>
     *
     * @param nums 气球数组
     */
    private static void maxCoins(int[] nums) {
        Set<Integer> used = new HashSet<>();
        match(used, nums, 0);
    }


    private static void match(Set<Integer> used, int[] nums, int sum) {
        if (used.size() == nums.length) {
            max = Math.max(sum, max);
        } else {
            for (int j = 0; j < nums.length; j++) {
                if (!used.contains(j)) {
                    int left = 1;
                    int right = 1;
                    for (int i = j - 1; i >= 0; i--) {
                        if (!used.contains(i)) {
                            left = nums[i];
                            break;
                        }
                    }
                    for (int i = j + 1; i < nums.length; i++) {
                        if (!used.contains(i)) {
                            right = nums[i];
                            break;
                        }
                    }
                    used.add(j);
                    match(used, nums, sum + left * right * nums[j]);
                    used.remove(j);
                }

            }

        }
    }
}
