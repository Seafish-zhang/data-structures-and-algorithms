package structure;

import java.util.Arrays;
import java.util.Random;

public class StackTest {

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    int length = 15;
    Random random = new Random();
    for (int i = 0; i < length; i++) {
      int anInt = random.nextInt(50);
      stack.push(anInt);
    }
    while (!stack.isEmpty()) {
      System.out.print(stack.pop() + "-");
    }

  }

  public static class Stack<T> {

    private Object[] stackArr;
    private int size;

    public Stack() {
      this.stackArr = new Object[10];
    }

    public boolean isEmpty() {
      return size == 0;
    }

    private T peek() {
      if (isEmpty()) {
        return null;
      } else {
        return (T) stackArr[size - 1];
      }
    }

    public T pop() {
      T peek = peek();
      stackArr[size - 1] = null;
      size--;
      return peek;
    }

    public void push(T t) {
      ensureCapacity(size + 1);
      stackArr[size++] = t;
    }

    private void ensureCapacity(int i) {
      if (i > stackArr.length) {
        stackArr = Arrays.copyOf(stackArr, stackArr.length + 10);
      }
    }
  }
}
