package leetcode4;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class LeetCode373 {

    private static final int[][] NEIGHBORS = new int[][]{{0, 1}, {1, 0}};

    public static void main(String[] args) {
        List<int[]> list = minSumPair(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 6);
        list.forEach(o -> System.out.println(Arrays.toString(o)));
        System.out.println();
        list = minSumPair(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 5);
        list.forEach(o -> System.out.println(Arrays.toString(o)));
    }

    /**
     * 查找和最小的k对数字
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @param k     指定对数
     * @return 结果集合
     */
    private static List<int[]> minSumPair(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();

        if (nums1 == null || nums1.length == 0
                || nums2 == null || nums2.length == 0) {
            return result;
        }

        Queue<Pair> meanHeap = new PriorityQueue<>();
        meanHeap.offer(new Pair(0, 0, nums1[0] + nums2[0]));
        boolean[][] visit = new boolean[nums1.length][nums2.length];
        visit[0][0] = true;

        while (k > 0 && !meanHeap.isEmpty()) {
            Pair pair = meanHeap.poll();

            result.add(new int[]{nums1[pair.row], nums2[pair.col]});
            k--;

            for (int[] neighbor : NEIGHBORS) {
                int nextRow = pair.row + neighbor[0];
                int nextCol = pair.col + neighbor[1];

                if (nextRow < 0 || nextRow >= nums1.length
                        || nextCol < 0 || nextCol >= nums2.length
                        || visit[nextRow][nextCol]) {
                    continue;
                }
                visit[nextRow][nextCol] = true;
                meanHeap.offer(new Pair(nextRow, nextCol, nums1[nextRow] + nums2[nextCol]));
            }
        }
        return result;
    }


    private static class Pair implements Comparable<Pair> {
        int col;
        int row;
        int sum;

        Pair(int row, int col, int sum) {
            this.row = row;
            this.col = col;
            this.sum = sum;
        }

        @Override
        public int compareTo(@NotNull LeetCode373.Pair o) {
            return this.sum - o.sum;
        }
    }
}
