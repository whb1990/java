package main.java.com.study.leetCode.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author： whb
 * @description： LeetCode-面试题17.22.单词转换
 * @date： 2020-11-26 15:53
 * 难度：中等
 * 标签：深度优先搜索、广度优先搜索、数组、字符串
 * 给定字典中的两个词，长度相等。写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。每一步得到的新词都必须能在字典中找到。
 *
 * 编写一个程序，返回一个可能的转换序列。如有多个可能的转换序列，你可以返回任何一个。
 *
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出:
 * ["hit","hot","dot","lot","log","cog"]
 *
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: []
 *
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 */
public class FindLadders {
    /**
     * 回溯算法
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.isEmpty() || !wordList.contains(endWord)) {
            return new ArrayList<>();
        }
        return backtrack(beginWord, endWord, wordList, new HashSet<>());
    }

    private static List<String> backtrack(String beginWord, String endWord, List<String> wordList, HashSet<String> visited) {
        if (beginWord.equals(endWord)) {
            List<String> res = new ArrayList<>();
            res.add(beginWord);
            return res;
        }
        visited.add(beginWord);
        for (String word : wordList) {
            if (visited.contains(word)) {
                continue;
            }
            if (canChange(beginWord, word)) {
                List<String> subList = backtrack(word, endWord, wordList, visited);
                if (subList != null && !subList.isEmpty()) {
                    subList.add(0, beginWord);
                    return subList;
                }
            }
        }
        return new ArrayList<>();
    }

    private static boolean canChange(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (++diff > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
        System.out.println(findLadders("a", "c", Arrays.asList("a", "b", "c")));
        System.out.println(findLadders("hit", "cog", Arrays.asList("hot", "hit", "cog", "dot", "dog")));
    }
}
