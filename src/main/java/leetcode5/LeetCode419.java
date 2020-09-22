package leetcode5;

public class LeetCode419 {

    public static void main(String[] args) {
        System.out.println(strongPasswordChecker("abcdefg"));
        System.out.println(strongPasswordChecker("aaa"));
        System.out.println(strongPasswordChecker("aA1bB2Cc3"));
    }

    /**
     * 强密码校验器
     * <p>密码条件：</p>
     * <p>至少6个,至多20个字符组成</p>
     * <p>至少包含一个小写字母，一个大写字母和一个数字</p>
     * <p>同一个字符不能连续出现三次</p>
     * <p>返回变成强密码需要几步修改，修改包括：插入，删除，替换</p>
     *
     * @param s 校验的密码
     * @return 返回需要修改的次数
     */
    private static int strongPasswordChecker(String s) {
        int res = 0;
        int a = 1;
        int A = 1;
        int d = 1;
        char[] charArray = s.toCharArray();
        int[] arr = new int[charArray.length];

        for (int i = 0; i < arr.length; ) {
            if (a > 0 && Character.isLowerCase(charArray[i])) {
                a = 0;
            }
            if (A > 0 && Character.isUpperCase(charArray[i])) {
                A = 0;
            }
            if (d > 0 && Character.isDigit(charArray[i])) {
                d = 0;
            }
            int j = i;
            while (i < charArray.length && charArray[i] == charArray[j]) {
                i++;
            }
            arr[j] = i - j;
        }

        int totalMissing = a + A + d;

        if (arr.length < 6) {
            res += totalMissing + Math.max(0, 6 - (arr.length + totalMissing));
        } else {
            int overLen = Math.max(arr.length - 20, 0);
            int leftOver = 0;
            res += overLen;
            for (int k = 1; k < 3; k++) {
                for (int i = 0; i < arr.length && overLen > 0; i++) {
                    if (arr[i] < 3 || arr[i] % 3 != (k - 1)) {
                        continue;
                    }
                    arr[i] -= Math.min(overLen, k);
                    overLen -= k;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 3 && overLen > 0) {
                    int need = arr[i] - 2;
                    arr[i] -= overLen;
                    overLen -= need;
                }
                if (arr[i] >= 3) {
                    leftOver += arr[i] / 3;
                }
            }
            res += Math.max(totalMissing, leftOver);
        }
        return res;
    }
}
