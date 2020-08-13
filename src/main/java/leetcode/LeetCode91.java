package leetcode;

public class LeetCode91 {
    public static void main(String[] args) {

        System.out.println(allEncodeCount("12"));
        System.out.println(allEncodeCount("226"));
    }

    private static int allEncodeCount(String str) {
        int[] count = new int[str.length() + 1];
        count[0] = 1;
        count[1] = str.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= str.length(); i++) {
            int x = Integer.parseInt(str.substring(i - 1, i));
            int y = Integer.parseInt(str.substring(i - 2, i));
            if (x > 0 && x <= 9) {
                count[i] += count[i - 1];
            }
            if (y >= 10 && y <= 26) {
                count[i] += count[i - 2];
            }
        }
        return count[str.length()];
    }
}
