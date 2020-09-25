package leetcode5;

public class LeetCode466 {

    public static void main(String[] args) {
        System.out.println(getMaxRepetitions("acb", 4, "ab", 2));
        System.out.println(getMaxRepetitions("acd", 8, "aca", 3));
    }

    /**
     * 统计重复个数
     * <p>定义有n个连接的字符串s组成字符串s，即S = [s,n],例如 ['abc',3] = 'abcabcabc'</p>
     * <p>如果我们可以从s2中删除某些字符使其变为s1，我们称字符串s1可以冲字符串s2获得</p>
     * <p>例如： abc 可以根据定义从 abdbec 获得，不能从 acbbe获得</p>
     * <p>给出两个非空字符串s1和s2和两个整数0<=n1<=10^6,0<=n2<=10^6</p>
     * <p>找出[S2,M]从S1获得的最大整数M</p>
     *
     * @param s1 S1的s
     * @param n1 S1的n
     * @param s2 S2的s
     * @param n2 S2的n
     * @return 返回最大的M
     */
    private static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        int i = 0;
        int j = 0;
        int count1 = 0;
        int count2 = 0;
        // 至多n1个s1
        while (count1 < n1) {
            if (s1Chars[i] == s2Chars[j]) {
                j++;
                if (j == s2.length()) {
                    // 完整匹配完一个s2，重置j坐标，count2+1
                    count2++;
                    j = 0;
                }
            }
            i++;
            // 消费完一个s1，count1+1，重置i坐标
            if (i == s1.length()) {
                i = 0;
                count1++;
            }
        }
        // S2有n2的s2
        return count2 / n2;
    }
}
