package leetcode4;

import java.util.Arrays;

public class LeetCode319 {

    public static void main(String[] args) {

        System.out.println(onCount(3));
        System.out.println(onCount(4));


        System.out.println(onCount2(3));
        System.out.println(onCount2(4));
    }

    private static int onCount2(int n) {
        if (n < 2) {
            return n;
        }
        return (int) Math.sqrt(n);
    }

    /**
     * 灯泡开关
     * <p>n个灯泡，进行n轮开关</p>
     * <p>第一轮，全打开</p>
     * <p>第二轮以及以后，每该轮次个灯光切换一次开关</p>
     * <p>即，第二轮，每两个灯泡切换一次，第三轮，每三个灯泡切换一次</p>
     *
     * @param n 灯泡数
     * @return 最后还开着的数
     */
    private static int onCount(int n) {
        if (n < 1) {
            return 0;
        }

        boolean[] light = new boolean[n];

        // 第一次全打开
        Arrays.fill(light, true);

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                if ((j + 1) % i == 0) {
                    light[j] = !light[j];
                }
            }
        }

        int count = 0;
        for (boolean b : light) {
            if (b) {
                count++;
            }
        }

        return count;
    }
}
