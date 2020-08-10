package leetcode;

import java.util.*;

public class LeetCode37 {

    private static int length = 9;
    private static List<String> fullValueList = new ArrayList<String>() {{
        add("1");
        add("2");
        add("3");
        add("4");
        add("5");
        add("6");
        add("7");
        add("8");
        add("9");
    }};

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
        dealSudoku(arr);
        printTwoArray(arr);
    }

    private static void printTwoArray(String[][] arr) {
        for (String[] strings : arr) {
            System.out.println(Arrays.toString(strings));
        }
    }

    private static void dealSudoku(String[][] sudoku) {
        Map<String, List<String>> indexMaybeValueMap = new HashMap<>();
        // 是否可以继续精准匹配
        boolean optimize = true;
        while (optimize) {
            optimize = false;
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    String current = sudoku[i][j];
                    if (".".equals(current)) {
                        // 空值，需要填充的位置
                        List<String> maybeValue = getMaybeValue(sudoku, i, j);
                        if (maybeValue.size() == 0) {
                            //没有合适的值，熟读无解
                            throw new IllegalArgumentException("错误的数独");
                        } else if (maybeValue.size() == 1) {
                            // 精准匹配
                            sudoku[i][j] = maybeValue.get(0);
                            // 或许还能继续精准匹配
                            optimize = true;
                        } else {
                            indexMaybeValueMap.put(i + "-" + j, maybeValue);
                        }
                    }
                }
            }
        }

        // 循环开始下表值，用于美学
        List<Index> indexList = new ArrayList<>();
        for (String key : indexMaybeValueMap.keySet()) {
            indexList.add(new Index(key, 0));
        }

        //暴力才是真正的美学 0.0
        boolean complete = LeetCode36.validSudoku(sudoku) && fullValid(sudoku);

        while (!complete) {
            for (Map.Entry<String, List<String>> entry : indexMaybeValueMap.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                String[] split = key.split("-");
                int x = Integer.parseInt(split[0]);
                int y = Integer.parseInt(split[1]);
                sudoku[x][y] = value.get(getIndex(indexList, key));
            }
            //检查是否完整有效
            complete = LeetCode36.validSudoku(sudoku) && fullValid(sudoku);
            if (!complete) {
                // 如果无效，从最后一个数值加起
                changeLastIndex(indexList, indexMaybeValueMap);
            }
        }
    }

    private static void changeLastIndex(List<Index> indexList, Map<String, List<String>> map) {
        int changeIndex = indexList.size() - 1;
        for (; changeIndex > 0; changeIndex--) {
            Index index = indexList.get(changeIndex);
            if (!(index.index < map.get(index.key).size())) {
                index.index = index.index + 1;
                break;
            }
        }
        if (changeIndex <= 0) {
            // 已经所有都循环过了
            throw new IllegalArgumentException("无效数独");
        }

        // 清空改变后面的下表为0
        changeIndex++;
        for (; changeIndex < indexList.size(); changeIndex++) {
            indexList.get(changeIndex).index = 0;
        }
    }

    private static int getIndex(List<Index> indexList, String key) {
        for (Index index : indexList) {
            if (index.key.equals(key)) {
                return index.index;
            }
        }
        throw new NullPointerException("没有这个key");
    }

    /**
     * 校验数独是否完整
     *
     * @param sudoku 数独数组
     * @return 是否完整
     */
    private static boolean fullValid(String[][] sudoku) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (".".equals(sudoku[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }


    private static List<String> getMaybeValue(String[][] sudoku, int i, int j) {
        ArrayList<String> cloneFullList = new ArrayList<>(fullValueList);
        for (int i1 = 0; i1 < length; i1++) {
            // 去除同横同列的值
            cloneFullList.remove(sudoku[i][i1]);
            cloneFullList.remove(sudoku[i1][j]);
        }
        // 去除3X3格子的值
        int x33x = i / 3;
        int x33y = j / 3;
        cloneFullList.remove(sudoku[x33x * 3][x33y * 3]);
        cloneFullList.remove(sudoku[x33x * 3][x33y * 3 + 1]);
        cloneFullList.remove(sudoku[x33x * 3][x33y * 3 + 2]);
        cloneFullList.remove(sudoku[x33x * 3 + 1][x33y * 3]);
        cloneFullList.remove(sudoku[x33x * 3 + 1][x33y * 3 + 1]);
        cloneFullList.remove(sudoku[x33x * 3 + 1][x33y * 3 + 2]);
        cloneFullList.remove(sudoku[x33x * 3 + 2][x33y * 3]);
        cloneFullList.remove(sudoku[x33x * 3 + 2][x33y * 3 + 1]);
        cloneFullList.remove(sudoku[x33x * 3 + 2][x33y * 3 + 2]);
        return cloneFullList;
    }

    static class Index {
        String key;
        int index;

        Index(String key, int index) {
            this.key = key;
            this.index = index;
        }
    }
}
