package leetcode2;

public class LeetCode134 {
    public static void main(String[] args) {
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        System.out.println(startPoint(gas, cost));
        gas = new int[]{2, 3, 4};
        cost = new int[]{3, 4, 3};
        System.out.println(startPoint(gas, cost));
    }


    /**
     * 加油站
     * <p>环形道路上有N个加油站gas，开始时车油量为0，每经过一个加油站点消耗汽油为cost</p>
     * <p>算出从哪里开始才可以跑完这条环形道路</p>
     *
     * @param gas  加油站可加油量值
     * @param cost 消耗汽油
     * @return 起始点
     */
    private static int startPoint(int[] gas, int[] cost) {
        int startPoint = -1;
        int remain;

        for (int i = 0; i < gas.length; i++) {
            remain = 0;
            for (int j = i; j < gas.length + i; j++) {
                int index = j >= gas.length ? j - gas.length : j;
                remain += gas[index] - cost[index];
                if (remain < 0) {
                    break;
                }
                if (j == (gas.length + i - 1)) {
                    startPoint = i;
                    return startPoint;
                }
            }
        }
        return startPoint;
    }
}
