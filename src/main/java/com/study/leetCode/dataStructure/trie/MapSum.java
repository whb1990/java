package main.java.com.study.leetCode.dataStructure.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author： whb
 * @description： LeetCode-677-键值映射
 * @date： 2020-10-28 9:04
 * 难度：中等
 * 标签：设计、字典树
 * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
 *
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 *
 *
 * 示例：
 *
 * 输入：
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：
 * [null, null, 3, null, 5]
 *
 * 解释：
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 *
 *
 * 提示：
 *
 * 1 <= key.length, prefix.length <= 50
 * key 和 prefix 仅由小写英文字母组成
 * 1 <= val <= 1000
 * 最多调用 50 次 insert 和 sum
 */
public class MapSum {
    private TrieNode root;

    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode cur = root;
        for (char c : key.toCharArray()) {
            if (cur.childrenMap.get(c) == null) {
                cur.childrenMap.put(c, new TrieNode());
            }
            cur = cur.childrenMap.get(c);
        }
        cur.num = val;
    }

    public int sum(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.childrenMap.get(c) == null) {
                return 0;
            }
            cur = cur.childrenMap.get(c);
        }
        return sum(cur);
    }

    /**
     * 递归遍历求和
     *
     * @param cur
     * @return
     */
    private int sum(TrieNode cur) {
        int res = cur.num;
        for (char c : cur.childrenMap.keySet()) {
            if (cur.childrenMap.get(c) != null) {
                res += sum(cur.childrenMap.get(c));
            }
        }
        return res;
    }

    class TrieNode {
        public int num;
        public Map<Character, TrieNode> childrenMap = new HashMap<>();
    }

    public static void main(String[] args) {
        MapSum obj = new MapSum();
        obj.insert("apple", 3);
        System.out.println(obj.sum("ap"));
        obj.insert("app", 2);
        System.out.println(obj.sum("ap"));
    }
}
