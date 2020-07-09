package main.java.com.study.leetCode.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: whb
 * @date: 2020/7/9 15:16
 * @description: LeetCode-面试题17.13.恢复空格
 * 难度：中等
 * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 * <p>
 * 注意：本题相对原题稍作改动，只需返回未识别的字符数
 * <p>
 * 示例：
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
 * 提示：
 * 0 <= len(sentence) <= 1000
 * dictionary中总字符数不超过 150000。
 * 你可以认为dictionary和sentence中只包含小写字母。
 */
public class Respace {
    /**
     * 动态规划--暴力解法
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    public static int respace(String[] dictionary, String sentence) {
        Set<String> dic = new HashSet<>();
        for (String str : dictionary) {
            dic.add(str);
        }
        int len = sentence.length();
        //dp[i]代表sentence前i个字符所得的结果
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            //先假设当前字符不在字典中
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i; j++) {
                if (dic.contains(sentence.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        String[] dictionary = new String[]{"looked", "just", "like", "her", "brother"};
        String sentence = "jesslookedjustliketimherbrother";
        System.out.println(respace(dictionary, sentence));
    }
}
