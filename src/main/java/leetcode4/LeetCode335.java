package leetcode4;

public class LeetCode335 {

    public static void main(String[] args) {
        System.out.println(isSelfCrossing(new int[]{2, 1, 1, 2}));
        System.out.println(isSelfCrossing(new int[]{1, 2, 3, 4}));
    }

    /**
     * 路径交叉
     * <p>给定一个含有n个证书的数组x，从点（0,0）开始,向北移动x[0]米，然后向西移动x[1]米</p>
     * <p>向南移动x[2]米，然后向北移动x[3]米。。。</p>
     * <p>即每次移动后方向都会逆时针90度转换方向</p>
     * <p>判断走过的路径是否交叉</p>
     *
     * @param x 移动路径
     * @return 是否交叉
     */
    private static boolean isSelfCrossing(int[] x) {

        // 根据分析，交叉会有三种情况，判断是否复合这三种情况即可
        for (int i = 3; i < x.length; i++) {
            //  第一种情况
            //  x[i-2] #---------# x[i-3]
            //         |         |
            //         |         |
            //         |         |
            //         |         |
            //  x[i-1] #------------# x[i]
            //               (0，0)
            if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) {
                return true;
            }
            //  第二种情况
            // x[i-3] #---------#x[i-4]
            //        |         |
            //        |    x[i] #
            //        |         |(0，0)
            //        |         |
            // x[i-2] #---------#x[i-1]
            //
            if (i >= 4 && x[i] + x[i - 4] == x[i - 2] && x[i - 1] == x[i - 3]) {
                return true;
            }
            //  第三种情况
            // x[i-4] #---------#x[i-5]
            //        |         |
            //        |         |
            //        |         |
            //        |         |
            //        |   x[i]#-----------------# x[i-1]
            //        |         |               |
            //        |         |  (0，0)       |
            //        |         |               |
            //        |         |               |
            //        |         |               |
            // x[i-3] #-------------------------#x[i-2]
            //
            if (i >= 5 && x[i] + x[i - 4] >= x[i - 2]
                    && x[i - 1] + x[i - 5] >= x[i - 3]
                    && x[i - 4] <= x[i - 2] && x[i - 1] <= x[i - 3]) {
                return true;
            }
        }
        return false;

    }
}
