package leetcode4;

public class LeetCode389 {

    public static void main(String[] args) {
        System.out.println(findDifferent("abcd", "abcda"));
        System.out.println(findDifferent("abcde", "aebcdf"));
    }


    /**
     * 找不同
     * <p>t由s打乱顺序再加一个字符转变的，找出这个不同的字符</p>
     *
     * @param s 原字符
     * @param t 转换后字符
     * @return 不同的字符
     */
    private static char findDifferent(String s, String t) {
        int[] counts = new int[128];

        for (int i = 0; i < s.toCharArray().length; i++) {
            counts[s.charAt(i)]++;
        }

        for (int i = 0; i < t.toCharArray().length; i++) {
            counts[t.charAt(i)]--;
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                return (char) i;
            }
        }
        return 'a';
    }
}
