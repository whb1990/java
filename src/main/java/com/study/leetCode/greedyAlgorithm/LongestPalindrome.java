package main.java.com.study.leetCode.greedyAlgorithm;

/**
 * @author： whb
 * @description： LeetCode-409-最长回文串
 * @date： 2020-12-05 9:48
 * 难度：简单
 * 标签：哈希表
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class LongestPalindrome {
    /**
     * 贪心
     * 回文串中的字符最多只有一个字符能出现奇数次，其余都出现偶数次。
     *
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        // 由于 大写字母 'A' 与小写字母 'a' 的 ASCII 相差 32
        // 所以设置哈希表的大小为 32 + 26 = 58
        int[] counts = new int[58];
        //统计每个字符出现的次数
        for (char c : s.toCharArray()) {
            counts[c - 'A']++;
        }
        int res = 0;
        for (int i : counts) {
            // 字符出现的次数最多用偶数次。
            res += i - (i & 1);
        }
        // 如果最终的长度小于原字符串的长度，说明里面某个字符出现了奇数次，那么那个字符可以放在回文串的中间，所以额外再加一。
        return res < s.length() ? res + 1 : res;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }
}
