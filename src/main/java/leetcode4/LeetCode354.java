package leetcode4;

import java.util.Arrays;

public class LeetCode354 {

    public static void main(String[] args) {
        System.out.println(maxEnvelops(new int[][]{
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3}
        }));
    }


    /**
     * 俄罗斯套娃信封问题
     * <p>envelops是信封的（w，h）数组，当另一个信封的宽高都比这个信封大时</p>
     * <p>这个信封就可以装到另一个信封里面，求最多多少个信封能组成俄罗斯套娃信封</p>
     *
     * @param envelops 信封（宽，高）数组
     * @return 最大套娃数
     */
    private static int maxEnvelops(int[][] envelops) {
        if (envelops == null || envelops.length == 0
                || envelops[0].length != 2) {
            return 0;
        }

        Arrays.sort(envelops, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        int[] dp = new int[envelops.length];
        int len = 0;

        for (int[] envelop : envelops) {
            int index = Arrays.binarySearch(dp, 0, len, envelop[1]);

            if (index < 0) {
                index = -(index + 1);
            }

            dp[index] = envelop[1];
            if (index == len) {
                len++;
            }
        }
        return len;
    }
}
