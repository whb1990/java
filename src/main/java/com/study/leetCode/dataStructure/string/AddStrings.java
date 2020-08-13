package main.java.com.study.leetCode.dataStructure.string;

import java.util.Stack;

/**
 * @author: whb
 * @date: 2020/8/13 10:56
 * @description: LeetCode-415-字符串相加
 * 难度：简单
 * 标签：数学、字符串
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 提示：
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 */
public class AddStrings {
    /**
     * 将字符串转成栈存储再计算和
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {
        Stack<Integer> s1 = buildStack(num1);
        Stack<Integer> s2 = buildStack(num2);
        Stack<Integer> stack = new Stack<>();
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int x = s1.isEmpty() ? 0 : s1.pop();
            int y = s2.isEmpty() ? 0 : s2.pop();
            int sum = x + y + carry;
            carry = sum / 10;
            stack.push(sum % 10);
        }
        StringBuffer result = new StringBuffer();
        while (!stack.isEmpty()) {
            result.append(String.valueOf(stack.pop()));
        }
        return result.toString();
    }

    private static Stack<Integer> buildStack(String num) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            stack.push(num.charAt(i) - '0');
        }
        return stack;
    }

    public static void main(String[] args) {
        System.out.println(addStrings("123", "456"));
    }
}
