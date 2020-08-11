package leetcode;

public class LeetCode43 {

    public static void main(String[] args) {
        System.out.println(strMultiply("123", "456"));
        System.out.println(strMultiply("1231", "4516"));
    }


    private static String strMultiply(String str1, String str2) {
        if (isZero(str1) || isZero(str2)) {
            return "0";
        }
        int[] result = new int[str1.length() + str2.length()];

        //str1每一位数字字符都要和str的每一位字符相乘
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                int singleMultiply = Character.getNumericValue(str1.charAt(i)) *
                        Character.getNumericValue(str2.charAt(j));
                result[i + j + 1] += singleMultiply % 10;
                if (result[i + j + 1] >= 10) {
                    result[i + j + 1] %= 10;
                    result[i + j]++;
                }
                result[i + j] += singleMultiply / 10;
                if (result[i + j] >= 10) {
                    result[i + j] %= 10;
                    result[i + j - 1]++;
                }
            }
        }

        //返回
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (int value : result) {
            if (first && 0 == value) {
                continue;
            }
            first = false;
            sb.append(value);
        }
        return sb.toString();
    }

    private static boolean isZero(String str) {
        for (int i = 0; i < str.length(); i++) {
            if ('0' != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
