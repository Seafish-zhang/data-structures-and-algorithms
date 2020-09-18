package leetcode5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode406 {

    public static void main(String[] args) {
        int[][] rebuild = rebuildQueue(new int[][]{
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        });
        for (int[] ints : rebuild) {
            System.out.print(Arrays.toString(ints));
            System.out.print(",");
        }

    }

    /**
     * 根据身高重建队列
     * <p>应该是恢复队列</p>
     * <p>数组arrays表示一群人排队的情况</p>
     * <p>每个人由一个整数对（h，k）表示，h表示这个人的身高，k表示在这个人前面有k个大于或者等于当前身高的人数</p>
     *
     * @param arrays 一群人排队的情况
     * @return 恢复排队的队列
     */
    private static int[][] rebuildQueue(int[][] arrays) {

        Arrays.sort(arrays, (a, b) -> a[0] != b[0] ? Integer.compare(b[0], a[0]) : Integer.compare(a[1], b[1]));
        List<int[]> list = new LinkedList<>();
        for (int[] array : arrays) {
            list.add(array[1], array);
        }
        return list.toArray(new int[arrays.length][]);
    }
}
