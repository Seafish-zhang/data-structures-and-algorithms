package leetcode5;

import java.util.HashMap;
import java.util.Map;

public class LeetCode454 {

    public static void main(String[] args) {
        System.out.println(fourNumSum(
                new int[]{1, 2},
                new int[]{-2, -1},
                new int[]{-1, 2},
                new int[]{0, 2}
        ));
    }


    /**
     * 四数相加Ⅱ
     * <p>给定四个包含整数的数组列表，A，B，C，D,计算有多少个元组（i，j，k，l）</p>
     * <p>使得A[i]+B[j]+C[k]+D[l]=0</p>
     * <p>四个数组长度相同，且整数范围在-2^28到2^28-1之间</p>
     *
     * @param A 数组列表
     * @param B 数组列表
     * @param C 数组列表
     * @param D 数组列表
     * @return 结果数量
     */
    private static int fourNumSum(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, String> sum = new HashMap<>();
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum.put(A[i] + B[j], i + "," + j);
            }
        }
        int count = 0;
        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                int i = -(C[k] + D[l]);
                if (sum.containsKey(i)) {
                    System.out.println(sum.get(i) + "," + k + "," + l);
                    count++;
                }
            }
        }
        return count;
    }
}
