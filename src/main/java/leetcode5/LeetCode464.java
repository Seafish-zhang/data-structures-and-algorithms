package leetcode5;

import java.util.HashMap;
import java.util.Map;

public class LeetCode464 {

    public static void main(String[] args) {
        System.out.println(firstPlayerWin(10, 11));
        System.out.println(firstPlayerWin(15, 100));
        System.out.println(firstPlayerWin(10, 100));
    }

    /**
     * 我能赢吗
     * <p>给定数字[1,maxSelectNum]整数范围，两名玩家轮流选择一个整数，累计整数和</p>
     * <p>第一位选择后，累计整数和 >= desiredTotal者为胜利</p>
     *
     * @param maxSelectNum 最大选择范围
     * @param desiredTotal 目标累计整数
     * @return 第一位选手能否能赢
     */
    private static boolean firstPlayerWin(int maxSelectNum, int desiredTotal) {
        int sum = (1 + maxSelectNum) * maxSelectNum / 2;
        if (sum < desiredTotal) {
            throw new IllegalArgumentException("参数错误，所有给定数字累计和不足目标值");
        }
        if (maxSelectNum >= desiredTotal) {
            return true;
        }
        // 已经存的结果
        Map<String, Boolean> map = new HashMap<>();
        // 当前已使用过的数字
        int[] used = new int[maxSelectNum + 1];
        return dfs(map, used, desiredTotal);
    }

    private static boolean dfs(Map<String, Boolean> map, int[] used, int desiredTotal) {
        String key = intArrayToStr(used);
        if (desiredTotal <= 0) {
            // 记录下来
            map.put(key, false);
            // 上步已经达到期望值
            return false;
        }
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            // 选择
            for (int i = 1; i < used.length; i++) {
                if (used[i] == 0) {
                    // 只有没被选过的才可以允许
                    used[i] = 1;
                    // 轮到对方选择
                    if (!dfs(map, used, desiredTotal - i)) {
                        map.put(key, true);
                        used[i] = 0;
                        return true;
                    } else {
                        // 还原，重新选择
                        used[i] = 0;
                    }
                }
            }
            map.put(key, false);
        }
        return map.get(key);
    }

    private static String intArrayToStr(int[] used) {
        StringBuilder sb = new StringBuilder();
        for (int i : used) {
            sb.append(i);
        }
        return sb.toString();
    }
}
