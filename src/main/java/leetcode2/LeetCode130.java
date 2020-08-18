package leetcode2;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode130 {

    public static void main(String[] args) {
        String[][] arr = new String[][]{
                {"X", "X", "X", "X"},
                {"X", "O", "O", "X"},
                {"X", "X", "O", "X"},
                {"X", "O", "X", "X"}
        };
        printDoubleArr(arr);
        System.out.println();
        changeEnclose(arr);
        printDoubleArr(arr);
    }

    private static void printDoubleArr(String[][] arr) {
        System.out.println("[");
        for (int i = 0; i < arr.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("    [");
            for (String string : arr[i]) {
                sb.append(string).append(", ");
            }
            String s = sb.toString();
            if (s.endsWith(", ")) {
                s = s.substring(0, s.length() - 2);
            }
            if (i == arr.length - 1) {
                s += "]";
            } else {
                s += "],";
            }
            System.out.println(s);
        }

        System.out.println("]");
    }


    /**
     * 被围绕的区域
     * <p>置换被围绕的 “O” 改为 “X”</p>
     * <p>边界上的“O”均无法被置换，与其联通的“O”也无法被围绕</p>
     *
     * @param arr 二维矩阵
     */
    private static void changeEnclose(String[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        Queue<int[]> queue = new LinkedList<>();
        //设置不可变的“O”为“+”
        for (int i = 0; i < m; i++) {
            if (arr[i][0].equals("O")) {
                arr[i][0] = "+";
                //不可变坐标存到队列中，用于后面的传染动作
                queue.offer(new int[]{i, 0});
            }
            if (arr[i][n - 1].equals("O")) {
                arr[i][n - 1] = "+";
                queue.offer(new int[]{i, n - 1});
            }
        }
        for (int j = 0; j < n; j++) {
            if (arr[0][j].equals("O")) {
                arr[0][j] = "+";
                queue.offer(new int[]{0, j});

            }
            if (arr[m - 1][j].equals("O")) {
                arr[m - 1][j] = "+";
                queue.offer(new int[]{m - 1, j});
            }
        }

        //四个方向差值,多一个值用于错开 x和y
        int[] direction = new int[]{0, -1, 0, 1, 0};

        // 传染形式，把“+”相连的“O”置为“+”,即标志这些“O”也不可变
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            // 每个位置相连有四个方向
            for (int i = 0; i < 4; i++) {
                int x = curr[0] + direction[i];
                int y = curr[1] + direction[i + 1];
                // 传染
                if (x >= 0 && x < m && y >= 0 && y < n && arr[x][y].equals("O")) {
                    arr[x][y] = "+";
                    queue.offer(new int[]{x, y});
                }
            }
        }

        // 最后遍历替换，把“O”置换为“X”，因为这些是可以置换的，把“+”置换为“O”，因为这部分是不可置换的
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j].equals("O")) {
                    arr[i][j] = "X";
                } else if (arr[i][j].equals("+")) {
                    arr[i][j] = "O";
                }
            }
        }

    }

}
