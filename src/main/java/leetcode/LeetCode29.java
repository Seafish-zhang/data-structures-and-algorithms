package leetcode;

public class LeetCode29 {

  public static void main(String[] args) {
    System.out.println(division(10, 3));
    System.out.println(division(7, -3));
    System.out.println(division(Integer.MAX_VALUE, -3));
  }

  private static int division(int dividend, int divisor) {
    if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
      return 0;
    }
    if (dividend != Integer.MIN_VALUE && Math.abs(dividend) < Math.abs(divisor)) {
      return 0;
    }
    if (divisor == Integer.MIN_VALUE) {
      return dividend == Integer.MIN_VALUE ? 1 : 0;
    }
    boolean flag = (dividend < 0) ^ (divisor < 0);
    dividend = Math.abs(dividend);
    divisor = Math.abs(divisor);
    int result = 0;
    while (dividend >= divisor) {
      dividend -= divisor;
      result++;
    }
    return result;
  }
}
