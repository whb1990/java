package main.java.com.study.leetCode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author： whb
 * @description： LeetCode-76-最小覆盖子串
 * @date： 2020-11-09 17:50
 * 难度：困难
 * 标签：哈希表、双指针、字符串、SlidingWindow
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 *
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 *
 * 提示：
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 */
public class MinWindow {
    /**
     * 滑动窗口+双指针
     * 1、在字符串S中使用双指针中的左右指针技巧，初始化left = right = 0，把索引左闭右开区间[left, right)称为一个「窗口」。
     *
     * 2、先不断地增加right指针扩大窗口[left, right)，直到窗口中的字符串符合要求（包含了T中的所有字符）。
     *
     * 3、此时，停止增加right，转而不断增加left指针缩小窗口[left, right)，直到窗口中的字符串不再符合要求（不包含T中的所有字符了）。同时，每次增加left，都要更新一轮结果。
     *
     * 4、重复第 2 和第 3 步，直到right到达字符串S的尽头。
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        //记录字符串t中出现的字符及次数
        Map<Character, Integer> need = new HashMap<>();
        //window代表窗口中相应字符的出现次数
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        //双指针
        int left = 0, right = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        //表示窗口中满足need条件的字符个数
        int valid = 0;
        while (right < s.length()) {
            //c是将移入窗口的字符
            char c = s.charAt(right);
            //右移窗口
            right++;
            //进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }
            //判断左侧窗口是否要收缩
            while (valid == need.size()) {
                //在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                //d是将移出窗口的字符
                char d = s.charAt(left);
                //左移窗口
                left++;
                //进行窗口内一系列数据的更新
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        //返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("ab", "a"));
    }
}
