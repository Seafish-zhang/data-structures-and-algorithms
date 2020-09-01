package leetcode3;

public class LeetCode273 {

    private static String[] belowTen = new String[]{"Zero", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine"};
    private static String[] belowTwenty = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static String[] belowHundred = new String[]{"Twenty", "Thirty", "Forty", "Fifty", "Sixty",
            "Seventy", "Eighty", "Ninety"};
    private static String[] overThousand = new String[]{"Thousand", "Million", "Billion"};


    public static void main(String[] args) {
        System.out.println(numToWords(123));
        System.out.println(numToWords(12345));
        System.out.println(numToWords(1234567));
        System.out.println(numToWords(123456789));
    }

    /**
     * 数字转换英文表示
     *
     * @param num 数组
     * @return 英文
     */
    private static String numToWords(int num) {
        StringBuilder result;
        if (num == 0) {
            return belowTen[num];
        }

        result = new StringBuilder(hundredHelper(num % 1000));

        num = num / 1000;
        int i = 0;
        while (i < 3 && num > 0) {
            if (num % 1000 > 0) {
                result.insert(0, hundredHelper(num % 1000) + overThousand[i] + " ");
            }
            num = num / 1000;
            i++;
        }
        return result.toString().trim();
    }

    private static String hundredHelper(int num) {
        String numStr = "";
        if (num >= 100) {
            numStr = belowTen[num / 100] + " Hundred ";
        }

        num = num % 100;

        if (num >= 20) {
            if (num % 10 != 0) {
                numStr = numStr + belowHundred[num / 10 - 2] + " " + belowTen[num % 10] + " ";
            } else {
                numStr = numStr + belowHundred[num / 10 - 2] + " ";
            }
        } else if (num >= 10) {
            numStr = numStr + belowTwenty[num % 10] + " ";
        } else if (num > 0) {
            numStr = numStr + belowTen[num] + " ";
        }
        return numStr;
    }
}
