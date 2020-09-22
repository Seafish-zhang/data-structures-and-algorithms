package leetcode5;

public class LeetCode423 {

    public static void main(String[] args) {
        System.out.println(unSortStrToNum(cover("one two three four five six  seven eight nine zero")));
        System.out.println(unSortStrToNum(cover("one one two three four four five eight nine nine")));
    }

    private static String cover(String s) {
        int[] exist = new int[26];
        for (char c : s.trim().toCharArray()) {
            if (c == ' ') {
                continue;
            }
            exist[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < exist.length; i++) {
            for (int j = 0; j < exist[i]; j++) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }

    /**
     * 乱序数字英文转化成从小到大数字
     *
     * @param s 乱序数字英文字符串
     * @return 从小到大数字
     */
    private static String unSortStrToNum(String s) {
        int[] counts = new int[10];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == 'z') {
                counts[0]++;
            } else if (aChar == 'x') {
                counts[6]++;
            } else if (aChar == 'g') {
                counts[8]++;
            } else if (aChar == 'w') {
                counts[2]++;
            } else if (aChar == 'u') {
                counts[4]++;
            } else if (aChar == 'f') {
                counts[5]++;
            } else if (aChar == 's') {
                counts[7]++;
            } else if (aChar == 'h') {
                counts[3]++;
            } else if (aChar == 'o') {
                counts[1]++;
            } else if (aChar == 'i') {
                counts[9]++;
            }
        }

        // 3 和 8 各自包含一个 h
        counts[3] -= counts[8];
        // 6 和 7 各自包含一个 s
        counts[7] -= counts[6];
        // 5 和 4 各自包含一个 f
        counts[5] -= counts[4];
        // 9 6 和 5 各自包含一个 i
        counts[9] = counts[9] - counts[5] - counts[6];
        // 0 1 2 4 各自包含一个 o
        counts[1] = counts[1] - counts[0] - counts[2] - counts[4];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
