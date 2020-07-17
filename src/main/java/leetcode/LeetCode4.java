package leetcode;

import java.util.Random;

public class LeetCode4 {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE / 10);
        System.out.println(Integer.MIN_VALUE / 10);
        int count = 10;
        for (int i = 0; i < count; i++) {
            Random random = new Random();
            int ori = random.nextInt(Integer.MAX_VALUE / 10);
            int reverse = reverse(ori);
            System.out.println("ori = " + ori + " reverse = " + reverse);
            int negative = 0 - ori;
            int reverse1 = reverse(negative);
            System.out.println("negative = " + negative + " reverse = " + reverse1);
        }
    }

    /**
     * 倒转数字
     *
     * @param ori 原值
     * @return 倒转后数字
     */
    private static int reverse(int ori) {
        int reverse = 0;
        while (ori != 0) {
            int pop = ori % 10;
            ori /= 10;
            if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            reverse = reverse * 10 + pop;
        }
        return reverse;
    }
}
