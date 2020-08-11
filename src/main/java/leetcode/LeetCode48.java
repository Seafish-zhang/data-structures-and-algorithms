package leetcode;

import java.util.Arrays;

public class LeetCode48 {

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate90(array);
        printlnDoubleArr(array);
    }

    static void printlnDoubleArr(int[][] array) {
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static void rotate90(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                int temp = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = temp;
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length / 2; j++) {
                int temp = array[i][j];
                array[i][j] = array[i][array.length - j - 1];
                array[i][array.length - j - 1] = temp;
            }
        }
    }

}
