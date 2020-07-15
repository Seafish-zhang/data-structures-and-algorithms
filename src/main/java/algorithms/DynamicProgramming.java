package algorithms;

public class DynamicProgramming {

  public static int getMaxDiff(int[] a) {
    if (a == null) {
      return Integer.MIN_VALUE;
    }
    int len = a.length;
    if (len <= 1) {
      return Integer.MIN_VALUE;
    }
//    int[] diff = new int[len];
//    int[] max = new int[len];
    int diff = Integer.MIN_VALUE;
    int max = a[0];
    for (int i = 1; i < len; i++) {
      diff = Math.max(diff, max + a[i]);
      max= Math.max(max, a[i]);
    }
    return diff;
  }

  public static void main(String[] args) {
    int[] a = {1,4,17,3,2,9};
    System.out.println(getMaxDiff(a));
  }
}
