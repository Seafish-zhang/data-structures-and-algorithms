package leetcode2;

public class LeetCode151 {

    public static void main(String[] args) {
        System.out.println(reversalWord("the sky is blue"));
        System.out.println(reversalWord(" the  sky is  blue"));
    }

    /**
     * 翻转字符串中的单词.
     * <p>输入字符串可以在前面或者后面有多余的空格，反转后不保留</p>
     * <p>单词间可能有多个空格，反转后只保留一个</p>
     *
     * @param wordStr 字符串
     * @return 翻转后字符串
     */
    private static String reversalWord(String wordStr) {
        String[] split = wordStr.split(" ");
        boolean first = true;
        StringBuilder sb = new StringBuilder();
        for (String word : split) {
            if (word.length() != 0) {
                word = reverse(word);
                if (first) {
                    first = false;
                } else {
                    sb.append(" ");
                }
                sb.append(word);
            }
        }

        return sb.reverse().toString();
    }

    private static String reverse(String word) {
        char[] charArray = word.toCharArray();
        char[] chars = new char[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            chars[charArray.length - i - 1] = charArray[i];
        }
        return new String(chars);
    }
}
