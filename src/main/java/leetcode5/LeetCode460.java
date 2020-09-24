package leetcode5;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LeetCode460 {

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.get(3);
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    /**
     * LFU缓存（最不经常使用）
     */
    private static class LFUCache {
        HashMap<Integer, Integer> keyToValue;
        HashMap<Integer, Integer> keyToCount;
        HashMap<Integer, LinkedHashSet<Integer>> countToLRUKeys;
        int capacity;
        int minimumCount;

        LFUCache(int capacity) {
            this.minimumCount = -1;
            this.capacity = capacity;
            this.keyToCount = new HashMap<>();
            this.keyToValue = new HashMap<>();
            this.countToLRUKeys = new HashMap<>();
            this.countToLRUKeys.put(1, new LinkedHashSet<>());
        }

        int get(int key) {
            if (!keyToValue.containsKey(key)) {
                return -1;
            }
            int count = keyToCount.get(key);
            keyToCount.put(key, count + 1);
            countToLRUKeys.get(count).remove(key);
            if (count == minimumCount && countToLRUKeys.get(count).size() == 0) {
                minimumCount++;
            }
            if (!countToLRUKeys.containsKey(count + 1)) {
                countToLRUKeys.put(count + 1, new LinkedHashSet<>());
            }
            countToLRUKeys.get(count + 1).add(key);
            return keyToValue.get(key);
        }

        void put(int key, int value) {
            if (capacity <= 0) {
                return;
            }
            if (keyToValue.containsKey(key)) {
                keyToValue.put(key, value);
                get(key);
                return;
            }
            if (keyToValue.size() >= capacity) {
                int expire = countToLRUKeys.get(minimumCount).iterator().next();
                countToLRUKeys.get(minimumCount).remove(expire);
                keyToValue.remove(expire);
            }
            keyToValue.put(key, value);
            keyToCount.put(key, 1);
            countToLRUKeys.get(1).add(key);
            minimumCount = 1;
        }

    }
}
