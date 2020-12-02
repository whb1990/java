package main.java.com.study.leetCode.divideconquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author： whb
 * @description： LeetCode-241-为运算表达式设计优先级
 * @date： 2020-12-02 8:42
 * 难度：中等
 * 标签：分治算法
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 *
 * 示例 1:
 *
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 *
 * 示例 2:
 *
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 */
public class DiffWaysToCompute {
    /**
     * 分治算法
     * 碰到运算符号，递归求解前一半的值和后一半的值，然后根据运算符号，计算两者构成的值。
     * @param input
     * @return
     */
    // 记录已经计算出来的字符串对应的值，避免重复计算。
    Map<String, List<Integer>> cacheMap = new HashMap<>();
    public List<Integer> diffWaysToCompaute(String input) {
        if (input.isEmpty()) {
            return new ArrayList<>();
        }
        if (cacheMap.containsKey(input)) {
            return cacheMap.get(input);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            //递归划分
            if (c == '+' || c == '-' || c == '*') {
                // 出现运算符号，递归求解前半段和后半段。
                List<Integer> left = diffWaysToCompaute(input.substring(0, i));
                List<Integer> right = diffWaysToCompaute(input.substring(i + 1));
                //计算结果
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                res.add(l + r);
                                break;
                            case '-':
                                res.add(l - r);
                                break;
                            case '*':
                                res.add(l * r);
                                break;
                        }
                    }
                }
            }
        }
        //纯数字，input中没符号
        if (res == null || res.isEmpty()) {
            res.add(Integer.parseInt(input));
        }
        return res;
    }

    public static void main(String[] args) {
        DiffWaysToCompute obj = new DiffWaysToCompute();
        System.out.println(obj.diffWaysToCompaute("2-1-1"));
        System.out.println(obj.diffWaysToCompaute("2*3-4*5"));
    }
}
