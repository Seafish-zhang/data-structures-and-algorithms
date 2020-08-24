package leetcode3;

public class LeetCode203 {

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
        System.out.println(countPrimes(15));
    }

    private static int countPrimes(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (isPrimes(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrimes(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
