package leetcode3;

public class LeetCode299 {

    public static void main(String[] args) {
        System.out.println(guess("1807", "7810"));
        System.out.println(guess("1907", "9817"));
        System.out.println(guess("1977", "7907"));
        System.out.println(guess("19771", "79057"));
    }


    /**
     * 猜数字游戏
     *
     * @param secret 秘密数字
     * @param guess  猜测数字
     * @return 猜的结果
     */
    private static String guess(String secret, String guess) {

        if (secret.length() != guess.length()) {
            throw new IllegalArgumentException("长度不一致");
        }

        int[] secretArr = new int[10];
        int[] guessArr = new int[10];
        int bulls = 0;

        for (int i = 0; i < secret.length(); i++) {
            if (guess.charAt(i) == secret.charAt(i)) {
                bulls++;
            } else {
                secretArr[Character.getNumericValue(secret.charAt(i))]++;
                guessArr[Character.getNumericValue(guess.charAt(i))]++;
            }
        }

        int cows = 0;
        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretArr[i], guessArr[i]);
        }
        return bulls + "A" + cows + "B";
    }
}
