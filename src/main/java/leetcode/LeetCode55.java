package leetcode;

public class LeetCode55 {

    public static void main(String[] args) {
        System.out.println(arriveEnd(new int[]{2, 3, 1, 1, 5}));
    }

    private static boolean arriveEnd(int[] array) {
        //开始位置0，可到达最远的距离
        int farthest = array[0];
        for (int i = 0; i < array.length; i++) {
            if (i <= farthest) {
                if (array[i] + i > farthest) {
                    farthest = array[i] + i;
                }
            }
        }
        return farthest >= array.length;
    }
}
