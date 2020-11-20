package main.java.com.study.leetCode.design;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author： whb
 * @description： LeetCode-460-LFU缓存
 * @date： 2020-11-20 19:06
 * 难度：困难
 * 标签：设计
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
 *
 * 实现 LFUCache 类：
 *
 * LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
 * int get(int key) - 如果键存在于缓存中，则获取键的值，否则返回 -1。
 * void put(int key, int value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最久未使用 的键。
 * 注意「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
 *
 *
 *
 * 进阶：
 *
 * 你是否可以在 O(1) 时间复杂度内执行两项操作？
 *
 *
 * 示例：
 *
 * 输入：
 * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 * 输出：
 * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 *
 * 解释：
 * LFUCache lFUCache = new LFUCache(2);
 * lFUCache.put(1, 1);
 * lFUCache.put(2, 2);
 * lFUCache.get(1);      // 返回 1
 * lFUCache.put(3, 3);   // 去除键 2
 * lFUCache.get(2);      // 返回 -1（未找到）
 * lFUCache.get(3);      // 返回 3
 * lFUCache.put(4, 4);   // 去除键 1
 * lFUCache.get(1);      // 返回 -1（未找到）
 * lFUCache.get(3);      // 返回 3
 * lFUCache.get(4);      // 返回 4
 *
 *
 * 提示：
 *
 * 0 <= capacity, key, value <= 104
 * 最多调用 105 次 get 和 put 方法
 */
public class LFUCache {
    /**
     * key 到 val 的映射
     */
    private Map<Integer, Integer> keyToVal;
    /**
     * key 到 freq 的映射
     */
    private Map<Integer, Integer> keyToFreq;
    /**
     * freq 到key 列表的映射
     */
    private Map<Integer, LinkedHashSet<Integer>> freqToKeys;
    /**
     * 记录最小的频次
     */
    private int minFreq;
    /**
     * 记录 LFU 缓存的最大容量
     */
    private int cap;

    public LFUCache(int capacity) {
        this.keyToVal = new HashMap<>();
        this.keyToFreq = new HashMap<>();
        this.freqToKeys = new HashMap<>();
        this.minFreq = 0;
        this.cap = capacity;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        //增加 key 对应的 freq
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (this.cap <= 0) {
            return;
        }
        //若 key 已存在，修改对应的val
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            //key 对应的 freq 加一
            increaseFreq(key);
            return;
        }
        //若 key 不存在，需要新插入
        //若容量已满需要淘汰一个 freq 最小的 key
        if (this.cap <= keyToVal.size()) {
            removeMinFreqKey();
        }
        //插入 key 和 value，对应的 freq 加 1
        //插入 KV 表
        keyToVal.put(key, value);
        //插入 KF 表
        keyToFreq.put(key, 1);
        //插入 FK 表
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        //插入新 key 后最小的 freq 肯定是 1
        this.minFreq = 1;
    }

    private void removeMinFreqKey() {
        //freq 最小的 key 列表
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        //其中最先被插入的那个key就是该被淘汰的key
        int deletedKey = keyList.iterator().next();
        //更新 FK 表
        keyList.remove(deletedKey);
        if (keyList.isEmpty()) {
            freqToKeys.remove(this.minFreq);
        }
        //更新 KV 表
        keyToVal.remove(deletedKey);
        //更新 KF 表
        keyToFreq.remove(deletedKey);
    }

    private void increaseFreq(int key) {
        //获取频次
        int freq = keyToFreq.get(key);
        //更新 FK 表
        keyToFreq.put(key, freq + 1);
        //将 key 从 freq 对应的列表中删除
        freqToKeys.get(freq).remove(key);
        //将 key 加入 freq + 1 对应的列表中
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);
        //如果 freq 对应的列表空了，移除这个 freq
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            //如果这个 freq 正好是 minFreq，则更新 minFreq
            if (freq == minFreq) {
                minFreq++;
            }
        }
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        // 返回 1
        System.out.println(lfuCache.get(1));
        // 去除键 2
        lfuCache.put(3, 3);
        // 返回 -1（未找到）
        System.out.println(lfuCache.get(2));
        // 返回 3
        System.out.println(lfuCache.get(3));
        // 去除键 1
        lfuCache.put(4, 4);
        // 返回 -1（未找到）
        System.out.println(lfuCache.get(1));
        // 返回 3
        System.out.println(lfuCache.get(3));
        // 返回 4
        System.out.println(lfuCache.get(4));
    }
}
