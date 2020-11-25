package main.java.com.study.leetCode.binarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author： whb
 * @description： LeetCode-981-基于时间的键值存储
 * @date： 2020-11-25 14:05
 * 难度：中等
 * 标签：哈希表、二分查找
 * 创建一个基于时间的键值存储类 TimeMap，它支持下面两个操作：
 *
 * 1. set(string key, string value, int timestamp)
 *
 * 存储键 key、值 value，以及给定的时间戳 timestamp。
 * 2. get(string key, int timestamp)
 *
 * 返回先前调用 set(key, value, timestamp_prev) 所存储的值，其中 timestamp_prev <= timestamp。
 * 如果有多个这样的值，则返回对应最大的  timestamp_prev 的那个值。
 * 如果没有值，则返回空字符串（""）。
 *
 *
 * 示例 1：
 *
 * 输入：inputs = ["TimeMap","set","get","get","set","get","get"], inputs = [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
 * 输出：[null,null,"bar","bar",null,"bar2","bar2"]
 * 解释：
 * TimeMap kv;
 * kv.set("foo", "bar", 1); // 存储键 "foo" 和值 "bar" 以及时间戳 timestamp = 1
 * kv.get("foo", 1);  // 输出 "bar"
 * kv.get("foo", 3); // 输出 "bar" 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯一的值位于时间戳 1 处（即 "bar"）
 * kv.set("foo", "bar2", 4);
 * kv.get("foo", 4); // 输出 "bar2"
 * kv.get("foo", 5); // 输出 "bar2"
 *
 * 示例 2：
 *
 * 输入：inputs = ["TimeMap","set","set","get","get","get","get","get"], inputs = [[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]
 * 输出：[null,null,null,"","high","high","low","low"]
 *
 *
 * 提示：
 * 所有的键/值字符串都是小写的。
 * 所有的键/值字符串长度都在 [1, 100] 范围内。
 * 所有 TimeMap.set 操作中的时间戳 timestamps 都是严格递增的。
 * 1 <= timestamp <= 10^7
 * TimeMap.set 和 TimeMap.get 函数在每个测试用例中将（组合）调用总计 120000 次。
 */
public class TimeMap {
    private Map<String, List<Integer>> keyToTime;
    private Map<Integer, String> timeToVal;

    public TimeMap() {
        this.keyToTime = new HashMap<>();
        this.timeToVal = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!keyToTime.containsKey(key)) {
            keyToTime.put(key, new ArrayList<>());
        }
        keyToTime.get(key).add(timestamp);
        timeToVal.put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!keyToTime.containsKey(key)) {
            return "";
        }
        List<Integer> timeList = keyToTime.get(key);
        Integer time = getTimeStamp(timeList, timestamp);
        return timeToVal.getOrDefault(time, "");
    }

    private Integer getTimeStamp(List<Integer> timeList, int timestamp) {
        if (timeList == null || timeList.isEmpty()) {
            return null;
        }
        int left = 0, right = timeList.size() - 1, res = -1;
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (timeList.get(middle) <= timestamp) {
                res = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return res == -1 ? null : timeList.get(res);
    }

    public static void main(String[] args) {
        TimeMap kv = new TimeMap();
        // 存储键 "foo" 和值 "bar" 以及时间戳 timestamp = 1
        kv.set("foo", "bar", 1);
        // 输出 "bar"
        System.out.println(kv.get("foo", 1));
        // 输出 "bar" 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯一的值位于时间戳 1 处（即 "bar"）
        System.out.println(kv.get("foo", 3));
        kv.set("foo", "bar2", 4);
        // 输出 "bar2"
        System.out.println(kv.get("foo", 4));
        // 输出 "bar2"
        System.out.println(kv.get("foo", 5));

        kv = new TimeMap();
        kv.set("love", "high", 10);
        kv.set("love", "low", 20);
        System.out.println(kv.get("love", 5));
        System.out.println(kv.get("love", 10));
        System.out.println(kv.get("love", 15));
        System.out.println(kv.get("love", 20));
        System.out.println(kv.get("love", 25));
    }
}
