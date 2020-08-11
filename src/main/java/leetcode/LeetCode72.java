package leetcode;

public class LeetCode72 {

    public static void main(String[] args) {
        changeStepCount("horse", "ros");
        System.out.println(minStep);
        minStep = Integer.MAX_VALUE;
        changeStepCount("zhy", "colin");
        System.out.println(minStep);
    }

    //最小步数
    private static int minStep = Integer.MAX_VALUE;

    private static void changeStepCount(String fromStr, String toStr) {
        char[] fromCharArray = fromStr.toCharArray();
        char[] toCharArray = toStr.toCharArray();
        match(fromCharArray, toCharArray, 0, 0, 0);
    }

    private static void match(char[] fromCharArray, char[] toCharArray, int from, int to, int step) {
        //递归终止条件
        if (from == fromCharArray.length || to == toCharArray.length) {
            // from用完, 添加
            if (toCharArray.length > to) {
                step += (toCharArray.length - to);
            }
            // to用完, 删除
            if (fromCharArray.length > from) {
                step += (fromCharArray.length - from);
            }
            minStep = Math.min(step, minStep);
        } else {
            //巧妙的遍历
            if (fromCharArray[from] == toCharArray[to]) {
                match(fromCharArray, toCharArray, from + 1, to + 1, step);
            } else {
                // 添加
                match(fromCharArray, toCharArray, from, to + 1, step + 1);
                // 删除
                match(fromCharArray, toCharArray, from + 1, to, step + 1);
                // 替换
                match(fromCharArray, toCharArray, from + 1, to + 1, step + 1);

            }
        }
    }
}
