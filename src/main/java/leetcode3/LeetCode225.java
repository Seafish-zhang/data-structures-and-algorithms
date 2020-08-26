package leetcode3;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode225 {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.empty());
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }

    private static class MyStack {
        Queue<Integer> queue = new LinkedList<>();

        private void push(int x) {
            queue.offer(x);
            for (int i = 0; i < queue.size(); i++) {
                queue.offer(queue.remove());
            }
        }

        private int pop() {
            if (queue.isEmpty()) {
                return -1;
            } else {
                return queue.poll();
            }
        }

        private int top() {
            if (queue.isEmpty()) {
                return -1;
            } else {
                return queue.peek();
            }
        }

        private boolean empty() {
            return queue.isEmpty();
        }
    }
}
