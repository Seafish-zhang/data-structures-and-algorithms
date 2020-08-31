package leetcode3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode260 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(onlyOneTime(new int[]{1, 2, 1, 3, 2, 5})));
        System.out.println(Arrays.toString(onlyOneTime2(new int[]{1, 2, 1, 3, 2, 5})));
    }

    private static int[] onlyOneTime(int[] nums) {
        int[] result = new int[2];
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }

        diff &= -diff;

        for (int num : nums) {
            if ((num & diff) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }

    private static int[] onlyOneTime2(int[] nums) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result[count++] = entry.getKey();
            }
            if (count == 2) {
                break;
            }
        }
        return result;

    }
}
