package algorithms.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Description:三种O(n2)时间复杂度排序.
 *
 * @author zhy
 * @date 2020/5/27
 */
public class Sort1 {

  public static void main(String[] args) {
    int[] array = getRandomArray(10);
    System.out.println(Arrays.toString(array));
    System.out.println(verify(array));
    //冒泡排序
    bubbleSort(array);
    System.out.println(Arrays.toString(array));
    System.out.println(verify(array));
    //插入排序
    array = getRandomArray(10);
    System.out.println(Arrays.toString(array));
    System.out.println(verify(array));
    insertSort(array);
    System.out.println(Arrays.toString(array));
    System.out.println(verify(array));
    //选择排序
    array = getRandomArray(10);
    System.out.println(Arrays.toString(array));
    System.out.println(verify(array));
    selectSort(array);
    System.out.println(Arrays.toString(array));
    System.out.println(verify(array));
    //归并排序
    array = getRandomArray(10);
    System.out.println(Arrays.toString(array));
    System.out.println(verify(array));
    mergeSort(array);
    System.out.println(Arrays.toString(array));
    System.out.println(verify(array));
    //快速排序
    array = getRandomArray(10);
    System.out.println(Arrays.toString(array));
    System.out.println(verify(array));
    quickSort(array);
    System.out.println(Arrays.toString(array));
    System.out.println(verify(array));

  }


  private static int[] getRandomArray(int length) {
    int[] array = new int[length];
    Random random = new Random();
    for (int i = 0; i < array.length; i++) {
      array[i] = random.nextInt(100);
    }
    return array;
  }

  /**
   * 校验是否有序数组.
   *
   * @param array 需要校验的数组
   * @return 是否有序
   */
  private static boolean verify(int[] array) {
    int i = 0;
    for (; i < array.length - 1; i++) {
      if (array[i] > array[i + 1]) {
        break;
      }
    }
    return i == array.length - 1;
  }

  /**
   * 选择排序.
   *
   * @param array 原数组
   * @return 排好序数组
   */
  private static void selectSort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      int min = i;
      for (int j = i; j < array.length; j++) {
        if (array[j] < array[min]) {
          min = j;
        }
      }
      int temp = array[i];
      array[i] = array[min];
      array[min] = temp;
    }
  }


  /**
   * 插入排序.
   *
   * @param array 原数组
   * @return 排好序数组
   */
  private static void insertSort(int[] array) {
    if (array.length <= 1) {
      return;
    }
    for (int i = 1; i < array.length; i++) {
      int temp = array[i];
      int j = i - 1;
      for (; j >= 0; j--) {
        if (array[j] > temp) {
          array[j + 1] = array[j];
        } else {
          break;
        }
      }
      array[j + 1] = temp;
    }
  }

  /**
   * 冒泡排序.
   *
   * @param array 原数组
   * @return 排好序数组
   */
  private static void bubbleSort(int[] array) {
    if (array.length <= 1) {
      return;
    }
    for (int i = 0; i < array.length; i++) {
      for (int j = array.length - 1; j > i; j--) {
        if (array[j] < array[j - 1]) {
          int temp = array[j];
          array[j] = array[j - 1];
          array[j - 1] = temp;
        }
      }
    }
  }

  private static void mergeSort(int[] array) {
    mergeSortStep(array, 0, array.length - 1);
  }

  private static void mergeSortStep(int[] array, int start, int end) {
    if (start >= end) {
      return;
    }
    int middle = (start + end) / 2;
    mergeSortStep(array, start, middle);
    mergeSortStep(array, middle + 1, end);
    mergeSort(array, start, middle, end);
  }

  private static void mergeSort(int[] array, int start, int middle, int end) {
    int[] temp = new int[end - start + 1];
    int i = start;
    int j = middle + 1;
    int k = 0;
    while (i <= middle && j <= end) {
      if (array[i] < array[j]) {
        temp[k++] = array[i++];
      } else {
        temp[k++] = array[j++];
      }
    }
    while (i <= middle) {
      temp[k++] = array[i++];
    }
    while (j <= end) {
      temp[k++] = array[j++];
    }
    for (int i1 = 0; i1 < temp.length; i1++) {
      array[start + i1] = temp[i1];
    }
  }

  private static void quickSort(int[] array) {
    quickSortStep(array, 0, array.length - 1);
  }

  private static void quickSortStep(int[] array, int start, int end) {
    if (start >= end) {
      return;
    }
    int middle = partition(array, start, end);
    quickSortStep(array, start, middle - 1);
    quickSortStep(array, middle + 1, end);
  }

  private static int partition(int[] array, int start, int end) {
    int i = start;
    int j = end;
    int partition = array[start];
    while (i != j) {
      // 从右往左找到第一个小于分区值的位置
      while (array[j] >= partition && i < j) {
        j--;
      }
      // 从左往右找到第一个大于分区值的位置
      while (array[i] <= partition && i < j) {
        i++;
      }
      // 交换
      if (i < j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }
    array[start] = array[i];
    array[i] = partition;
    return i;
  }

}
