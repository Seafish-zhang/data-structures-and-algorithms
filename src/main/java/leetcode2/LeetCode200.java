package leetcode2;

public class LeetCode200 {

    public static void main(String[] args) {
        System.out.println(numIsLands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        }));
    }

    /**
     * 计算岛数.
     * <p>‘1’代表陆地，‘0’代表海水</p>
     * <p>相连的陆地算同一个岛</p>
     *
     * @param islands 岛数组
     * @return 返回岛数
     */
    private static int numIsLands(char[][] islands) {
        if (islands == null || islands.length == 0) {
            return 0;
        }
        int count = 0;
        int m = islands.length;
        int n = islands[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (islands[i][j] == '1') {
                    // 有岛，岛数加1
                    count++;
                    // 同化，使相连的岛全部置为‘0’,因为此块岛屿已经计算了
                    assimilation(islands, i, j, m, n);
                }
            }
        }
        return count;
    }

    private static void assimilation(char[][] islands, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || islands[i][j] == '0') {
            return;
        }
        islands[i][j] = '0';
        // 四个方向继续同化
        assimilation(islands, i + 1, j, m, n);
        assimilation(islands, i - 1, j, m, n);
        assimilation(islands, i, j + 1, m, n);
        assimilation(islands, i, j - 1, m, n);
    }
}
