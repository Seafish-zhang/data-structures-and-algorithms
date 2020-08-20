package leetcode2;

public class LeetCode154 {


    public static void main(String[] args) {
        System.out.println(minValue(new int[]{1, 2, 2, 3, 4, 5}));
        System.out.println(minValue(new int[]{5, 1, 2, 2, 3, 4}));
        System.out.println(minValue(new int[]{4, 5, 1, 2, 2, 3}));
        System.out.println(minValue(new int[]{3, 4, 5, 1, 2, 2}));
        System.out.println(minValue(new int[]{2, 3, 4, 5, 1, 2}));
        System.out.println(minValue(new int[]{2, 2, 3, 4, 5, 1}));
    }

    /**
     * 寻找旋转排序数组中的最小值
     * <p>旋转排序数组指可能在某个点进行了旋转</p>
     * <p>[0,1,2,3,4,5,6,7] 可能变成 [5,6,7,0,1,2,3,4]</p>
     *
     * @param arr 旋转排序数组
     * @return 最小值
     */
    private static int minValue(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        if (arr[left] < arr[right]) {
            // 没有旋转，正常排序数组
            return arr[left];
        }
        int min = arr[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            min = Math.min(min, arr[mid]);
            if (arr[mid] > arr[left]) {
                min = Math.min(min, arr[left]);
                left = mid + 1;
            } else if (arr[mid] < arr[left]) {
                right = mid - 1;
            } else {
                left++;
            }
        }

        min = Math.min(min, Math.min(arr[left], arr[right]));
        return min;
    }
}
