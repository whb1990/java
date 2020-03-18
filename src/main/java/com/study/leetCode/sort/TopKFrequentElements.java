package main.java.com.study.leetCode.sort;

import java.util.*;

/**
 * @author: whb
 * @date: 2019/10/15 10:01
 * @description: LeetCode-247-出现频率最多的K个元素
 * 题目描述：给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
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
    public static List<Integer> topKFrequent(int[] nums, int k) {
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
        return topK;
    }

    /**
     * 构建最小堆的形式
     *
     * @param nums
     * @param k
     * @return
     */
    public static List<Integer> topKFrequent2(int[] nums, int k) {
        //统计每个元素出现的频次
        Map<Integer, Integer> frenquencyMap = new HashMap<>();
        for (int tmp : nums) {
            frenquencyMap.put(tmp, frenquencyMap.getOrDefault(tmp, 0) + 1);
        }
        //构建小顶堆，维持在k个元素
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> {
            return frenquencyMap.get(b) - frenquencyMap.get(a);
        });
        for (Integer key : frenquencyMap.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(key);
            } else if (frenquencyMap.get(key) > frenquencyMap.get(priorityQueue.peek())) {
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }
        //输出结果
        List<Integer> result = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            result.add(priorityQueue.remove());
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3, 4};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent2(nums, k).toArray()));
    }
}
