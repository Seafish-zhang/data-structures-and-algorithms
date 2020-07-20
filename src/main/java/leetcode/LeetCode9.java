package leetcode;

import java.util.Arrays;
import java.util.Random;

public class LeetCode9 {

  public static void main(String[] args) {
    Random random = new Random();
    int length = 10;
    int[] arr = new int[10];
    for (int i = 0; i < length; i++) {
      arr[i] = random.nextInt(20);
    }
    System.out.println(Arrays.toString(arr));
    System.out.println(maxArea(arr));
  }

  /**
   * 盛最多水的容器.
   *
   * @param array 非负整数数组
   * @return 最大体积
   */
  private static int maxArea(int[] array) {
    int maxArea = 0;
    for (int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        maxArea = Math.max(maxArea, Math.min(array[i], array[j]) * (j - i));
      }
    }
    return maxArea;
  }
}
