package leetcode5;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode440 {

    public static void main(String[] args) {
        System.out.println(kthDictOrder(13, 2));
        System.out.println(kthDictOrder(21, 15));
    }

    /**
     * 字典序的第k小数字
     * <p>给定整数n和k，找到1到n中字典序第k小的数字</p>
     *
     * @param n n
     * @param k k
     * @return 指定数字
     */
    private static Integer kthDictOrder(int n, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparing(String::valueOf));
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while (k-- > 1) {
            queue.poll();
        }
        return queue.poll();
    }
}
