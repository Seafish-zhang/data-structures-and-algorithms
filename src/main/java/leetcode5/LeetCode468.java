package leetcode5;

import java.util.Arrays;
import java.util.List;

public class LeetCode468 {

    public static void main(String[] args) {
        System.out.println(validIp("172.16.254.1"));
        System.out.println(validIp("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(validIp("2001:0db8:85a3:00:0:8A2E:0370:7334"));
        System.out.println(validIp("256.256.256.256"));
    }

    /**
     * 验证ip地址
     *
     * @param ip ip
     * @return 判断ip是IPv4或IPv6或者都不是Neither
     */
    private static String validIp(String ip) {
        if (ip.contains(".")) {
            return isIpv4(ip) ? "IPv4" : "Neither";
        } else if (ip.contains(":")) {
            return isIpv6(ip) ? "IPv6" : "Neither";
        } else {
            return "Neither";
        }
    }

    private static boolean isIpv4(String ip) {
        //获取分隔符数
        if (getSeparator(ip, '.') != 3) {
            return false;
        }
        String[] split = ip.split("\\.");
        if (split.length != 4) {
            return false;
        }
        for (String s : split) {
            try {
                int parseInt = Integer.parseInt(s);
                if (parseInt > 255 || parseInt < 0) {
                    return false;
                }
                if (parseInt != 0) {
                    // 不为0，但是0开头，错误
                    if (s.charAt(0) == '0') {
                        return false;
                    }
                } else {
                    // 为0，但是有不止一个0，错误
                    if (s.length() != 1) {
                        return false;
                    }
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    private static boolean isIpv6(String ip) {
        //获取分隔符数
        if (getSeparator(ip, ':') != 7) {
            return false;
        }
        String[] split = ip.split(":");
        if (split.length != 8) {
            return false;
        }
        for (String s : split) {
            // 是否有无效的字符
            if (hasInvalidIpV6char(s)) {
                return false;
            }
            try {
                int parseInt = Integer.parseInt(s, 16);
                if (parseInt < 0) {
                    return false;
                }
                if (parseInt == 0) {
                    // 为0，但是有不止一个0，错误
                    if (s.length() != 1) {
                        return false;
                    }
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasInvalidIpV6char(String s) {
        List<Character> ipV6CharSet = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f', 'A', 'B', 'C', 'D', 'E', 'F');
        for (char c : s.toCharArray()) {
            if (!ipV6CharSet.contains(c)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 统计分隔符数量
     *
     * @param str       字符串
     * @param separator 分隔符
     * @return 数量
     */
    private static int getSeparator(String str, char separator) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == separator) {
                count++;
            }
        }
        return count;
    }


}
