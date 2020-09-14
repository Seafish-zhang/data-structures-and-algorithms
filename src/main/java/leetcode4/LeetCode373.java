package leetcode4;

import java.util.ArrayList;
import java.util.List;

public class LeetCode373 {

    public static void main(String[] args) {
        List<String> list = minSumPair(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
        list.forEach(System.out::println);
        System.out.println();
        list = minSumPair(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 5);
        list.forEach(System.out::println);
    }

    /**
     * 查找和最小的k对数字
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @param k     指定对数
     * @return 结果集合
     */
    private static List<String> minSumPair(int[] nums1, int[] nums2, int k) {
        List<String> result = new ArrayList<>();

        int i1 = 0;
        int i2 = 0;
        result.add(nums1[i1] + "," + nums2[i2]);
        int count = 1;
        while (i1 < nums1.length - 1 || i2 < nums2.length - 1) {
            if (i1 == nums1.length - 1) {
                i2++;
                result.add(nums1[i1] + "," + nums2[i2]);
                count++;
            } else if (i2 == nums2.length - 1) {
                i1++;
                result.add(nums1[i1] + "," + nums2[i2]);
                count++;
            } else if (nums1[i1 + 1] >= nums2[i2 + 1]) {
                i2++;
                result.add(nums1[i1] + "," + nums2[i2]);
                count++;
            } else if (nums1[i1 + 1] < nums2[i2 + 1]) {
                i1++;
                result.add(nums1[i1] + "," + nums2[i2]);
                count++;
            }
            if (count == k) {
                break;
            }
        }
        return result;
    }

}
