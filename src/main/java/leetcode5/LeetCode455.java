package leetcode5;

import java.util.Arrays;

public class LeetCode455 {

    public static void main(String[] args) {
        System.out.println(distributeCookie(new int[]{1, 2, 3}, new int[]{1, 1}));
        System.out.println(distributeCookie(new int[]{1, 2}, new int[]{1, 2, 3}));
    }

    /**
     * 分发饼干
     * <p>数组g是代表小孩的胃口，数组s是代表饼干的大小</p>
     * <p>如果分配的饼干大于或者等于胃口，那么这个小孩就会满足</p>
     * <p>每个小孩只能有一块饼干，求最大孩子满足数</p>
     *
     * @param g 胃口
     * @param s 饼干
     * @return 最大满足数
     */
    private static int distributeCookie(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0;
        int si = 0;
        int count = 0;
        while (gi < g.length && si < s.length) {
            if (s[si] >= g[gi]) {
                //满足
                count++;
                si++;
                gi++;
            } else {
                si++;
            }
        }
        return count;
    }
}
