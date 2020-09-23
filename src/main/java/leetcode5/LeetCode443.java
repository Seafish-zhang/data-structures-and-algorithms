package leetcode5;

import java.util.Arrays;

public class LeetCode443 {

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'a', 'b', 'b', 'b'};
        System.out.println(compress(chars));
        System.out.println(Arrays.toString(chars));
    }

    /**
     * 压缩字符串
     * <p>给定一组字符，将其压缩，长度必须小于或者等于原数组长度</p>
     * <p>压缩规律：[a,a,a,b,b,b]==>[a,3,b,3]</p>
     *
     * @param chars 字符数组
     * @return 压缩后有效长度
     */
    private static int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char prev = chars[0];
        for (char aChar : chars) {
            if (aChar == prev) {
                count++;
            } else {
                if (count > 1) {
                    sb.append(prev);
                    sb.append(count);
                } else if (count == 1) {
                    sb.append(prev);
                }
                prev = aChar;
                count = 1;
            }
        }
        sb.append(prev);
        if (count > 1) {
            sb.append(count);
        }
        int i = 0;
        for (char c : sb.toString().toCharArray()) {
            chars[i++] = c;
        }
        return sb.length();
    }
}
