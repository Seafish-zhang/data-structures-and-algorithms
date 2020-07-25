package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode36 {

  public static void main(String[] args) {
    String[][] arr = new String[][]{
        {"5", "3", ".", ".", "7", ".", ".", ".", "."},
        {"6", ".", ".", "1", "9", "5", ".", ".", "."},
        {".", "9", "8", ".", ".", ".", ".", "6", "."},
        {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
        {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
        {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
        {".", "6", ".", ".", ".", ".", "2", "8", "."},
        {".", ".", ".", "4", "1", "9", ".", ".", "5"},
        {".", ".", ".", ".", "8", ".", ".", "7", "9"}
    };

    System.out.println(validSudoku(arr));
    arr = new String[][]{
        {"8", "3", ".", ".", "7", ".", ".", ".", "."},
        {"6", ".", ".", "1", "9", "5", ".", ".", "."},
        {".", "9", "8", ".", ".", ".", ".", "6", "."},
        {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
        {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
        {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
        {".", "6", ".", ".", ".", ".", "2", "8", "."},
        {".", ".", ".", "4", "1", "9", ".", ".", "5"},
        {".", ".", ".", ".", "8", ".", ".", "7", "9"}
    };
    System.out.println(validSudoku(arr));
    arr = new String[][]{
        {"5", "3", "9", ".", "7", ".", ".", ".", "."},
        {"6", ".", ".", "1", "9", "5", ".", ".", "."},
        {".", "9", "8", ".", ".", ".", ".", "6", "."},
        {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
        {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
        {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
        {".", "6", ".", ".", ".", ".", "2", "8", "."},
        {".", ".", ".", "4", "1", "9", ".", ".", "5"},
        {".", ".", ".", ".", "8", ".", ".", "7", "9"}
    };
    System.out.println(validSudoku(arr));
  }

  private static Map<String, Integer> map = new HashMap<String, Integer>() {{
    put("1", 1);
    put("2", 1);
    put("3", 1);
    put("4", 1);
    put("5", 1);
    put("6", 1);
    put("7", 1);
    put("8", 1);
    put("9", 1);
  }};

  private static boolean validSudoku(String[][] sudoku) {
    int length = 9;

    // 竖
    for (int i = 0; i < length; i++) {
      boolean b = valid(sudoku[i]);
      if (!b) {
        return false;
      }
    }
    // 横
    for (int i = 0; i < length; i++) {
      HashMap<String, Integer> cloneMap = new HashMap<>(map);
      for (int j = 0; j < length; j++) {
        String s = sudoku[j][i];
        if (cloneMap.containsKey(s)) {
          Integer integer = cloneMap.get(s);
          if (integer == 1) {
            cloneMap.put(s, 0);
          } else {
            return false;
          }
        }
      }
    }
    // 3 x 3
    for (int i = 0; i < length / 3; i++) {
      for (int j = 0; j < length / 3; j++) {
        String[] valid = new String[]{
            sudoku[i * 3][j * 3], sudoku[i * 3][j * 3 + 1], sudoku[i * 3][j * 3 + 2],
            sudoku[i * 3 + 1][j * 3], sudoku[i * 3 + 1][j * 3 + 1], sudoku[i * 3 + 1][j * 3 + 2],
            sudoku[i * 3 + 2][j * 3], sudoku[i * 3 + 2][j * 3 + 1], sudoku[i * 3 + 2][j * 3 + 2],
        };
        boolean b = valid(valid);
        if (!b) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean valid(String[] ints) {
    HashMap<String, Integer> cloneMap = new HashMap<>(map);
    for (String anInt : ints) {
      if (cloneMap.containsKey(anInt)) {
        Integer integer = cloneMap.get(anInt);
        if (integer == 1) {
          cloneMap.put(anInt, 0);
        } else {
          return false;
        }
      }
    }
    return true;
  }
}
