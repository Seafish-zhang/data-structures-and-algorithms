package leetcode2;

import java.util.HashMap;
import java.util.Map;

public class LeetCode128 {

    public static void main(String[] args) {
        System.out.println(longestSequence(new int[]{100, 4, 200, 1, 3, 2, 5}));
        System.out.println(longestSequence(new int[]{1, 3, 2, 5, 6}));
    }

    /**
     * 最长连续序列.
     * <p>例如数组{1,3,2,5,6}，最大长度是3，即：1-2-3 </p>
     *
     * @param arr 未排序整数数组
     * @return 长度
     */
    private static int longestSequence(int[] arr) {
        // 记录值与对应坐标
        Map<Integer, Integer> map = new HashMap<>();
        UnionFind unionFind = new UnionFind(arr);
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                continue;
            }
            map.put(arr[i], i);
            if (map.containsKey(arr[i] - 1)) {
                // 两值相连合并,使其在UF中对应的坐标的值置为相连存在的坐标值,是当前的关联到前一个值
                // 例如： 数组{1,3,2}，对应的uf开始为{0,1,2}，
                // 遍历到“2”时，有前面已经有相连的值“1”，然后做union操作，使“2”的uf中find的坐标中的值置为“1”find的坐标
                // 即uf变为{0,1,0}
                unionFind.union(i, map.get(arr[i] - 1));
            }
            if (map.containsKey(arr[i] + 1)) {
                // 遍历到“2”时，有前面已经有相连的值“3”，然后做union操作，使“3”的uf中find的坐标中的值置为“2”find的坐标
                // 上一步已经把“2”的find坐标置为 0，则 “3”的find的坐标是初始的 1
                // 即uf变为{0,0,0}
                unionFind.union(map.get(arr[i] + 1), i);
            }
        }
        return unionFind.maxUnion();
    }

    static class UnionFind {
        int[] ids;

        private UnionFind(int[] nums) {
            ids = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                ids[i] = i;
            }
        }

        private void union(int i, int j) {
            int x = find(ids, i);
            int y = find(ids, j);
            ids[x] = y;
        }

        private int find(int[] ids, int i) {
            while (i != ids[i]) {
                ids[i] = ids[ids[i]];
                i = ids[i];
            }
            return i;
        }

        //        public boolean connected(int i, int j) {
        //            return find(ids, i) == find(ids, j);
        //        }

        private int maxUnion() {
            int max = 0;
            int[] count = new int[ids.length];
            for (int i = 0; i < ids.length; i++) {
                count[find(ids, i)]++;
                max = Math.max(max, count[find(ids, i)]);
            }
            return max;
        }
    }
}
