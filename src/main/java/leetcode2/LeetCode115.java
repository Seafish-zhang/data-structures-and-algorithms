package leetcode2;

import java.util.ArrayList;
import java.util.List;

public class LeetCode115 {

    public static void main(String[] args) {
        System.out.println(matchSubSequence("rabbbit", "rabbit").size());
        System.out.println(matchSubSequence("babgbag", "bag").size());
    }

    /**
     * 源字符串中匹配目标字符串的子序列
     * <p>只能通过删除一些字符且不干扰剩余字符相对位置所组成的新字符串</p>
     * <p>"ACE"是"ABCDE"的子序列，而"AEC"不是</p>
     *
     * @param str    源字符串
     * @param target 目标字符串
     * @return 所有匹配的结果
     */
    private static List<List<String>> matchSubSequence(String str, String target) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        subSequence(str, target, result, current, 0, 0);
        return result;
    }

    private static void subSequence(String str, String target, List<List<String>> result,
                                    List<String> current, int s, int t) {

        if (t == target.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (s < str.length()) {
            for (int i = s; i < str.length(); i++) {
                // 匹配成功
                if (str.charAt(i) == target.charAt(t)) {
                    current.add(str.charAt(i) + "");
                    subSequence(str, target, result, current, i + 1, t + 1);
                    current.remove(current.size() - 1);
                }
            }
        }
    }
}
