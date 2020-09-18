package leetcode5;

public class LeetCode409 {


    public static void main(String[] args) {
        System.out.println(longest("abccccdd"));
        System.out.println(longest("abccccbdd"));
    }

    /**
     * 最长回文串
     * <p>输入字符串只包含大写字母和小写字母</p>
     * <p>通过打乱顺序或者删除某些字符构建一个最长的回文串</p>
     *
     * @param s 输入字符串
     * @return 最长回文串个数
     */
    private static int longest(String s) {
        int[] exist = new int[128];

        for (char c : s.toCharArray()) {
            exist[c]++;
        }

        int result = 0;
        boolean odd = false;

        for (int n : exist) {
            if (n % 2 == 0) {
                result += n;
            } else {
                result += n - 1;
                odd = true;
            }
        }

        return odd ? result + 1 : result;
    }
}
