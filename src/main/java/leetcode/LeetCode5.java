package leetcode;

public class LeetCode5 {

    public static void main(String[] args) {
        System.out.println(atoi("42"));
        System.out.println(atoi("    -42"));
        System.out.println(atoi("4139 with words"));
        System.out.println(atoi("word and 987"));
        System.out.println(atoi("-9123242444249952"));
        System.out.println(atoi("42443535646464664"));
    }

    /**
     * aoti.
     *
     * @param ori 原字符串
     * @return aoti的整数.
     */
    private static int atoi(String ori) {
        int start = 0;

        while (start < ori.length() && Character.isWhitespace(ori.charAt(start))) {
            start++;
        }
        boolean negative = (ori.charAt(start) == '-');
        if (ori.charAt(start) == '-' || ori.charAt(start) == '+') {
            start++;
        }
        if (start == ori.length()) {
            return 0;
        }
        int result = 0;
        for (; start < ori.length(); start++) {
            if (ori.charAt(start) > '9' || ori.charAt(start) < '0') {
                break;
            } else {
                int digit = ori.charAt(start) - '0';
                if (!negative && result > (Integer.MAX_VALUE - digit) / 10) {
                    return Integer.MAX_VALUE;
                } else if (negative && result < (Integer.MIN_VALUE + digit) / 10) {
                    return Integer.MIN_VALUE;
                }
                result = result * 10 + (negative ? -digit : digit);
            }
        }
        return result;
    }

}
