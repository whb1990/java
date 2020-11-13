package main.java.com.study.leetCode.dataStructure.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: whb
 * @date: 2020/8/26 9:53
 * @description: LeetCode-17-电话号码的字母组合
 * 难度：中等
 * 标签：字符串、回溯算法
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
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

    /**
     * 回溯算法
     * 首先使用哈希表存储每个数字对应的所有可能的字母，然后进行回溯操作。
     * <p>
     * 回溯过程中维护一个字符串，表示已有的字母排列（如果未遍历完电话号码的所有数字，则已有的字母排列是不完整的）。
     * 该字符串初始为空。每次取电话号码的一位数字，从哈希表中获得该数字对应的所有可能的字母，并将其中的一个字母插入到已有的字母排列后面，
     * 然后继续处理电话号码的后一位数字，直到处理完电话号码中的所有数字，即得到一个完整的字母排列。然后进行回退操作，遍历其余的字母排列。
     * <p>
     * 回溯算法用于寻找所有的可行解，如果发现一个解不可行，则会舍弃不可行的解。
     * 在这道题中，由于每个数字对应的每个字母都可能进入字母组合，因此不存在不可行的解，直接穷举所有的解即可。
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations2(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        List<String> res = new ArrayList<>();
        StringBuffer track = new StringBuffer();
        backtrack(digits, phoneMap, 0, track, res);
        return res;
    }

    private static void backtrack(String digits, Map<Character, String> phoneMap, int index, StringBuffer track, List<String> res) {
        if (index == digits.length()) {
            res.add(track.toString());
            return;
        }
        //逐层取出数字如2、3、4. lenth从0～digits的长度，每次递归就遍历到一个数字
        char letter = digits.charAt(index);
        //取出数字对应字符串 如2对应"abc"
        String letterStr = phoneMap.get(letter);
        //依次遍历字符串中字符 如'a' 'b' 'c'
        for (int i = 0; i < letterStr.length(); i++) {
            //将遍历到的字母加入track
            track.append(letterStr.charAt(i));
            //调用下一层递归
            backtrack(digits, phoneMap, index + 1, track, res);
            //撤销选择
            track.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations2("23"));
    }
}
