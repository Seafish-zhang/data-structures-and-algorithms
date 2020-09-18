package leetcode5;

public class LeetCode402 {

    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        minRemain("1432219", 3);
        System.out.println(min);
        min = Integer.MAX_VALUE;
        minRemain("10200", 1);
        System.out.println(min);
    }

    /**
     * 移掉k位数字
     * <p>给一个数字组成的字符串移除限定位数字，保留相对顺序</p>
     * <p>算出最小结果</p>
     *
     * @param num 数字组成的字符串
     * @param k   移除限定位数字
     */
    private static void minRemain(String num, int k) {
        if (num.length() < k) {
            throw new IllegalArgumentException();
        }
        match(num, k, 0);
    }

    private static void match(String remain, int k, int deleteCount) {
        if (deleteCount == k) {
            min = Math.min(min, Integer.parseInt(remain));
        } else {
            for (int i = 0; i < remain.length(); i++) {
                match(remain.substring(0, i) + remain.substring(i + 1), k, deleteCount + 1);
            }
        }
    }
}
