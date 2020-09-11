package leetcode4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode352 {

    public static void main(String[] args) {
        List<String> ranges = ranges(new int[]{1, 3, 7, 2, 6});
        ranges.forEach(System.out::println);
    }

    /**
     * 将数据流变为多个不想交的间隔
     *
     * @param nums 数组
     * @return 间隔列表
     */
    private static List<String> ranges(int[] nums) {
        Arrays.sort(nums);
        int start = nums[0];
        int end = nums[0];
        List<String> result = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                // 连续
                end = nums[i];
            } else {
                // 中断
                result.add(start + "," + end);
                start = end = nums[i];

            }
        }
        result.add(start + "," + end);
        return result;
    }
}
