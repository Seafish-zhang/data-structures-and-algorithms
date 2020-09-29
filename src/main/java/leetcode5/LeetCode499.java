package leetcode5;

public class LeetCode499 {

    private static int minStep;
    private static String minPath;
    private static int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        minStepAndDictOrder(new int[][]{
                {0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 1, 0, 0, 0}
        }, new int[]{4, 3}, new int[]{0, 1});
        System.out.println(minPath);
        System.out.println(minStep);
    }

    /**
     * 迷宫Ⅲ
     * <p>返回滚球到达目标点最小步数行程路径字典顺序最小的的路径</p>
     *
     * @param matrix      迷宫
     * @param start       球开始位置
     * @param destination 目标点
     */
    private static void minStepAndDictOrder(int[][] matrix, int[] start, int[] destination) {
        minStep = Integer.MAX_VALUE;
        minPath = "impossible";
        int[][] visit = new int[matrix.length][matrix[0].length];
        dfs(matrix, start, destination, visit, "", 0);
    }

    private static void dfs(int[][] matrix, int[] start, int[] destination, int[][] visit, String path, int step) {

        if (step > minStep) {
            // 超过可到达的最小步数，不必要再深入
            return;
        }
        // 如果当前位置在目标点，直接返回正确
        if (start[0] == destination[0] && start[1] == destination[1]) {
            if (step < minStep) {
                minStep = step;
                minPath = path;
            } else {
                if (minPath.compareTo(path) > 0) {
                    minPath = path;
                }
            }
            return;
        }

        if (visit[start[0]][start[1]] != 0 && step >= visit[start[0]][start[1]]) {
            // 有访问过且当前到达此处位置需要的步数更多，直接返回
            return;
        }
        // 避免重复访问
        visit[start[0]][start[1]] = step;
        // 否则，则从四个方向判断
        for (int i = 0; i < 4; i++) {
            int[] dir = direction[i];
            int[] nextStart = getNext(matrix, start, dir, destination);
            int currentStep = (i == 0 || i == 1) ?
                    Math.abs(start[1] - nextStart[1]) : Math.abs(start[0] - nextStart[0]);
            if (nextStart[0] == start[0] && nextStart[1] == start[1]) {
                continue;
            }
            String newPath = path + (i == 0 ? "r" : (i == 1 ? "l" : (i == 2 ? "d" : "u")));
            dfs(matrix, nextStart, destination, visit, newPath, step + currentStep);
        }
    }

    private static int[] getNext(int[][] matrix, int[] start, int[] dir, int[] destination) {
        // 下一个小步位置
        int[] nextStep = new int[]{start[0] + dir[0], start[1] + dir[1]};
        if (nextStep[0] == destination[0] && nextStep[1] == destination[1]) {
            return destination;
        }
        // 如果下一步超出矩阵外或者是墙体（1），则不可通行
        if (nextStep[0] < 0 || nextStep[0] >= matrix.length
                || nextStep[1] < 0 || nextStep[1] >= matrix[0].length
                || matrix[nextStep[0]][nextStep[1]] == 1) {
            return start;
        }
        // 同一个方向继续走下去
        return getNext(matrix, nextStep, dir, destination);
    }
}
