package leetcode;

import java.util.Random;

public class LeetCode8 {
    // I = 1,V=5,X=10,L=50,C=100,D=500,M=1000
    private static String[] thousand = {"", "M", "MM", "MMM"};
    private static String[] hundred = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static String[] ten = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static String[] one = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public static void main(String[] args) {
        System.out.println("整数为 ：" + 1994 + " 罗马数字表示为 ：" + int2RomeSymbol(1994));
        Random random = new Random();
        int count = 5;
        for (int i = 0; i < count; i++) {
            int nextInt = random.nextInt(4000);
            System.out.println("整数为 ：" + nextInt + " 罗马数字表示为 ：" + int2RomeSymbol(nextInt));
        }
    }

    private static String int2RomeSymbol(int ori) {

        return thousand[ori / 1000] + hundred[(ori % 1000) / 100] + ten[(ori % 100) / 10] + one[ori % 10];

    }
}
