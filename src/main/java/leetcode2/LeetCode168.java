package leetcode2;

public class LeetCode168 {

    public static void main(String[] args) {
        System.out.println(excelName(1));
        System.out.println(excelName(28));
        System.out.println(excelName(703));
    }

    private static String excelName(int num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int i = (num - 1) % 26;
            sb.append((char) (i + 'A'));
            num = (num - 1) / 26;
        }
        return sb.reverse().toString();
    }
}
