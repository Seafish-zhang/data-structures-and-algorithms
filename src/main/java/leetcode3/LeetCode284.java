package leetcode3;

import java.util.*;

public class LeetCode284 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 5, 7, 8, 9, 0, 10);
        PeekingIterator<Integer> peekingIterator = new PeekingIterator<>(list.iterator());
        System.out.println(peekingIterator.peek());
        while (peekingIterator.hasNext()) {
            System.out.println(peekingIterator.next());
        }
    }

    /**
     * 顶端迭代器
     *
     * @param <T>
     */
    private static class PeekingIterator<T> implements Iterator {

        private Queue<T> queue;

        PeekingIterator(Iterator<T> iterator) {
            queue = new LinkedList<>();
            while (iterator.hasNext()) {
                queue.add(iterator.next());
            }
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public T next() {
            return queue.poll();
        }

        T peek() {
            return queue.peek();
        }
    }
}
