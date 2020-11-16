package main.java.com.study.leetCode.dp;

/**
 * @author： whb
 * @description： LeetCode-10-正则表达式匹配
 * @date： 2020-11-16 9:43
 * 难度：困难
 * 标签：字符串、动态规划、回溯算法
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 示例 1：
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2:
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 * 示例 3：
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 * 示例 4：
 * 输入：s = "aab" p = "c*a*b"
 * 输出：true
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 *
 * 示例 5：
 * 输入：s = "mississippi" p = "mis*is*p*."
 * 输出：false
 *
 *
 * 提示：
 * 0 <= s.length <= 20
 * 0 <= p.length <= 30
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 保证每次出现字符 * 时，前面都匹配到有效的字符
 */
public class IsMatch {
    /**
     * 递归解法
     * 从头处理s和p两个字符串：
     *
     * 首先，如果p为空了，此时若s不为空，则说明匹配失败，直接返回false，如果都为空，说明匹配结束，返回true。
     *
     * 其次，如果p不为空，存在两种情况，一种是单一匹配，一种是'*'的任意匹配。
     *
     * 先假设单一匹配，创建一个boolean类型的match变量，计算一下单一匹配是否成功：
     * 在单一匹配的情况下，s不能为空。
     * s和p的当前第一个字符需要相等，或者p的第一个字符为'.'。
     * 如果成功就可以将两个字符串的第一位去掉，继续匹配后续的字符。
     *
     * 还有可能是要进行任意匹配，任意匹配的条件是当前p的大小需要大于2，并且p[1]要为'*'，
     * 这个时候，可以匹配s中任意数量的字符p[0]。那么又是两种情况：
     * 看：如果看（匹配）一次，就相当于去掉s的第一个字符，继续向后匹配。
     * 不看：如果不看（就是不进行匹配=匹配0次），就相当于s不变，p向后去掉两位（字符p[0]和p[1]的'*'）。
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean firstMatch = s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
        if (p.length() > 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        }
        return isMatch(s.substring(1), p.substring(1));
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("mississippi", "mis*is*p*."));
    }
}
