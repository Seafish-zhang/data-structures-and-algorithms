package leetcode;

public class LeetCode74 {

    private static int x = -1;
    private static int y = -1;

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 3, 4, 5},
                {11, 12, 13, 14, 15},
                {21, 22, 23, 24, 25},
                {31, 32, 33, 34, 35},
                {41, 42, 43, 44, 45}
        };
        LeetCode48.printlnDoubleArr(arr);
        int target = 45;
        boolean result = find(arr, target);
        System.out.println(result);
        if (result) {
            System.out.println(x + " " + y);
        }
    }

    private static boolean find(int[][] arr, int target) {
        int m = arr.length;
        int n = arr[0].length;
        int start = 0;
        int end = m * n;
        //二分查找
        while (start <= end) {
            int mid = (end + start) / 2;
            int midXz = mid / n;
            int midYz = mid % n;
            if (arr[midXz][midYz] == target) {
                x = midXz;
                y = midYz;
                return true;
            } else if (arr[midXz][midYz] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
