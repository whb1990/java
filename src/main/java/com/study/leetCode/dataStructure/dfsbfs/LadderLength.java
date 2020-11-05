package main.java.com.study.leetCode.dataStructure.dfsbfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author： whb
 * @description： LeetCode-127-单词接龙
 * @date： 2020-11-05 8:58
 * 难度：中等
 * 标签：广度优先搜索
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 *
 * 说明:
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 *
 * 示例 1:
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出: 5
 *
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 *
 * 示例 2:
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
public class LadderLength {
    /**
     * BFS
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        boolean[] marked = new boolean[wordList.size() + 1];
        //返回的是层数，这里初始为1
        int layer = 1;
        while (!queue.isEmpty()) {
            layer++;
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                for (int i = 0; i < wordList.size(); i++) {
                    if (marked[i]) {
                        continue;
                    }
                    if (canChange(wordList.get(i), cur)) {
                        if (wordList.get(i).equals(endWord)) {
                            return layer;
                        }
                        queue.add(wordList.get(i));
                        marked[i] = true;
                    }
                }
            }
        }
        return 0;
    }

    /**
     * 单词之间是否可以转换
     *
     * @param s
     * @param t
     * @return
     */
    private static boolean canChange(String s, String t) {
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                //如果单词之间相差过多，则直接返回false
                if (++diff > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
    }
}
