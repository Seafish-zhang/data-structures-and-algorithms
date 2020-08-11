package leetcode;

public class LeetCode79 {

    // 用于去除重复的位置
    private static boolean[][] visit;

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(existWord(board, "ABCCED"));
        System.out.println(existWord(board, "SEE"));
        System.out.println(existWord(board, "ABCB"));
    }

    /**
     * 是否存在单词.
     *
     * @param board 二维网络
     * @param word  单词
     * @return 是否搜索的到
     */
    private static boolean existWord(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        visit = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean flag = search(board, word, i, j, 0);
                    if (flag) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean search(char[][] arr, String word, int i, int j, int matchCount) {
        if (matchCount == word.length()) {
            return true;
        } else {
            //超出界外
            if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length) {
                return false;
            }
            //不相等，或者已经被访问过
            if (word.charAt(matchCount) != arr[i][j] || visit[i][j]) {
                return false;
            }
            //当前位置相等，继续匹配下一个字符，四个方向匹配
            visit[i][j] = true;
            if (search(arr, word, i + 1, j, matchCount + 1)
                    || search(arr, word, i - 1, j, matchCount + 1)
                    || search(arr, word, i, j - 1, matchCount + 1)
                    || search(arr, word, i, j + 1, matchCount + 1)
            ) {
                return true;
            }
            //重置访问
            visit[i][j] = false;
            return false;
        }
    }
}
