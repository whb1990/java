package main.java.com.study.leetCode.stackQueue;

import java.util.Stack;

/**
 * @author: whb
 * @date: 2020/5/29 16:01
 * @description: LeetCode-394-字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * 示例:
 * <p>
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class DecodeString {

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString("3[a]2[bc]"));
        System.out.println(decodeString.decodeString("3[a2[c]]"));
        System.out.println(decodeString.decodeString("2[abc]3[cd]ef"));
    }

    /**
     * 设置两个栈，命名为strStack和numStack，分别用来存当前所得到的结果result和数字；
     * 设置一个StringBuilder，用来存放当前的result；
     * 遇到数字，就将该数字压入numStack中；
     * 遇到“[”，就将当前得到的result压入strStack中；
     * 遇到“]”，就将strStack给pop，并且将numStack给pop，设置一个循环，将这个strStack给append上去，然后赋给result，等待下一次被压栈。
     * 最后返回result即可。
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
        if (s.length() == 0) {
            return "";
        }
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = 0;
                //数字可能是两位数或三位数
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    //char 转成 int 是基础操作, 要牢记
                    num = 10 * num + s.charAt(i) - '0';
                    i++;
                }
                i--;
                numStack.push(num);
            } else if (c == '[') {
                strStack.push(result.toString());
                result = new StringBuilder();
            } else if (c == ']') {
                int num = numStack.pop();
                StringBuilder tmp = new StringBuilder(strStack.pop());
                for (int j = 0; j < num; j++) {
                    tmp.append(result);
                }
                result = tmp;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
