package main.java.com.study.leetCode.sort;

import java.util.*;

/**
 * @author: whb
 * @date: 2019/10/15 10:01
 * @description: 出现频率最多的K个元素
 * 示例：Given [1,1,1,2,2,3] and k = 2, return [1,2]
 * 解题思路：设置若干个桶，每个桶存储出现频率相同的数，桶的下标表示数出现的频率，即第i个桶中存储的数出现的频率为i。
 * 把数都放在桶之后，从后向前遍历桶，最先得到的k个数就是出现频率最多的k个数。
 */
public class TopKFrequentElements {

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

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3, 4};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k).toArray()));
    }
}
