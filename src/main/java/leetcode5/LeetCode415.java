package leetcode5;

public class LeetCode415 {

    public static void main(String[] args) {
        System.out.println(strSum("123", "456"));
        System.out.println(strSum("123536664363", "4323234324241156"));
    }


    /**
     * 字符串相加
     * <p>两个字符串形式的非负整数相加</p>
     * <p>两个字符串长度小于5100，只包含0-9</p>
     *
     * @param num1 数字1
     * @param num2 数字2
     * @return 结果
     */
    private static String strSum(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int current;
        int advance = 0;
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int i = chars1.length - 1;
        int j = chars2.length - 1;
        while (i >= 0 || j >= 0) {
            current = advance;

            if (i >= 0) {
                current += Character.getNumericValue(chars1[i--]);
            }
            if (j >= 0) {
                current += Character.getNumericValue(chars2[j--]);
            }
            advance = current / 10;
            sb.append(current % 10);
        }
        if (advance != 0) {
            sb.append(advance);
        }
        return sb.reverse().toString();
    }
}
