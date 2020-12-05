package main.java.com.study.leetCode.stackQueue;

import java.util.Stack;

/**
 * @author： whb
 * @description： LeetCode-227-基本计算器Ⅱ
 * @date： 2020-12-04 18:37
 * 难度：中等
 * 标签：字符串、栈
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * <p>
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "3+2*2"
 * 输出: 7
 * <p>
 * 示例 2:
 * <p>
 * 输入: " 3/2 "
 * 输出: 1
 * <p>
 * 示例 3:
 * <p>
 * 输入: " 3+5 / 2 "
 * 输出: 5
 * 说明：
 * <p>
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 */
public class Calculate {
    /**
     * 如果在字符串左边加上一个加号，可以证明其并不改变运算结果，
     * 且字符串可以分割成多个 < 一个运算符，一个数字 > 对子的形式，这样一来我们就可以从左往右处理了。
     * 由于乘除的优先级高于加减，因此需要使用一个中间变量来存储高优先度的运算结果。
     *
     * @param s
     * @return
     */
    public static int calculate(String s) {
        int i = 0;
        char opt = '+';
        int left = 0, right = 0;
        while (i < s.length()) {
            if (s.charAt(i) != ' ') {
                int num = parseNum(s, i);
                switch (opt) {
                    case '+':
                        left += right;
                        right = num;
                        break;
                    case '-':
                        left += right;
                        right = -num;
                        break;
                    case '*':
                        right *= num;
                        break;
                    case '/':
                        right /= num;
                        break;
                }
                if (i < s.length()) {
                    opt = s.charAt(i);
                }
            }
            ++i;
        }
        return left + right;
    }

    private static int parseNum(String s, int i) {
        int num = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            //括号不能省略，否则造成整型溢出
            num = 10 * num + (s.charAt(i) - '0');
            i++;
        }
        return num;
    }

    /**
     * 思路：
     * 1. 如果碰到数字， 则把数字入栈
     * 2. 如果碰到空格， 则继续下一步
     * 3. 如果碰到 '+' '-' '*' '/', 则查找下一个数字num
     * A.如果是'+', 下一个数字num直接入栈
     * B.如果是'-'，-num入栈
     * C.如果是'*', num = stack.pop() * num, 入栈
     * D.如果是'/', num = stack.pop() / num, 入栈
     * 4. 最后，把栈里的数相加就是结果
     *
     * @param s
     * @return
     */
    public static int calculate2(String s) {
        Stack<Integer> stack = new Stack<>();
        // 记录算式中的数字
        int num = 0;
        // 记录 num 前的符号，初始化为 +
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果是数字，连续读取到 num
            if (Character.isDigit(c)) {
                num = 10 * num + (c - '0');
            }

            // 如果不是数字，就是遇到了下一个符号，
            // 之前的数字和符号就要存进栈中
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                // 更新符号为当前符号，数字清零
                sign = c;
                num = 0;
            }
        }
        // 将栈中所有结果求和就是答案
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
        System.out.println(calculate(" 3/2 "));
        System.out.println(calculate(" 3+5 / 2 "));
        System.out.println("=========栈解法============");
        System.out.println(calculate2("3+2*2"));
        System.out.println(calculate2(" 3/2 "));
        System.out.println(calculate2(" 3+5 / 2 "));
    }
}
