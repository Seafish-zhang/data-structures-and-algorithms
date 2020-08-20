package leetcode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode146 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    private static class LRUCache {
        int capacity;
        List<Integer> keyList;
        Map<Integer, Integer> cache;

        LRUCache(int capacity) {
            this.capacity = capacity;
            this.keyList = new ArrayList<>(capacity);
            this.cache = new HashMap<>(capacity);
        }

        private int get(int key) {
            int value = -1;
            if (cache.containsKey(key)) {
                value = cache.get(key);
                // 每次使用都将改缓存放到列表最后
                keyList.remove((Integer) key);
                keyList.add(key);
            }
            return value;
        }

        private void put(int key, int value) {
            if (cache.containsKey(key)) {
                // 每次使用都将改缓存放到列表最后
                keyList.remove((Integer) key);
            } else {
                // 新增
                if (keyList.size() == capacity) {
                    // 如果已经满了，删除
                    Integer remove = keyList.remove(0);
                    cache.remove(remove);
                }
            }
            //已存在，更新
            cache.put(key, value);
            keyList.add(key);
        }
    }
}
