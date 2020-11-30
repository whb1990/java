package main.java.com.study.leetCode.greedyAlgorithm;

import java.util.PriorityQueue;

/**
 * @author： whb
 * @description： LeetCode-767-重构字符串
 * @date： 2020-11-30 9:05
 * 难度：中等
 * 标签：堆、贪心算法、排序、字符串
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 * 输入: S = "aab"
 * 输出: "aba"
 *
 * 示例 2:
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 *
 * S 只包含小写字母并且长度在[1, 500]区间内。
 */
public class ReorganizeString {
    /**
     * 基于最大堆的贪心算法
     *
     * 维护最大堆存储字母，堆顶元素为出现次数最多的字母。首先统计每个字母的出现次数，然后将出现次数大于 0 的字母加入最大堆。
     *
     * 当最大堆的元素个数大于 1 时，每次从最大堆取出两个字母，拼接到重构的字符串，然后将两个字母的出现次数分别减 1，并将剩余出现次数大于 0 的字母重新加入最大堆。
     * 由于最大堆中的元素都是不同的，因此取出的两个字母一定也是不同的，将两个不同的字母拼接到重构的字符串，可以确保相邻的字母都不相同。
     *
     * 如果最大堆变成空，则已经完成字符串的重构。如果最大堆剩下 1 个元素，则取出最后一个字母，拼接到重构的字符串。
     *
     * 对于长度为 n 的字符串，共有 n/2 次每次从最大堆取出两个字母的操作，当 n 是奇数时，还有一次从最大堆取出一个字母的操作，因此重构的字符串的长度一定是 n。
     *
     * 当 n 是奇数时，是否可能出现重构的字符串的最后两个字母相同的情况？
     * 如果最后一个字母在整个字符串中至少出现了 2 次，则在最后一次从最大堆取出两个字母时，该字母会先被选出，因此不会成为重构的字符串的倒数第二个字母，也不可能出现重构的字符串最后两个字母相同的情况。
     * @param S
     * @return
     */
    public static String reorganizeString(String S) {
        if (S.length() < 2) {
            return S;
        }
        //统计每个字符出现的次数
        int[] counts = new int[26];
        //统计字符串中字符出现的最大次数
        int maxCount = 0;
        for (char c : S.toCharArray()) {
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        //出现次数最多的字符如果超过字符串长度的一半+1，则肯定会存在相邻重复字符
        if (maxCount > (S.length() + 1) / 2) {
            return "";
        }
        //大顶堆
        PriorityQueue<Character> queue = new PriorityQueue<>((a, b) -> counts[b - 'a'] - counts[a - 'a']);
        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] > 0) {
                queue.offer(c);
            }
        }
        //输出结果
        StringBuilder res = new StringBuilder();
        //要判断下堆大小大于1，因为每次要poll两个字符出堆，奇数长度的字符串最后是不够poLl两个字符的
        while (!queue.isEmpty() && queue.size() > 1) {
            char c1 = queue.poll();
            char c2 = queue.poll();
            //拼接字符串
            res.append(c1).append(c2);
            //poll出堆的两个字符出现的次数分别减一
            if (--counts[c1 - 'a'] > 0) {
                //如果字符出现的次数仍然大于1，则再次入堆
                queue.offer(c1);
            }
            if (--counts[c2 - 'a'] > 0) {
                queue.offer(c2);
            }
        }
        //奇数长度的字符串最后还剩一个字符，还要再出一次堆
        if (queue.size() == 1) {
            res.append(queue.poll());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aaab"));
    }
}
