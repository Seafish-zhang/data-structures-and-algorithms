package leetcode;

public class LeetCode80 {

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 1, 2, 2, 3, 3};
        int length = removeDuplicate(arr);
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }

    /**
     * 去除重复二次以上数字，即 0，0，0 才需要去除一个0
     *
     * @param arr 排好序的数组
     * @return 返回有效长度
     */
    private static int removeDuplicate(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return n;
        }
        //当前字符出现次数
        int count = 1;
        // 有效长度坐标
        int len = 0;
        // 从坐标1开始遍历，因为要第一步比较当前有效位
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[len]) {
                if (count < 2) {
                    count++;
                    arr[++len] = arr[i];
                }
            } else {
                count = 1;
                arr[++len] = arr[i];
            }
        }
        return len + 1;
    }
}
