package leetcode;

public class LeetCode41 {

    public static void main(String[] args) {
        System.out.println(firstMissInt(new int[]{1, 0, 4, 5, 7, 8}));
    }

    private static int firstMissInt(int[] array) {
        int i = 0;
        while (i < array.length) {
            if (array[i] > 0 && array[i] != i
                    && array[i] < array.length && array[i] != array[array[i]]) {
                swap(array, i, array[i]);
            }
            i++;
        }

        for (int j = 0; j < array.length; j++) {
            if (array[j] != j) {
                return j;
            }
        }
        return array.length;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
