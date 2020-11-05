package main.java.com.study.leetCode.dataStructure.dfsbfs;

import java.util.*;

/**
 * @author： whb
 * @description： LeetCode-127-单词接龙
 * @date： 2020-11-05 8:58
 * 难度：中等
 * 标签：广度优先搜索
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * <p>
 * 说明:
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * <p>
 * 示例 1:
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * <p>
 * 示例 2:
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: 0
 * <p>
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
        if (wordList == null || wordList.isEmpty() || !wordList.contains(endWord)) {
            return 0;
        }
        //广度优先遍历，必须使用队列
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        //表示是否访问过
        boolean[] marked = new boolean[wordList.size() + 1];
        // 开始广度优先遍历，包含起点，因此初始化的时候步数为 1
        int layer = 1;
        while (!queue.isEmpty()) {
            //步数+1
            layer++;
            int size = queue.size();
            while (size-- > 0) {
                // 依次遍历当前队列中的单词
                String currentWord = queue.poll();
                for (int i = 0; i < wordList.size(); i++) {
                    if (marked[i]) {
                        continue;
                    }
                    // 如果 currentWord 能够修改 1 个字符与 endWord 相同，则返回 layer
                    if (canChange(wordList.get(i), currentWord)) {
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

    /**
     * 双向BFS
     * 已知目标顶点的情况下，可以分别从起点和目标顶点（终点）执行广度优先遍历，直到遍历的部分有交集。这种方式搜索的单词数量会更小一些；
     * 更合理的做法是，每次从单词数量小的集合开始扩散；
     * 这里 beginVisited 和 endVisited 交替使用，等价于单向 BFS 里使用队列，每次扩散都要加到总的 visited 里。
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        // 第 1 步：先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }

        // 第 2 步：已经访问过的 word 添加到 visited 哈希表里
        Set<String> visited = new HashSet<>();
        // 分别用左边和右边扩散的哈希表代替单向 BFS 里的队列，它们在双向 BFS 的过程中交替使用
        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);
        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);

        // 第 3 步：执行双向 BFS，左右交替扩散的步数之和为所求
        int step = 1;
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            // 优先选择小的哈希表进行扩散，考虑到的情况更少
            if (beginVisited.size() > endVisited.size()) {
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }

            // 逻辑到这里，保证 beginVisited 是相对较小的集合，nextLevelVisited 在扩散完成以后，会成为新的 beginVisited
            Set<String> nextLevelVisited = new HashSet<>();
            for (String word : beginVisited) {
                if (changeWordEveryOneLetter(word, endVisited, visited, wordSet, nextLevelVisited)) {
                    return step + 1;
                }
            }

            // 原来的 beginVisited 废弃，从 nextLevelVisited 开始新的双向 BFS
            beginVisited = nextLevelVisited;
            step++;
        }
        return 0;
    }


    /**
     * 尝试对 word 修改每一个字符，看看是不是能落在 endVisited 中，扩展得到的新的 word 添加到 nextLevelVisited 里
     *
     * @param word
     * @param endVisited
     * @param visited
     * @param wordSet
     * @param nextLevelVisited
     * @return
     */
    private static boolean changeWordEveryOneLetter(String word, Set<String> endVisited,
                                                    Set<String> visited,
                                                    Set<String> wordSet,
                                                    Set<String> nextLevelVisited) {
        char[] charArray = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char originChar = charArray[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (originChar == c) {
                    continue;
                }
                charArray[i] = c;
                String nextWord = String.valueOf(charArray);
                if (wordSet.contains(nextWord)) {
                    if (endVisited.contains(nextWord)) {
                        return true;
                    }
                    if (!visited.contains(nextWord)) {
                        nextLevelVisited.add(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            // 恢复，下次再用
            charArray[i] = originChar;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));

        System.out.println(ladderLength2("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(ladderLength2("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
    }
}
