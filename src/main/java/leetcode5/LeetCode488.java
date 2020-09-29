package leetcode5;

public class LeetCode488 {

    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(zumaGame("WRRBBW", "RB"));
        System.out.println(zumaGame("WWRRBBWW", "WRBRW"));
    }

    /**
     * 祖玛游戏
     * <p>示例：</p>
     * <p>board：WRRBBW hand：RB， result： -1 </p>
     * <p>WRRBBW->WRR[R]BBW-WBBB[B]W->WW </p>
     *
     * @param board 桌上的球
     * @param hand  手上的球
     * @return 最小清空步数（无法清空返回 -1）
     */
    private static int zumaGame(String board, String hand) {
        min = Integer.MAX_VALUE;
        int[] handCount = new int[26];
        for (char c : hand.toCharArray()) {
            handCount[c - 'A']++;
        }
        // 加多一个 ! 表示为了方便去除三连
        remove(board, handCount, 0, hand.length());
        if (min <= hand.length()) {
            return min;
        } else {
            return -1;
        }
    }

    private static void remove(String board, int[] handCount, int stepCount, int maxCount) {
        // 移除相连的
        board = remove3Consecutive(board);
        // 如果删除完成
        if (board == null || board.length() == 0) {
            min = Math.min(min, stepCount);
            return;
        }
        int currentNeed;
        for (int i = 0, j = 0; i < board.length(); i++) {
            if (board.charAt(j) == board.charAt(i)) {
                continue;
            }
            // 需要填充才能达到删除的个数
            currentNeed = 3 - (i - j);

            if (stepCount + currentNeed > maxCount) {
                j = i;
                continue;
            }
            // 判断手上的球满足需要的
            if (handCount[board.charAt(j) - 'A'] >= currentNeed) {
                handCount[board.charAt(j) - 'A'] -= currentNeed;
                // 继续递归判断剩下的情况
                remove(board.substring(0, j) + board.substring(i)
                        , handCount, stepCount + currentNeed, maxCount);
                // 还原
                handCount[board.charAt(j) - 'A'] += currentNeed;
            }
            j = i;
        }
    }

    private static String remove3Consecutive(String board) {
        int n = board.length();
        for (int i = 0, j = 0; i < n; i++) {
            if (board.charAt(i) == board.charAt(j)) {
                if (i == n - 1 && i - j >= 3) {
                    board = board.substring(0, j);
                    break;
                }
                continue;
            }
            if (i - j >= 3) {
                // 移除相连的一段
                board = board.substring(0, i) + board.substring(j);
                // 重置
                i = 0;
                n = board.length();
            } else {
                j = i;
            }
        }
        return board;
    }
}
