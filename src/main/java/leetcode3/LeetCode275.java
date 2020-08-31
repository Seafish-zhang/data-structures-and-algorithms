package leetcode3;

import java.util.Arrays;

public class LeetCode275 {

    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(hIndex(new int[]{0, 1, 3, 5, 6}));
        System.out.println(hIndex(new int[]{7, 0, 6, 1, 5, 4}));
    }

    /**
     * H指数
     * <p>h指数表示 N 篇论文中，至多有h篇论文, 分别被引用了至少h次,其余的N-h篇论文引用次数少于h次</p>
     *
     * @param citations 论文被引用次数数组
     * @return h指数
     */
    private static int hIndex(int[] citations) {
        int result = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= (citations.length - i)) {
                result = Math.max(result, citations.length - i);
            }
        }
        return result;
    }
}
