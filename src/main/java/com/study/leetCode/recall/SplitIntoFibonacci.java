package main.java.com.study.leetCode.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： whb
 * @description： LeetCode-842-将数组拆分成斐波那契序列
 * @date： 2020-12-07 8:56
 * 难度：中等
 * 标签：贪心算法、字符串、回溯算法
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 *
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 *
 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 * F.length >= 3；
 * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 *
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 *
 *
 * 示例 1：
 * 输入："123456579"
 * 输出：[123,456,579]
 *
 * 示例 2：
 * 输入: "11235813"
 * 输出: [1,1,2,3,5,8,13]
 *
 * 示例 3：
 * 输入: "112358130"
 * 输出: []
 * 解释: 这项任务无法完成。
 *
 * 示例 4：
 * 输入："0123"
 * 输出：[]
 * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
 *
 * 示例 5：
 * 输入: "1101111"
 * 输出: [110, 1, 111]
 * 解释: 输出 [11,0,11,11] 也同样被接受。
 *
 *
 * 提示：
 * 1 <= S.length <= 200
 * 字符串 S 中只含有数字。
 */
public class SplitIntoFibonacci {
    /**
     * 回溯算法
     *
     * @param num
     * @return
     */
    public static List<Integer> splitIntoFibonacci(String num) {
        List<Integer> res = new ArrayList<>();
        if (num.isEmpty() || num.length() < 3) {
            return res;
        }
        boolean flag = backtrack(num, 0, res);
        return flag ? res : new ArrayList<>();
    }

    private static boolean backtrack(String num, int start, List<Integer> res) {
        //终止条件
        if (start == num.length() && res.size() > 2) {
            return true;
        }
        //从start 往后拆分
        for (int i = start; i < num.length(); i++) {
            String tmp = num.substring(start, i + 1);
            //剪枝：防止以 0 开头
            if (tmp.length() > 1 && tmp.charAt(0) == '0') {
                return false;
            }
            //剪枝：防止某个序列的长度超过原数字长度一半
            if (tmp.length() > num.length() / 2) {
                return false;
            }
            //剪枝：防止数值超过范围
            if (Long.parseLong(tmp) > Integer.MAX_VALUE) {
                return false;
            }
            int size = res.size();
            if (size < 2 || tmp.equals(addStrings(res.get(size - 1).toString(), res.get(size - 2).toString()))) {
                res.add(Integer.parseInt(tmp));
                //找到一个结果就返回
                if (backtrack(num, i + 1, res)) {
                    return true;
                }
                res.remove(res.size() - 1);
            }
        }
        return false;
    }

    /**
     * 字符串相加
     *
     * @param s1
     * @param s2
     * @return
     */
    private static String addStrings(String s1, String s2) {
        int i = s1.length() - 1, j = s2.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i >= 0 ? s1.charAt(i) - '0' : 0;
            int y = j >= 0 ? s2.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            i--;
            j--;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(splitIntoFibonacci("123456579"));
        System.out.println(splitIntoFibonacci("11235813"));
        System.out.println(splitIntoFibonacci("112358130"));
        System.out.println(splitIntoFibonacci("0123"));
        System.out.println(splitIntoFibonacci("1101111"));
    }
}
