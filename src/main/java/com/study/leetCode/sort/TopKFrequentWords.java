package main.java.com.study.leetCode.sort;

import java.util.*;

/**
 * @author： whb
 * @description： LeetCode-692-前K个高频单词
 * @date： 2020-11-03 15:54
 * 难度：中等
 * 堆、字典树、哈希表
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * <p>
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * <p>
 * 示例 1：
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 * <p>
 * <p>
 * 示例 2：
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 * 出现次数依次为 4, 3, 2 和 1 次。
 * <p>
 * <p>
 * 注意：
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 */
public class TopKFrequentWords {
    /**
     * 堆排序
     * 计算每个单词的频率，然后将其添加到存储到大小为 k 的小根堆中。它将频率最小的候选项放在堆的顶部。最后，我们从堆中弹出最多 k 次，并反转结果，就可以得到前 k 个高频单词。
     * 时间复杂度： O(Nlogk)。其中 N 是 words 的长度。我们用 O(N) 的时间计算每个单词的频率，然后将 NN 个单词添加到堆中，添加每个单词的时间为 O(logk) 。
     * 最后，我们从堆中弹出最多 k 次。因为 k≤N 的值，总共是 O(Nlogk)。
     * 空间复杂度：O(N)，用于存储我们计数的空间
     *
     * @param words
     * @param k
     * @return
     */
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>((a, b) -> {
            return map.get(a).equals(map.get(b)) ? b.compareTo(a) : map.get(a) - map.get(b);
        });
        for (String word : map.keySet()) {
            queue.offer(word);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(0, queue.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
        System.out.println(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 3));
    }
}
