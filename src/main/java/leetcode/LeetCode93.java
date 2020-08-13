package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode93 {

    public static void main(String[] args) {
        List<String> list = allMaybeIpAddr("25525511135");
        for (String s : list) {
            System.out.println(s);
        }
        list = allMaybeIpAddr("1921681211");
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static List<String> allMaybeIpAddr(String s) {
        List<String> result = new ArrayList<>();
        List<String> single = new ArrayList<>();
        // 老方法，递归
        match(result, single, s, 0);
        return result;
    }

    private static void match(List<String> result, List<String> singleIp, String s, int index) {
        // 递归终止条件
        if (singleIp.size() == 4) {
            if (index == s.length()) {
                // 刚好使用完原字符串
                StringBuilder sb = new StringBuilder();
                for (String ipByte : singleIp) {
                    sb.append(ipByte).append(".");
                }
                String ip = sb.toString();
                result.add(ip.substring(0, ip.length() - 1));
            }
            // 没有使用完原字符串，不符合
        }

        for (int i = index; i < index + 4 && i < s.length(); i++) {
            String ipByte = s.substring(index, i + 1);
            if (isValid(ipByte)) {
                singleIp.add(ipByte);
                match(result, singleIp, s, i + 1);
                singleIp.remove(singleIp.size() - 1);
            }
        }
    }

    private static boolean isValid(String ipByte) {
        Integer integer = Integer.valueOf(ipByte);
        return integer >= 0 && integer <= 255;
    }
}
