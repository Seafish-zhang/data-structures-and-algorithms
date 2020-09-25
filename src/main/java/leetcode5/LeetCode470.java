package leetcode5;

import java.util.Random;

public class LeetCode470 {

    public static void main(String[] args) {
        System.out.println(rand10());
        System.out.println(rand10());
        System.out.println(rand10());
    }

    /**
     * 用rand7()实现rand10()
     * <p>尽可能的少于rand7()</p>
     *
     * @return rand10()
     */
    private static int rand10() {
        while (true) {
            int num = (rand7() - 1) * 7 + rand7();
            if (num <= 40) {
                return num % 10 + 1;
            }
        }
    }

    private static int rand7() {

        Random random = new Random();
        return random.nextInt(7) + 1;
    }
}
