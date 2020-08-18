package leetcode2;

public class LeetCode121 {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(buyStock(arr));
        System.out.println(buyStock2(arr));
        arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(buyStock3(arr));
        arr = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(buyStock3(arr));
        arr = new int[]{7, 6, 4, 3, 1};
        System.out.println(buyStock3(arr));
    }

    /**
     * 买卖股票的最佳时机.
     * <p>只允许完成一笔交易</p>
     * <p>必须在再次购买前出售之前的股票</p>
     *
     * @param arr 股票按日价格数组
     * @return 最大利润
     */
    private static int buyStock(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int buy = arr[0];
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            if (value < buy) {
                buy = value;
            } else {
                max = Math.max(max, value - buy);
            }
        }
        return max;
    }

    /**
     * 买卖股票的最佳时机2.
     * <p>允许同一笔股票多次交易</p>
     * <p>必须在再次购买前出售之前的股票</p>
     *
     * @param arr 股票按日价格数组
     * @return 最大利润
     */
    private static int buyStock2(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] > arr[i]) {
                max += (arr[i + 1] - arr[i]);
            }
        }
        return max;
    }

    /**
     * 买卖股票的最佳时机3.
     * <p>允许同一笔股票最多两次交易</p>
     * <p>必须在再次购买前出售之前的股票</p>
     *
     * @param arr 股票按日价格数组
     * @return 最大利润
     */
    private static int buyStock3(int[] arr) {
        int max1 = 0;
        int max2 = 0;
        int buy = arr[0];
        for (int i = 1; i < arr.length; i++) {
            // 判断一下下一天
            if (i + 1 < arr.length) {
                // 如果下一天价格并今天还高，今天可不是一个适合出售的日期
                // arr[i] > buy 用于判断是否已经购买
                if (arr[i + 1] > arr[i] && arr[i] > buy) {
                    continue;
                }
            }
            int value = arr[i];
            if (value <= buy) {
                buy = value;
            } else {
                max2 = Math.max(max1, max2);
                max1 = Math.max(max1, value - buy);
                buy = Integer.MAX_VALUE;
            }
        }
        return max2 + max1;
    }
}
