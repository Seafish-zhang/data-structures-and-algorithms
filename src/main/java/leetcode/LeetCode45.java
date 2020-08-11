package leetcode;

public class LeetCode45 {

    public static void main(String[] args) {
        System.out.println(lastStepArrive(new int[]{1, 2, 1, 3, 0, 1, 4, 1, 1}));
    }

    private static int lastStepArrive(int[] array) {
        int step = 0;
        //记录上一步能达到的最远距离
        int lastFarthest = 0;
        int farthest = array[0];

        for (int i = 0; i < array.length - 1; i++) {
            //只能到达farthest范围内
            if (i <= farthest) {
                if (array[i] + i > farthest) {
                    farthest = array[i] + i;
                }

                if (i == lastFarthest) {
                    lastFarthest = farthest;
                    step++;
                }
            }
        }
        return step;
    }
}
