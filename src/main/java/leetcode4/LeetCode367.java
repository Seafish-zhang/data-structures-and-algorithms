package leetcode4;

public class LeetCode367 {

    public static void main(String[] args) {
        System.out.println(isSquare(16));
        System.out.println(isSquare(9));
        System.out.println(isSquare(1521344211));
        System.out.println(isSquare2(16));
        System.out.println(isSquare2(9));
        System.out.println(isSquare2(1521344211));
    }

    /**
     * 是否有效完全平方数
     *
     * @param num 数值
     * @return 是否
     */
    private static boolean isSquare(int num) {
        long i = 1;
        long temp = 1;
        int k = 0;
        while (temp < num) {
            k++;
            i++;
            temp = i * i;
        }
        System.out.println(k);
        return temp == num;
    }

    private static boolean isSquare2(int num) {
        long i = 1;
        long temp = 1;
        int k = 0;
        while (temp < num) {
            k++;
            i += 2;
            temp += i;
        }
        System.out.println(k);
        return temp == num;
    }
}
