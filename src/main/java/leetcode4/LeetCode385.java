package leetcode4;

public class LeetCode385 {

    public static void main(String[] args) {
        NestedInteger analysis = analysis("324");
        System.out.println(analysis.toString());

        analysis = analysis("[123,[456,[789]]]");
        System.out.println(analysis.toString());

    }

    /**
     * 迷你语法分析器
     *
     * @param s 字符串
     * @return 嵌套整数
     */
    private static NestedInteger analysis(String s) {

        if (s == null || s.length() <= 0) {
            return null;
        }
        // 不是以‘[’开始，没有嵌套，直接返回
        if (s.charAt(0) != '[') {
            try {
                return new NestedInteger(Integer.parseInt(s));
            } catch (Exception e) {
                return null;
            }
        } else {
            NestedInteger result = new NestedInteger();
            int i = 1;
            while (i < s.length() && ((Character.getNumericValue(s.charAt(i)) < 10
                    && Character.getNumericValue(s.charAt(i)) >= 0) || s.charAt(i) == '-')) {
                i++;
            }
            result.value = Integer.parseInt(s.substring(1, i));
            if (s.length() > i + 1) {
                result.nested = analysis(s.substring(i + 1));
            }
            return result;
        }
    }

    private static class NestedInteger {
        private int value;
        private NestedInteger nested;

        NestedInteger() {

        }

        NestedInteger(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(value);
            if (nested != null) {
                sb.append(",").append(nested.toString());
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
