package leetcode2;

public class LeetCode125 {

    public static void main(String[] args) {
        System.out.println(valid("A man, a plan, a canal: Panama"));
        System.out.println(valid("race a car"));
        System.out.println(valid2("A man, a plan, a canal: Panama"));
        System.out.println(valid2("race a car"));
    }

    /**
     * 验证回文串
     *
     * @param str 字符串
     * @return 结果
     */
    private static boolean valid(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int end = str.length() - 1;
        int start = 0;
        while (start < end) {
            if (str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean valid2(String str) {
        int end = str.length() - 1;
        int start = 0;
        while (start < end) {
            if (!Character.isLetterOrDigit(str.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(str.charAt(end))) {
                end--;
            } else {
                if (Character.toLowerCase(str.charAt(start)) != Character.toLowerCase(str.charAt(end))) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }
}
