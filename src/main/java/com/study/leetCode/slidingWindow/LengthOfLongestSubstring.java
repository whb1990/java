package main.java.com.study.leetCode.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: whb
 * @date: 2020/6/11 17:02
 * @description: LeetCode-3-无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {
    /**
     * 滑动窗口算法
     * 定义两个指针，start和end，代表当前窗口的开始和结束位置，使用HashSet存储窗口中的字符。
     * 当窗口中出现重复的字符时，移除start处的字符，并让start++,没有重复时，添加end处的字符，并让end++,每次更新长度的最大值
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int result = 0, start = 0, end = 0;
        Set<Character> set = new HashSet<>();
        while (start < s.length() && end < s.length()) {
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start++));
            } else {
                set.add(s.charAt(end++));
                result = Math.max(result, set.size());
            }
        }
        return result;
    }

    /**
     * 套用LeetCode-567-字符串的排列的滑动窗口模版
     * 这need和valid都不需要，更新窗口内数据也只需要简单的更新计数器window即可。
     * <p>
     * 当window.get(c)值大于 1 时，说明窗口中存在重复字符，不符合条件，就该移动left缩小窗口了。
     * <p>
     * 唯一需要注意的是，在哪里更新结果res呢？我们要的是最长无重复子串，哪一个阶段可以保证窗口中的字符串是没有重复的呢？
     * <p>
     * 这里和之前不一样，要在收缩窗口完成后更新res，因为窗口收缩的 while 条件是存在重复元素，换句话说收缩完成后一定保证窗口中没有重复嘛。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
                res = Math.max(res, right - left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));

        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(lengthOfLongestSubstring2("bbbbb"));
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
    }
}
