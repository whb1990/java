package main.java.com.study.leetCode.sort;

import com.google.common.primitives.Ints;

import java.util.*;

/**
 * @author: whb
 * @date: 2019/10/15 10:01
 * @description: LeetCode-347-出现频率最多的K个元素
 * 难度：中等
 * 标签：堆、哈希表
 * 题目描述：给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * <p>
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 * <p>
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 解题思路：设置若干个桶，每个桶存储出现频率相同的数，桶的下标表示数出现的频率，即第i个桶中存储的数出现的频率为i。
 * 把数都放在桶之后，从后向前遍历桶，最先得到的k个数就是出现频率最多的k个数。
 */
public class TopKFrequentElements {

    /**
     * 使用桶排序的方式
     * 设置若干个桶，每个桶存储出现频率相同的数。桶的下标表示数出现的频率，即第 i 个桶中存储的数出现的频率为 i。
     * <p>
     * 把数都放到桶之后，从后向前遍历桶，最先得到的 k 个数就是出现频率最多的的 k 个数。
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) {
            return new int[0];
        }
        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int num : nums) {
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : frequencyForNum.keySet()) {
            int frequency = frequencyForNum.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            }
            if (buckets[i].size() <= (k - topK.size())) {
                topK.addAll(buckets[i]);
            } else {
                topK.addAll(buckets[i].subList(0, k - topK.size()));
            }
        }
        return Ints.toArray(topK);
    }

    /**
     * 构建最小堆的形式
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent2(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (Integer key : map.keySet()) {
            queue.offer(key);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] res = new int[k];
        while (!queue.isEmpty()) {
            res[--k] = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 1, 2, 2, 3, 4}, 2)));
        System.out.println(Arrays.toString(topKFrequent2(new int[]{1, 1, 1, 1, 2, 2, 3, 4}, 2)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequent2(new int[]{4, 1, -1, 2, -1, 2, 3}, 2)));
    }
}
