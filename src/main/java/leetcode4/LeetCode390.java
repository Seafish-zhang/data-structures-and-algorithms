package leetcode4;

public class LeetCode390 {


    public static void main(String[] args) {
        System.out.println(findLastNum(9));
        System.out.println(findLastNum(17));
    }


    /**
     * 消除游戏
     * <p>数字1-n的列表，第一次从左到右，从第一个数字开始删除，每隔一个数字进行删除</p>
     * <p>第二次从右到左，从倒数第一个数字开始删除，每隔一个数字进行删除</p>
     * <p>直到剩下一个，求出最后那个数字</p>
     *
     * @param n 范围
     * @return 最后数字
     */
    private static int findLastNum(int n) {
        int remaining = n;
        int start = 1;
        int step = 2;
        boolean first = true;
        while (remaining > 1) {
            remaining /= 2;
            if (first) {
                start = start + step * remaining - step / 2;
            } else {
                start = start - step * remaining + step / 2;
            }
            step *= 2;
            first = !first;
        }
        return start;
    }
}
