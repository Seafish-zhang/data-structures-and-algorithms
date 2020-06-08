package algorithms.bag;

import java.util.Arrays;
import java.util.Random;

public class Bag {

  public static int maxW = Integer.MIN_VALUE; //存储背包中物品总重量的最大值
  private static int count = 0;
  private static boolean[][] mem = new boolean[10][400]; // 备忘录，默认值false

  public static void main(String[] args) {
    Random random = new Random();
    int[] a = new int[10];
    for (int i = 0; i < a.length; i++) {
      a[i] = random.nextInt(40);
    }
    System.out.println(Arrays.toString(a));
    f(0, 0, a, 10, 100);
    System.out.println(maxW);
    System.out.println(count);
  }

  // cw表示当前已经装进去的物品的重量和；i表示考察到哪个物品了；
  // w背包重量；items表示每个物品的重量；n表示物品个数
  // 假设背包可承受重量100，物品个数10，物品重量存储在数组a中，那可以这样调用函数：
  // f(0, 0, a, 10, 100)
  public static void f(int i, int cw, int[] items, int n, int w) {
    ++count;
    if (cw == w || i == n) { // cw==w表示装满了;i==n表示已经考察完所有的物品
      if (cw > maxW) {
        maxW = cw;
      }
      return;
    }
    f(i + 1, cw, items, n, w);
    if (mem[i][cw]) {
      return; // 重复状态
    }
    mem[i][cw] = true; // 记录(i, cw)这个状态
    if (cw + items[i] <= w) {// 已经超过可以背包承受的重量的时候，就不要再装了
      f(i + 1, cw + items[i], items, n, w);
    }
  }
}
