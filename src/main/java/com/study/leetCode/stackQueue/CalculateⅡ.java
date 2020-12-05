package main.java.com.study.leetCode.stackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author： whb
 * @description： LeetCode-224-基本计算器
 * @date： 2020-12-04 19:49
 * 难度：困难
 * 标签：栈、字符串
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 *
 * 示例 1:
 *
 * 输入: "1 + 1"
 * 输出: 2
 *
 * 示例 2:
 *
 * 输入: " 2-1 + 2 "
 * 输出: 3
 *
 * 示例 3:
 *
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 * 说明：
 *
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 */
public class CalculateⅡ {
    /**
     * 这里实现的通用方法：包含加减乘除括号
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        int[] i = new int[1];
        return dfs(s, i);
    }

    private int dfs(String s, int[] i) {
        Deque<Integer> stack = new ArrayDeque<>();

        //记录某个连续的数，比如 "42"，那么我们首先 num = 4，然后遇到 2 ,num = num * 10 + 2 = 42
        int num = 0;
        char op = '+';
        for (; i[0] < s.length(); i[0]++) {
            char ch = s.charAt(i[0]);

            //遇到左括号开始递归计算 num
            if (ch == '(') {
                ++i[0];
                num = dfs(s, i);
            }

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            //不是数字，不是空格（运算符 或 '(' 或 ')' ） 或者 到了最后一个字符，那么根据前面记录的 op 操作符 将数字压栈，然后将新的运算符 ch 赋值给 op
            if (!Character.isDigit(ch) && ch != ' ' || i[0] == s.length() - 1) {
                switch (op) {
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
                num = 0;
                op = ch;
            }
            /*
            遇到右括号，退出循环，然后计算结果， 返回上一层 dfs
            这一步写在最后是因为，当 ch 为 右括号 时，那么需要先将前面已经得到的 num 压入栈中，再退出循环
            */
            if (ch == ')') {
                break;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        CalculateⅡ obj = new CalculateⅡ();
        System.out.println(obj.calculate("3+2*2"));
        System.out.println(obj.calculate(" 3/2 "));
        System.out.println(obj.calculate(" 3+5 / 2 "));
        System.out.println(obj.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(obj.calculate("3 * (2-6 /(3 -7))"));
    }
}
