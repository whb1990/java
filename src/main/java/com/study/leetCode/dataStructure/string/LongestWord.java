package main.java.com.study.leetCode.dataStructure.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author： whb
 * @description： LeetCode-面试题17.15.最长单词
 * @date： 2020-11-26 16:15
 * 难度：中等
 * 标签：字符串
 * 给定一组单词words，编写一个程序，找出其中的最长单词，且该单词由这组单词中的其他单词组合而成。若有多个长度相同的结果，返回其中字典序最小的一项，若没有符合要求的单词则返回空字符串。
 *
 * 示例：
 *
 * 输入： ["cat","banana","dog","nana","walk","walker","dogwalker"]
 * 输出： "dogwalker"
 * 解释： "dogwalker"可由"dog"和"walker"组成。
 * 提示：
 *
 * 0 <= len(words) <= 200
 * 1 <= len(words[i]) <= 100
 */
public class LongestWord {
    public static String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        // 将单词列表按照长度降序，长度相同按照字典序
        Arrays.sort(words, (a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());

        // 把数组做成set，提高检测的效率
        Set<String> set = new HashSet<>(Arrays.asList(words));
        // 遍历检测当前单词是不是组合单词，是的话直接返回
        for (String word : words) {
            set.remove(word);
            if (isComposeWord(word, set)) {
                return word;
            }
            set.add(word);
        }
        return "";
    }

    /**
     * 检测word是否是由set里面的单词组成
     *
     * @param word
     * @param set
     * @return
     */
    private static boolean isComposeWord(String word, Set<String> set) {
        if (word.length() == 0) {
            return true;
        }
        for (int i = 0; i < word.length(); i++) {
            if (set.contains(word.substring(0, i + 1)) && isComposeWord(word.substring(i + 1), set)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(longestWord(new String[]{"cat", "banana", "dog", "nana", "walk", "walker", "dogwalker"}));
    }
}
