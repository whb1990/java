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

    /**
     * 模拟竖式加法
     * 竖式加法就是将相同数位对齐，从低到高逐位相加，如果当前位和超过 10，则向高位进一位。
     * 定义两个指针 i 和 j 分别指向 num1 和 num2 的末尾，即最低位，同时定义一个变量 carry 维护当前是否有进位，然后从末尾到开头逐位相加即可。
     * 两个数字位数不同怎么处理，这里统一在指针当前下标处于负数的时候返回 0，等价于对位数较短的数字进行了补零操作，这样就可以除去两个数字位数不同情况的处理。
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings2(String num1, String num2) {
        int m = num1.length() - 1, n = num2.length() - 1, carry = 0;
        StringBuffer result = new StringBuffer();
        while (m >= 0 || n >= 0 || carry != 0) {
            int n1 = m >= 0 ? num1.charAt(m) - '0' : 0;
            int n2 = n >= 0 ? num2.charAt(n) - '0' : 0;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            result.append(sum % 10);
            m--;
            n--;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("123", "456"));
        System.out.println(addStrings2("123", "456"));
    }
}
