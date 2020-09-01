package leetcode3;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCode291 {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }

    /**
     * 数据流的中位数
     */
    private static class MedianFinder {

        private Queue<Long> large;

        private Queue<Long> small;

        MedianFinder() {
            large = new PriorityQueue<>();
            small = new PriorityQueue<>(Collections.reverseOrder());
        }

        void addNum(int num) {
            large.offer((long) num);
            small.offer(large.poll());
            if (large.size() < small.size()) {
                large.offer(small.poll());
            }
        }

        double findMedian() {
            if (large.size() > small.size()) {
                return large.peek();
            }
            assert large.peek() != null;
            assert small.peek() != null;
            return (large.peek() + small.peek()) / 2.0;
        }
    }
}
