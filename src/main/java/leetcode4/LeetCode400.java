package leetcode4;

public class LeetCode400 {

    public static void main(String[] args) {

        System.out.println(findNthDigit(3));
        System.out.println(findNthDigit(11));
    }


    /**
     * 第N个数字
     */
    private static int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }
}
