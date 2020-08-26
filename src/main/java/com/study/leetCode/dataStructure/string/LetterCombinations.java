package main.java.com.study.leetCode.dataStructure.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: whb
 * @date: 2020/8/26 9:53
 * @description: LeetCode-17-电话号码的字母组合
 * 难度：中等
 * 标签：字符串、回溯算法
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class LetterCombinations {
    /**
     * 利用队列求解
     * 利用队列的先进先出特点，再配合循环
     * 先将2对应的字符"a","b","c"依次放入队列中
     * 之后再从队列中拿出第一个元素"a"，跟3对应的字符"d","e","f"挨个拼接，于是队列变成了下面这个样子：
     * "b","c","ad","ae","af"
     * 按照同样的方式，再将"b"从队列中拿出，再跟3对应的字符"d","e","f"挨个拼接，队列又变成下面这个样子：
     * "c","ad","ae","af","bd","be","bf"
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        String[] letters_arr = new String[]{" ", "*", "abc", "def", "ghi",
                "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            String letters = letters_arr[digits.charAt(i) - '0'];
            int size = result.size();
            for (int j = 0; j < size; j++) {
                String tmp = result.remove(0);
                for (int k = 0; k < letters.length(); k++) {
                    result.add(tmp + letters.charAt(k));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
