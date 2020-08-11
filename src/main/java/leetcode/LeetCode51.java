package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode51 {

    private static List<String[][]> numQueen(int n) {
        List<String[][]> result = new ArrayList<>();
        String[][] array = new String[n][n];
        dealQueen(0, n, array, result);
        return result;
    }

    private static void dealQueen(int row, int length, String[][] array, List<String[][]> result) {

        if (row < length) {
            for (int i = 0; i < length; i++) {
                //判断该位置摆放Q是否冲突
                if (conflict(array, row, i, length)) {
                    array[row][i] = null;
                } else {
                    //无冲突，匹配下一位
                    array[row][i] = "Q";
                    dealQueen(row + 1, length, array, result);
                }

                array[row][i] = null;
            }
        } else {
            //复制数组
            String[][] copyArr = copy(array);
            result.add(copyArr);
        }
    }

    private static String[][] copy(String[][] array) {
        int n = array.length;
        String[][] result = new String[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(array[i], 0, result[i], 0, n);
        }
        return result;
    }

    private static boolean conflict(String[][] array, int row, int vertical, int n) {
        for (int i = 0; i < n; i++) {
            if ("Q".equals(array[row][i]) || "Q".equals(array[i][vertical])) {
                return true;
            } else {
                if (row + i < n) {
                    if (vertical + i < n
                            && "Q".equals(array[row + i][vertical + i])) {
                        return true;
                    }

                    if (vertical - i >= n
                            && "Q".equals(array[row + i][vertical - i])) {
                        return true;
                    }
                }

                if (row - i >= 0) {
                    if (vertical + i < n
                            && "Q".equals(array[row - i][vertical + i])) {
                        return true;
                    }

                    if (vertical - i >= 0
                            && "Q".equals(array[row - i][vertical - i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
