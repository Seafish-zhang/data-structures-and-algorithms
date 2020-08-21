package leetcode2;

public class LeetCode166 {

    public static void main(String[] args) {
        System.out.println(toDecimals(1, 2));
        System.out.println(toDecimals(1, -2));
        System.out.println(toDecimals(2, 3));
        System.out.println(toDecimals(1, 49));
    }

    /**
     * 分数转小数
     *
     * @param numerator   分子
     * @param denominator 分母
     * @return 小数字符串
     */
    private static String toDecimals(int numerator, int denominator) {
        if (denominator == 0) {
            return "0";
        }
        // 符号
        String sign = (numerator >= 0 && denominator > 0)
                || (numerator < 0 && denominator < 0) ? "" : "-";

        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        StringBuilder sb = new StringBuilder();
        sb.append(sign);
        int integral = Math.abs(numerator / denominator);
        sb.append(integral);
        int remiand = numerator % denominator;
        if (remiand == 0) {
            return sb.toString();
        } else {
            sb.append(".");
        }
        int lastRemiand = 0;
        while (remiand != 0 && remiand != lastRemiand) {
            lastRemiand = remiand;
            int n = remiand * 10 / denominator;
            remiand = remiand * 10 % denominator;
            sb.append(n);
            if (sb.length() >= 64) {
                return sb.toString();
            }
        }
        if (lastRemiand == remiand) {
            sb.insert(sb.length() - 1, "(");
            sb.append(")");
        }
        return sb.toString();
    }
}
