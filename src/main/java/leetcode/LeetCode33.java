package leetcode;

public class LeetCode33 {

  public static void main(String[] args) {
    System.out.println(find(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    System.out.println(find(new int[]{4, 5, 6, 7, 0, 1, 2}, 4));
    System.out.println(find(new int[]{4, 5, 6, 7, 0, 1, 2}, 1));
  }

  private static int find(int[] array, int value) {
    int low = 0;
    int hight = array.length - 1;
    while (low < hight) {
      int mid = (low + hight) / 2;
      if (array[mid] == value) {
        return mid;
      }
      if (array[low] <= array[mid]) {
        // 正常模式
        if (value >= array[low] && value < array[mid]) {
          // 由于比mid小且是按顺序的，将高位置为mid-1
          hight = mid - 1;
        } else {
          low = mid + 1;
        }
      } else {
        // 有旋转
        if (value > array[mid] && value <= array[hight]) {
          low = mid + 1;
        } else {
          hight = mid - 1;
        }
      }
    }
    return array[low] == value ? low : -1;
  }
}
