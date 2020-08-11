package leetcode;

public class LeetCode50 {

    public static void main(String[] args) {
        System.out.println(pow(2.00000, 2));
    }

    private static double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double half = pow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
