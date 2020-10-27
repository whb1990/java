package main.java.com.study.leetCode.dataStructure.trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author： whb
 * @description： LeetCode-648-单词替换
 * @date： 2020-10-27 18:37
 * 难度：中等
 * 标签：字典树、哈希表
 * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 *
 * 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 *
 * 你需要输出替换之后的句子。
 *
 *
 * 示例 1：
 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 *
 * 示例 2：
 * 输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * 输出："a a b c"
 *
 * 示例 3：
 * 输入：dictionary = ["a", "aa", "aaa", "aaaa"], sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"
 * 输出："a a a a a a a a bbb baba a"
 *
 * 示例 4：
 * 输入：dictionary = ["catt","cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 *
 * 示例 5：
 * 输入：dictionary = ["ac","ab"], sentence = "it is abnormal that this solution is accepted"
 * 输出："it is ab that this solution is ac"
 *
 *
 * 提示：
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] 仅由小写字母组成。
 * 1 <= sentence.length <= 10^6
 * sentence 仅由小写字母和空格组成。
 * sentence 中单词的总量在范围 [1, 1000] 内。
 * sentence 中每个单词的长度在范围 [1, 1000] 内。
 * sentence 中单词之间由一个空格隔开。
 * sentence 没有前导或尾随空格。
 */
public class ReplaceWords {
    /**
     * 字典树解法
     * 把所有的词根放入前缀树中，在树上查找每个单词的最短词根，该操作可在线性时间内完成。
     * 时间复杂度：O(N)，其中 N 是 sentence 的长度。每次查询操作为线性时间复杂度。
     * 空间复杂度：O(N)，前缀树的大小。
     * @param dictionary
     * @param sentence
     * @return
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode trie = new TrieNode();
        for (String dicWord : dictionary) {
            TrieNode cur = trie;
            for (char c : dicWord.toCharArray()) {
                if (cur.childrenMap.get(c) == null) {
                    cur.childrenMap.put(c, new TrieNode());
                }
                cur = cur.childrenMap.get(c);
            }
            cur.word = dicWord;
        }
        StringBuffer res = new StringBuffer();
        for (String senStr : sentence.split("\\s+")) {
            TrieNode cur = trie;
            for (char c : senStr.toCharArray()) {
                if (cur.childrenMap.get(c) == null || cur.word != null) {
                    break;
                }
                cur = cur.childrenMap.get(c);
            }
            res.append(cur.word != null ? cur.word : senStr).append(" ");
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        ReplaceWords obj = new ReplaceWords();
        System.out.println(obj.replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
        System.out.println(obj.replaceWords(Arrays.asList("a", "b", "c"), "aadsfasf absbs bbab cadsfafs"));
        System.out.println(obj.replaceWords(Arrays.asList("a", "aa", "aaa", "aaaa"), "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"));
        System.out.println(obj.replaceWords(Arrays.asList("catt", "cat", "bat", "rat"), "the cattle was rattled by the battery"));
        System.out.println(obj.replaceWords(Arrays.asList("ac", "ab"), "it is abnormal that this solution is accepted"));
    }

    class TrieNode {
        public String word;
        public Map<Character, TrieNode> childrenMap = new HashMap<>();
    }
}
