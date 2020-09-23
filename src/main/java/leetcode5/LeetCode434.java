package leetcode5;

public class LeetCode434 {

    public static void main(String[] args) {

        System.out.println(wordCount("Hello, my name is John"));
        System.out.println(wordCount("Hello, I am seven"));
    }

    /**
     * 字符串中的单词数
     *
     * @param s 字符串
     * @return 单词个数
     */
    private static int wordCount(String s) {
        String[] strings = s.split(" ");
        int count = 0;
        for (String string : strings) {
            if ("".equals(string)) {
                continue;
            }
            count++;
        }
        return count;
    }
}
