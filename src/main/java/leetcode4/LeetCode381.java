package leetcode4;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LeetCode381 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.insert(1));
        System.out.println(solution.insert(1));
        System.out.println(solution.insert(2));
        System.out.println(solution.getRandom());
        System.out.println(solution.remove(1));
        System.out.println(solution.getRandom());
        System.out.println(solution.remove(2));
        System.out.println(solution.getRandom());
    }

    /**
     * O(1)时间插入，删除，和随机获取元素，元素允许重复
     */
    private static class Solution {
        Map<Integer, Integer> forwardMap;
        Map<Integer, Integer> reverseMap;
        int index;
        Random random;

        Solution() {
            forwardMap = new HashMap<>();
            reverseMap = new HashMap<>();
            index = 0;
            random = new Random();
        }

        boolean insert(int val) {
            boolean contains = reverseMap.containsValue(val);
            forwardMap.put(val, index);
            reverseMap.put(index, val);
            index++;
            return contains;
        }

        boolean remove(int val) {
            boolean contains;
            if (reverseMap.containsValue(val)) {
                contains = true;
                if (forwardMap.containsKey(val)) {
                    int i = forwardMap.get(val);
                    forwardMap.remove(val);
                    reverseMap.remove(i);
                } else {
                    reverseMap.values().remove(val);
                }
            } else {
                contains = false;
            }
            return contains;
        }

        int getRandom() {
            int nextInt = random.nextInt(index);
            while (!reverseMap.containsKey(nextInt)) {
                nextInt = random.nextInt(index);
            }
            return reverseMap.get(nextInt);
        }
    }
}
