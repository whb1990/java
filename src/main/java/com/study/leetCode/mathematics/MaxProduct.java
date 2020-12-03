package main.java.com.study.leetCode.mathematics;

/**
 * @author： whb
 * @description： LeetCode-318-最大单词长度乘积
 * @date： 2020-12-03 9:58
 * 难度：中等
 * 标签：位运算
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 * <p>
 * 示例 2:
 * <p>
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * <p>
 * 示例 3:
 * <p>
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 */
public class MaxProduct {
    /**
     * 位运算
     * 全是小写字母, 可以用一个32为整数表示一个word中出现的字母,0表示对应字母不存在，1表示对应字母存在，重复的字母也用1表示，
     * a对应32位整数的最后一位,b对应整数的倒数第二位, 依次类推.
     * hash[i]存放第i个单词出现过的字母,
     * 在判断最大长度时，先将这两个字符串对应的二进制数进行与操作，如果结果不为0说明他们有相同字母，则不操作；
     * 结果为0就是不存在相同字母，判断他们的长度的乘积，遍历找到最大的即可。
     *
     * @param words
     * @return
     */
    public static int maxProduct(String[] words) {
        int[] hash = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                hash[i] |= 1 << (c - 'a');
            }
        }
        int res = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((hash[i] & hash[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
        System.out.println(maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
        System.out.println(maxProduct(new String[]{"a", "aa", "aaa", "aaaa"}));
    }
}
