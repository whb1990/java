package main.java.com.study.leetCode.dataStructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author： whb
 * @description： LeetCode-1002-查找常用字符
 * @date： 2020-10-14 10:02
 * 难度：简单
 * 标签：数组、哈希表
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 *
 * 示例 2：
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *  
 *
 * 提示：
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 */
public class CommonChars {
    /**
     * 本题可以理解为求每个字符串之间字符数量的交集，以示例1为例：
     * 输入：["bella","label","roller"]
     * 输出：["e","l","l"]
     *
     * 我们知道第一个字符串的字符数量列表为：
     * b 1
     * e 1
     * l 2
     * a 1
     *
     * 第二个字符串的字符数量列表为：
     * l 2
     * a 1
     * b 1
     * e 1
     *
     * 第三个字符串的字符数量列表为：
     * r 2
     * o 1
     * l 2
     * e 1
     *
     * 这三个求交集后的结果为：
     * e 1
     * l 2
     * 结果一目了然。
     *
     * 可以用hashmap来表示**字符-数量**之间的关系，但是考虑到效率的问题，
     * 可以使用数组来对代码进行优化。用数组res的下标i表示是哪个字符，用res[i]表示该字符出现的次数。
     * @param A
     * @return
     */
    public static List<String> commonChars(String[] A) {
        int[] res = new int[26];
        for (char c : A[0].toCharArray()) {
            res[c - 'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            int[] tmp = new int[26];
            for (char c : A[i].toCharArray()) {
                tmp[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                res[j] = Math.min(res[j], tmp[j]);
            }
        }
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i]; j++) {
                resultList.add(((char) ('a' + i) + ""));
            }
        }
        System.out.println(Arrays.toString(resultList.toArray(new String[resultList.size()])));
        return resultList;
    }

    public static void main(String[] args) {
        commonChars(new String[]{"bella", "label", "roller"});
        commonChars(new String[]{"cool", "lock", "cook"});
    }
}
