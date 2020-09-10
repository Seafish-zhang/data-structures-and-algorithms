package leetcode4;

public class LeetCode331 {

    public static void main(String[] args) {
        System.out.println(vaildPrevOrder("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(vaildPrevOrder("1,#"));
        System.out.println(vaildPrevOrder("9,#,#,1"));
    }

    /**
     * 验证二叉树的前序序列化是否正确
     * <p>用“#”记录空节点值</p>
     *
     * @param str 序列化字符串
     * @return 结果
     */
    private static boolean vaildPrevOrder(String str) {
        String[] split = str.split(",");
        int diff = 1;
        for (String s : split) {
            if (diff < 0) {
                return false;
            }
            diff--;
            if (!"#".equals(s)) {
                diff += 2;
            }
        }
        return diff == 0;
    }
}
