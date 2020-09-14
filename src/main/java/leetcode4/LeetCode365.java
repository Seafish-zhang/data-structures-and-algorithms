package leetcode4;

public class LeetCode365 {

    public static void main(String[] args) {
        System.out.println(getRequireWater(3, 5, 4));
        System.out.println(getRequireWater(2, 6, 5));
    }

    /**
     * 水壶问题
     * <p>有两个容量分别为x升和y升，以及无限多的水，目标使两个水壶的装水为z升</p>
     * <p>只有两个水壶，操作有：</p>
     * <p>1、装满任意一个水壶</p>
     * <p>2、清空任意一个水壶</p>
     * <p>3、从一个水壶向另外一个水壶倒水，直到装满或者倒空</p>
     *
     * @param x x
     * @param y y
     * @param z z
     * @return 是否能得到指定的水
     */
    private static boolean getRequireWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == z || y == z || x + y == z) {
            return true;
        }
        // 数学有个定理：
        //  如果 gcd（x,y） = k,gcd函数是计算两个数的最大公约数
        //  那么肯定有整数 m、n、g，使得 mx + ny = gk
        // 所以，问题可以转化为z是否为 gk，即 z % k == 0
        return z % gcd(x, y) == 0;
    }

    private static int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}
