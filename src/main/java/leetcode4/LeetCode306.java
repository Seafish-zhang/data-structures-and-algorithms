package leetcode4;

public class LeetCode306 {

    public static void main(String[] args) {
        System.out.println(isAccumulationNum("112358"));
        System.out.println(isAccumulationNum("199100199"));
    }


    /**
     * 判断是否累加数
     * <p>累加数是一个字符串，组成它的数字可以形成累加序列</p>
     * <p>字符串只包含数字‘0-9’的字符</p>
     * <p>数字不会以‘0’为开头</p>
     *
     * @param s 字符串
     * @return 是否累加数
     */
    private static boolean isAccumulationNum(String s) {

        int n = s.length();
        // 只需要指定前面两个数，后面可以根据规则去比较是否符合
        // 假设 i，j分别为两个开始加数的位数
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
                // 加数的和最多只能是和最大位数的加数相等，即 i 和 j 之前的最大值
                // 要小于或者等于 字符串长度减去两者的和，保证和的位数足够
                // 所以 Math.max(i, j) <= n - i - j
                if (isValid(i, j, s)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValid(int i, int j, String s) {
        // 不能以‘0’开头数字
        if (s.charAt(0) == '0' && i > 1) {
            return false;
        }
        if (s.charAt(i) == '0' && j > 1) {
            return false;
        }
        String sum;
        Long x1 = Long.parseLong(s.substring(0, i));
        Long x2 = Long.parseLong(s.substring(i, i + j));

        for (int start = i + j; start != s.length(); start += sum.length()) {
            x2 = x2 + x1;
            x1 = x2 - x1;

            sum = x2.toString();
            if (!s.startsWith(sum, start)) {
                return false;
            }
        }
        return true;
    }
}
