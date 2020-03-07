package main.java.com.study.leetCode.stackQueue;

import java.util.Stack;

/**
 * @author: whb
 * @date: 2020/3/5 19:21
 * @description: 用栈实现括号匹配
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> cStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                cStack.push(c);
            } else {
                if (cStack.isEmpty()) {
                    return false;
                }
                char cur = cStack.pop();
                boolean b1 = c == ')' && cur != '(';
                boolean b2 = c == ']' && cur != '[';
                boolean b3 = c == '}' && cur != '{';
                if (b1 || b2 || b3) {
                    return false;
                }
            }
        }
        return cStack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        String s = "()[]";
        System.out.println(validParentheses.isValid(s));
    }
}
