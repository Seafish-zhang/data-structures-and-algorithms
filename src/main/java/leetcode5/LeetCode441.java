package leetcode5;

public class LeetCode441 {

    public static void main(String[] args) {
        System.out.println(arrangeCoin(5));
        System.out.println(arrangeCoin(8));
    }

    /**
     * 排列硬币
     * <p>第k层得拥有k个硬币才完整</p>
     * <p>最多排到几完整层</p>
     *
     * @param n 硬币数
     * @return 完整最大层数
     */
    private static int arrangeCoin(int n) {
        if (n < 2) {
            return n;
        }
        int level = 0;
        int sum = 0;
        while (sum < n) {
            level++;
            sum += level;
        }
        if (sum == n) {
            return level;
        } else {
            return level - 1;
        }
    }
}
