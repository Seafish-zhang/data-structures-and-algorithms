package leetcode4;

import java.util.ArrayList;
import java.util.List;

public class LeetCode368 {

    private static List<Integer> maxSub = new ArrayList<>();

    public static void main(String[] args) {
        maxExactDivisionSub(new int[]{1, 2, 3});
        maxSub.forEach(System.out::println);
        System.out.println();
        maxSub.clear();
        maxExactDivisionSub(new int[]{1, 2, 4, 8});
        maxSub.forEach(System.out::println);

    }

    /**
     * 最大整除子集
     *
     * @param nums 无重复整数数组
     */
    private static void maxExactDivisionSub(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            List<Integer> single = new ArrayList<>();
            single.add(nums[i]);
            match(single, i, nums);
        }
    }

    private static void match(List<Integer> single, int i, int[] nums) {
        if (single.size() > maxSub.size()) {
            maxSub = new ArrayList<>(single);
        }
        for (int j = i + 1; j < nums.length; j++) {
            if (isAllExactDivision(single, nums[j])) {
                single.add(nums[j]);
                match(single, j, nums);
                break;
            }
        }
    }

    private static boolean isAllExactDivision(List<Integer> single, int num) {
        if (single.isEmpty()) {
            return true;
        } else {
            for (Integer integer : single) {
                int i = integer > num ? integer % num : num % integer;
                if (i != 0) {
                    return false;
                }
            }
            return true;
        }

    }
}
