package main.java.com.study.leetCode.stackQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author： whb
 * @description： LeetCode-316-去除重复字母
 * @date： 2020-10-29 17:00
 * 难度：中等
 * 标签：
 * 栈、贪心算法、字符串
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 示例 1：
 * 输入：s = "bcabc"
 * 输出："abc"
 *
 * 示例 2：
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *
 *示例 3：
 * 输入："ecbacba"
 * 输出："eacb"
 *
 * 示例 4：
 * 输入："leetcode"
 * 输出："letcod"
 *
 * 提示：
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 */
public class RemoveDuplicateLetters {
    /**
     * 单调栈+贪心
     * 建立一个字典。其中 key 为 字符 c，value 为其出现的剩余次数。
     * 从左往右遍历字符串，每次遍历到一个字符，其剩余出现次数 - 1.
     * 对于每一个字符，如果其对应的剩余出现次数大于 1，可以选择丢弃（也可以选择不丢弃），否则不可以丢弃。
     * 是否丢弃的标准：如果栈中相邻的元素字典序更大，那么选择丢弃相邻的栈中的元素。
     * 边界条件：如果栈中剩下的元素大于 n - k，选择截取前 n - k 个数字。然而本题中的 k 是分散在各个字符中的，因此这种思路不可行的。
     * 不过不必担心。由于题目是要求只出现一次。可以在遍历的时候简单地判断其是否在栈上即可。
     * 时间复杂度：由于判断当前字符是否在栈上存在需要 O(N) 的时间，因此总的时间复杂度就是 O(N ^ 2)，其中 N 为字符串长度。
     * 空间复杂度：使用了额外的栈来存储数字，因此空间复杂度为 O(N)，其中 NN 为字符串长度。
     *
     * @param s
     * @return
     */
    public static String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Stack<Character> stack = new Stack<>();
        StringBuffer res = new StringBuffer();
        for (char c : s.toCharArray()) {
            if (!stack.contains(c)) {
                while (!stack.isEmpty() && stack.peek() > c && map.get(stack.peek()) > 0) {
                    stack.pop();
                }
                stack.push(c);
            }
            map.put(c, map.get(c) - 1);
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));
        System.out.println(removeDuplicateLetters("cbacdcbc"));
        System.out.println(removeDuplicateLetters("ecbacba"));
        System.out.println(removeDuplicateLetters("leetcode"));
    }
}
