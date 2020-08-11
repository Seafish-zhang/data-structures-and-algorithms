package leetcode;

import java.util.Arrays;

public class LeetCode75 {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 1, 0, 1, 2, 0, 0, 1};
        sortColor(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortColor(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        for (int i = 0; i <= right; ) {
            if (arr[i] == 0 && i > left) {
                LeetCode41.swap(arr, i, left++);
            } else if (arr[i] == 2 && i < right) {
                LeetCode41.swap(arr, i, right--);
            } else {
                i++;
            }
        }
    }
}
