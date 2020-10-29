package main.java.com.study.leetCode.stackQueue;

import java.util.Stack;

/**
 * @author： whb
 * @description： LeetCode-402-移掉K位数字
 * @date： 2020-10-29 14:20
 * 难度：中等
 * 标签：栈、贪心算法
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 *
 * 示例 1 :
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 *
 * 示例 2 :
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 *
 * 示例 3 :
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 */
public class RemoveKdigits {
    /**
     * 单调栈解法
     * 思路是：
     * 从左到右遍历，对于每一个遍历到的元素，决定是丢弃还是保留。
     * 问题的关键是：怎么知道一个元素是应该保留还是丢弃呢？
     * <p>
     * 这里有一个前置知识：对于两个数 123a456 和 123b456，如果 a > b， 那么数字 123a456 大于 数字 123b456，否则数字 123a456 小于等于数字 123b456。也就说，两个相同位数的数字大小关系取决于第一个不同的数的大小。
     * <p>
     * 因此思路就是：
     * <p>
     * 1、从左到右遍历
     * 2、对于遍历到的元素，我们选择保留。
     * 3、但是我们可以选择性丢弃前面相邻的元素。
     * 4、丢弃与否的依据如上面的前置知识中阐述中的方法。
     * 以题目中的 num = 1432219， k = 3 为例的过程如下：
     * 首先遍历1，由于没有左侧相邻元素，因此没办法丢弃。
     * 然后遍历4，由于 4 比左侧相邻的 1 大。如果选择丢弃左侧的 1，那么会使得剩下的数字更大（开头的数从 1 变成了 4）。因此我们仍然选择不丢弃。
     * 再接着遍历3，由于 3 比左侧相邻的 4 小。 如果选择丢弃左侧的 4，那么会使得剩下的数字更小（开头的数从 4 变成了 3）。因此我们选择丢弃。
     * 。。。。
     * 然而需要注意的是，如果给定的数字是一个单调递增的数字，那么我们的算法会永远选择不丢弃。这个题目中要求的，要永远确保丢弃 k 个矛盾。
     * <p>
     * 一个简单的思路就是：
     * 每次丢弃一次，k 减去 1。当 k 减到 0 ，我们可以提前终止遍历。
     * 而当遍历完成，如果 k 仍然大于 0。不妨假设最终还剩下 x 个需要丢弃，那么我们需要选择删除末尾 x 个元素。
     *
     * @param num
     * @param k
     * @return
     */
    public static String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        int remain = num.length() - k;
        for (char c : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        //之所以要substring截取一下是因为有可能原始数字是升序的，导致上面的算法没有移除k个字符，故需要丢弃尾部的数字。
        //replaceAll是为了清除数字字符串的前缀0，但有可能字符串全是0导致清除后字符串变空
        String res = sb.reverse().substring(0, remain).replaceAll("^(0+)", "");
        //所以返回的时候要判断如果字符串为空则返回0
        return "".equals(res) ? "0" : res;
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));
        System.out.println(removeKdigits("10200", 1));
        System.out.println(removeKdigits("10", 2));
        System.out.println(removeKdigits("112", 1));
    }
}
