package leetcode5;

public class LeetCode490 {

    private static int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        System.out.println(hasPath(new int[][]{
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        }, new int[]{0, 4}, new int[]{4, 4}));
    }

    /**
     * 迷宫Ⅰ
     * <p>matrix是迷宫矩阵，其中1代表是墙，不可通行，0是通道</p>
     * <p>给出起始坐标数组start和目标坐标数组destination</p>
     * <p>求是否能到达目的地</p>
     *
     * @param matrix      迷宫
     * @param start       起始点
     * @param destination 目标点
     * @return 是否有路径
     */
    private static boolean hasPath(int[][] matrix, int[] start, int[] destination) {
        int[][] visit = new int[matrix.length][matrix[0].length];
        return dfs(matrix, start, destination, visit);
    }

    private static boolean dfs(int[][] matrix, int[] start, int[] destination, int[][] visit) {
        // 如果当前位置在目标点，直接返回正确
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        if (visit[start[0]][start[1]] != 0) {
            // 有访问过,1能到达，-1不能到达
            return visit[start[0]][start[1]] == 1;
        }
        // 避免重复访问
        visit[start[0]][start[1]] = -1;
        boolean current = false;
        // 否则，则从四个方向判断
        for (int i = 0; i < 4; i++) {
            int[] dir = direction[i];
            int[] nextStart = getNext(matrix, start, dir);
            if (nextStart[0] == start[0] && nextStart[1] == start[1]) {
                continue;
            }
            if (dfs(matrix, nextStart, destination, visit)) {
                current = true;
                break;
            }
        }
        // 设定当前位置开始，是否能走到目标点
        visit[start[0]][start[1]] = current ? 1 : -1;
        return current;
    }

    private static int[] getNext(int[][] matrix, int[] start, int[] dir) {
        // 下一个小步位置
        int[] nextStep = new int[]{start[0] + dir[0], start[1] + dir[1]};
        // 如果下一步超出矩阵外或者是墙体（1），则不可通行
        if (nextStep[0] < 0 || nextStep[0] >= matrix.length
                || nextStep[1] < 0 || nextStep[1] >= matrix[0].length
                || matrix[nextStep[0]][nextStep[1]] == 1) {
            return start;
        }
        // 同一个方向继续走下去
        return getNext(matrix, nextStep, dir);
    }
}
