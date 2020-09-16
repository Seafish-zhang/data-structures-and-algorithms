package leetcode4;

public class LeetCode383 {

    public static void main(String[] args) {
        System.out.println(match("a", "b"));
        System.out.println(match("aa", "ab"));
        System.out.println(match("aa", "aab"));
    }


    /**
     * 赎金信
     *
     * @param ransom   赎金信
     * @param magazine 杂志
     * @return 是否能构成
     */
    private static boolean match(String ransom, String magazine) {
        char[] chars = magazine.toCharArray();
        int[] charCount = new int[256];
        for (char aChar : chars) {
            charCount[aChar - 'a']++;
        }

        char[] chars1 = ransom.toCharArray();
        for (char c : chars1) {
            if (charCount[c - 'a'] <= 0) {
                return false;
            }
            charCount[c - 'a']--;
        }
        return true;
    }
}
