package leetcode3;

public class LeetCode214 {


    public static void main(String[] args) {
        System.out.println(shortest("aacecbaa"));
        System.out.println(shortest("abcd"));

        System.out.println(shortestByAddPrev("aacecbaa"));
        System.out.println(shortestByAddPrev("abcd"));
    }

    /**
     * 最短回文串
     * <p>给定一个字符串，通过在字符串添加字符将其转换为回文串</p>
     *
     * @param str 目标字符串
     * @return 返回最短回文串
     */
    private static String shortest(String str) {
        int left = 0;
        int right = str.length() - 1;

        StringBuilder prev = new StringBuilder();

        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                prev.append(str.charAt(left));
                left++;
                right--;
            } else {
                prev.append(str.charAt(right));
                right--;
            }
        }
        return prev.toString() + str.substring(left);
    }

    /**
     * 最短回文串
     * <p>给定一个字符串，通过在字符串"前面"添加字符将其转换为回文串</p>
     *
     * @param s 目标字符串
     * @return 返回最短回文串
     */
    private static String shortestByAddPrev(String s) {
        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] table = getTable(temp);
        return new StringBuilder(s.substring(table[table.length - 1]))
                .reverse().toString() + s;
    }

    private static int[] getTable(String s) {
        int[] table = new int[s.length()];

        int index = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(index) == s.charAt(i)) {
                table[i] = table[i - 1] + 1;
                index++;
            } else {
                index = table[i - 1];

                while (index > 0 && s.charAt(index) != s.charAt(i)) {
                    index = table[index - 1];
                }

                if (s.charAt(index) == s.charAt(i)) {
                    index++;
                }
                table[i] = index;
            }
        }
        return table;
    }
}
