package leetcode4;

import java.util.*;

public class LeetCode347 {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 2, 2, 4, 4, 4,
                7, 7, 7, 6, 6, 6, 8, 8, 8, 8}, 3)));
    }


    /**
     * 前K个高频元素
     *
     * @param nums 数组
     * @param k    k值
     * @return 高频数组数组
     */
    private static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }

        int[] top = new int[k];

        for (int i = 0; i < k; i++) {
            assert !queue.isEmpty();
            top[i] = queue.poll().getKey();
        }
        return top;
    }
}
