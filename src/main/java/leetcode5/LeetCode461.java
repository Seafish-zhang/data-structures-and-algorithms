package leetcode5;

public class LeetCode461 {

    public static void main(String[] args) {
        System.out.println(hanMingDistance(1, 4));
        System.out.println(hanMingDistance(2, 3));
    }

    /**
     * 汉明距离
     * <P>计算两个整数二进制的差别</P></P>
     *
     * @param x x
     * @param y y
     * @return 距离
     */
    private static int hanMingDistance(int x, int y) {
        int result = x ^ y;
        int count = 0;
        String s = Integer.toBinaryString(result);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

}
