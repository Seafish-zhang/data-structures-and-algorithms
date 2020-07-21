package leetcode;

import java.util.Arrays;
import java.util.Random;

public class LeetCode10 {

  public static void main(String[] args) {
    Random random = new Random();
    int length = 10;
    int[] a = new int[length];
    for (int i = 0; i < length; i++) {
      a[i] = random.nextInt(length *  2) - length;
    }
    System.out.println(Arrays.toString(a));
    System.out.println(maxSubSum(a));
  }


  private static int maxSubSum(int[] a) {
    int maxSum = 0;
    int thisSum = 0;

    for (int value : a) {
      thisSum += value;
      if (thisSum > maxSum) {
        maxSum = thisSum;
      } else if (thisSum < 0) {
        thisSum = 0;
      }
    }
    return maxSum;
  }
}
