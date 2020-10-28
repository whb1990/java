package main.java.com.study.leetCode.dataStructure.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author： whb
 * @description： LeetCode-211-添加与搜索单词-数据结构设计
 * @date： 2020-10-28 9:49
 * 难度：中等
 * 标签：设计、字典树、回溯算法
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 *
 *
 * 示例：
 *
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 *
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *
 *
 * 提示：
 * 1 <= word.length <= 500
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最调用多 50000 次 addWord 和 search
 */
public class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.childrenMap.get(c) == null) {
                cur.childrenMap.put(c, new TrieNode());
            }
            cur = cur.childrenMap.get(c);
        }
        // 当前节点代表结束
        cur.isEnd = true;
    }

    public boolean search(String word) {
        return helpSearch(word, root);
    }

    private boolean helpSearch(String word, TrieNode cur) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // 对于 . 递归的判断所有不为空的孩子
            if (c == '.') {
                for (char cc : cur.childrenMap.keySet()) {
                    if (helpSearch(word.substring(i + 1), cur.childrenMap.get(cc))) {
                        return true;
                    }
                }
                return false;
            }
            // 不含有当前节点
            if (cur.childrenMap.get(c) == null) {
                return false;
            }
            cur = cur.childrenMap.get(c);
        }
        // 当前节点是否为是某个单词的结束
        return cur.isEnd;
    }

    class TrieNode {
        public boolean isEnd;
        public Map<Character, TrieNode> childrenMap = new HashMap<>();
    }

    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        System.out.println(obj.search("pad"));
        System.out.println(obj.search("bad"));
        System.out.println(obj.search(".ad"));
        System.out.println(obj.search("b.."));
    }
}
