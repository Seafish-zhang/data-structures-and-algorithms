package leetcode4;

public class LeetCode321 {

    private static int max = Integer.MIN_VALUE;
    private static String maxList = "";
    private static int count = 0;

    public static void main(String[] args) {
        maxNum(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5);
        System.out.println(max);
        System.out.println(maxList);
        System.out.println(count);
        maxNum(new int[]{6, 7}, new int[]{6, 0, 4}, 5);
        System.out.println(max);
        System.out.println(maxList);
        System.out.println(count);
        maxNum(new int[]{3, 9}, new int[]{8, 9}, 3);
        System.out.println(max);
        System.out.println(maxList);
        System.out.println(count);
    }

    /**
     * 拼接最大的数
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @param k     位数
     */
    private static void maxNum(int[] nums1, int[] nums2, int k) {
        count = 0;
        max = Integer.MIN_VALUE;
        maxList = "";
        number("", 0, 0, nums1, nums2, k);
    }

    private static void number(String single, int i1, int i2, int[] nums1, int[] nums2, int k) {
        count++;
        if (single.length() == k) {
            int current = Integer.parseInt(single);
            if (current > max) {
                max = current;
                maxList = single;
            }
        } else {
            if (i1 >= nums1.length && i2 >= nums2.length) {
                return;
            }
            if (i1 < nums1.length) {
                number(single + nums1[i1], i1 + 1, i2, nums1, nums2, k);
                number(single, i1 + 1, i2, nums1, nums2, k);
            }
            if (i2 < nums2.length) {
                number(single + nums2[i2], i1, i2 + 1, nums1, nums2, k);
                number(single, i1, i2 + 1, nums1, nums2, k);
            }
            number(single, i1 + 1, i2 + 1, nums1, nums2, k);
        }
    }
}
