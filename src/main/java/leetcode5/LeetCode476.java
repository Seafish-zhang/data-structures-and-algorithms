package leetcode5;

public class LeetCode476 {

    public static void main(String[] args) {
        System.out.println(findComplement(5));
        System.out.println(findComplement(3));
        System.out.println(findComplement2(5));
        System.out.println(findComplement2(3));
    }


    /**
     * 数字的补数
     *
     * @param num 目标数组
     * @return 补数结果
     */
    private static int findComplement(int num) {
        String str = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '0') {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    private static int findComplement2(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }
}
