package leetcode;

import java.util.Arrays;
import java.util.Random;

public class LeetCode1 {


    public static void main(String[] args) {
        int count = 10;
        for (int i = 1; i < count; i++) {
            System.out.println("==============第" + i + "次===========");
            medianTest();
        }
    }

    private static void medianTest() {
        Random random = new Random();
        int[] num1 = getNumArray(random.nextInt(5) + 1);
        System.out.println("随机数组1 : " + Arrays.toString(num1));
        int[] num2 = getNumArray(random.nextInt(5) + 1);
        System.out.println("随机数组2 : " + Arrays.toString(num2));
        System.out.println("中位数1 ：" + medianOfTwoSortIntArray(num1, num2));
    }

    private static int[] getNumArray(int bound) {
        Random random = new Random();
        int[] num = new int[bound];
        int first = random.nextInt(5);
        for (int i = 0; i < bound; i++) {
            num[i] = first;
            first += random.nextInt(5) + 1;
        }
        return num;
    }

    /**
     * 两个排序数组(长度分别为m,n)的中位数.O(log(m+n))
     * <p>例如1 nums1 = [1,3], nums2 = [2],中位数是 2.0</p>
     * <p>例如2 nums1 = [1,3], nums2 = [2, 4],中位数是 2.5</p>
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中位数
     */
    private static double medianOfTwoSortIntArray(int[] nums1, int[] nums2) {
        int cout = 0;
        int m = nums1.length;
        int n = nums2.length;
        // 确保 m < n
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }

        int middle = (m + n) / 2;

        int i = 0;
        int j = 0;
        for (int k = 0; k < middle; k++) {
            cout++;
            if (i < m && nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        if (i < m) {
            // 中位数在小的数组
            if ((m + n) % 2 == 0) {
                double min = nums1[i];
                double max = i + 1 < m ? Math.min(nums1[i + 1], nums2[j - 1]) : nums2[j - 1];
                System.out.println("count is" + cout);
                return (max + min) / 2.0;
            } else {
                System.out.println("count is" + cout);
                return nums1[i];
            }
        } else {
            if ((m + n) % 2 == 0) {
                double min = j == 1 ? nums1[i - 1] : nums2[j - 1];
                double max = nums2[j];
                System.out.println("count is" + cout);
                return (max + min) / 2.0;
            } else {
                System.out.println("count is" + cout);
                return nums2[j];
            }
        }
    }
}
