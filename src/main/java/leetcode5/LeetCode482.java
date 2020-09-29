package leetcode5;

public class LeetCode482 {

    /**
     * 密钥格式化
     * <p>给定一个密钥字符串s，只包含字母，数字以及‘-’，N个‘-’将字符串分成N+1组</p>
     * <p>现在要重新格式化密钥，除了第一组外，每次都包含k个字符，组与组之间用‘-’隔开</p>
     * <p>求出格式化后的密钥</p>
     *
     * @param s 原始密钥字符串
     * @param k 每组字符个数
     * @return 格式化后的密钥字符串
     */
    private static String format(String s, int k) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        // 除了第一组，每组都有k个，从后面加起比较方便
        for (int i = s.length() - 1, j = 0; i >= 0; ) {
            if (j < k) {
                if (chars[i] != '-') {
                    if (chars[i] >= 'a' && chars[i] <= 'z') {
                        sb.append(Character.toUpperCase(chars[i]));
                    } else {
                        sb.append(Character.toUpperCase(chars[i]));
                    }
                    j++;
                }
                i--;
            } else if (j == k) {
                // 满足个数，重置
                j = 0;
                sb.append('-');
            }
        }
        if (sb.length() > 1 && sb.substring(sb.length() - 1).equals("-")) {
            return sb.reverse().substring(1);
        } else {
            return sb.reverse().toString();
        }
    }
}
