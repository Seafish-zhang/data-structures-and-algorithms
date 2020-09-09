package leetcode4;

import java.util.ArrayList;
import java.util.List;

public class LeetCode322 {

    public static void main(String[] args) {
        List<Integer> list = minUse(new int[]{1, 2, 5}, 11);
        System.out.println(list.isEmpty() ? -1 : list.size());
        list = minUse(new int[]{2}, 3);
        System.out.println(list.isEmpty() ? -1 : list.size());
    }


    /**
     * 零钱兑换
     * <p>使面额amount的金额换算成coins中硬币的最少个数</p>
     *
     * @param coins  硬币数组
     * @param amount 换算面额
     * @return 最少硬币数组成列表
     */
    private static List<Integer> minUse(int[] coins, int amount) {
        List<Integer> result = new ArrayList<>();
        List<Integer> single = new ArrayList<>();
        match(result, coins, amount, 0, single);
        return result;
    }

    private static void match(List<Integer> result, int[] coins, int amount, int current, List<Integer> single) {
        if (current > amount) {
            return;
        } else if (current == amount) {
            if (result.isEmpty() || single.size() < result.size()) {
                result.clear();
                result.addAll(new ArrayList<>(single));
            }
            return;
        }
        for (int coin : coins) {
            single.add(coin);
            match(result, coins, amount, current + coin, single);
            single.remove(single.size() - 1);
        }
    }
}
