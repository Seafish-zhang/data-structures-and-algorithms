package leetcode;

public class LeetCode6 {

    public static void main(String[] args) {
        System.out.println(isPalindromeInt(121));
        System.out.println(isPalindromeInt(-121));
        System.out.println(isPalindromeInt(43908));
    }

    /**
     * 是否回文整数.
     *
     * @param ori 目标整数
     * @return 是否回文
     */
    private static boolean isPalindromeInt(int ori) {
        if (ori < 0) {
            return false;
        } else if (ori == 0) {
            return true;
        } else {
            int temp = ori;
            int reverse = 0;
            while (temp != 0) {
                reverse *= 10;
                reverse += temp % 10;
                temp /= 10;
            }
            return reverse == ori;
        }
    }
}
