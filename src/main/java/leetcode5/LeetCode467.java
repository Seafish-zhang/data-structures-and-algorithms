package leetcode5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode467 {

    private static final String S = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        List<String> result = matchSubStr("a");
        result.forEach(System.out::println);
        System.out.println("===========================");
        result = matchSubStr("cac");
        result.forEach(System.out::println);
        System.out.println("===========================");
        result = matchSubStr("zab");
        result.forEach(System.out::println);
    }

    /**
     * 环绕字符串中唯一的子字符串
     * <p>S是二十六个字母的环形字符串，即xyz后面自动跟上abcd</p>
     * <p>判断字符串p的所有子串包括自己，是否为S的子串</p>
     *
     * @param p p
     * @return 符合子串的集合
     */
    private static List<String> matchSubStr(String p) {
        Set<String> subStr = new HashSet<>(getAllSubStr(p));
        List<String> result = new ArrayList<>();
        for (String s : subStr) {
            String newStr = S + S.substring(0, s.length());
            if (newStr.contains(s)) {
                result.add(s);
            }
        }
        return result;
    }

    private static List<String> getAllSubStr(String p) {
        List<String> subList = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            for (int j = i; j <= p.length(); j++) {
                subList.add(p.substring(i, j));
            }
        }
        return subList;
    }
}
