package main.java.com.study.leetCode.dataStructure.string;

/**
 * @author： whb
 * @description： LeetCode-678-有效的括号字符串
 * @date： 2020-10-22 15:32
 * 难度：中等
 * 标签：字符串、贪心算法
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * 示例 1:
 * 输入: "()"
 * 输出: True
 *
 * 示例 2:
 * 输入: "(*)"
 * 输出: True
 *
 * 示例 3:
 * 输入: "(*))"
 * 输出: True
 *
 * 注意:
 * 字符串大小将在 [1，100] 范围内。
 */
public class CheckValidString {
    /**
     * 贪心算法
     * lo、hi表示「可能多余的左括号」，一个下界，一个上界。执行起来就是
     * 遇到左括号：lo++, hi++
     * 遇到星号：lo--, hi++（因为星号有三种情况）
     * 遇到右括号：lo--, hi--
     * lo要保持不小于0。（要理解lo的意思，考虑下这个例子(**)(
     * 如果hi < 0，说明把星号全变成左括号也不够了，False
     * 最後，如果lo > 0，说明末尾有多余的左括号，False
     *
     * @param s
     * @return
     */
    public static boolean checkValidString(String s) {
        // 维护当前左括号的数量范围：[lo, hi]
        int lo = 0, hi = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                lo++;
                hi++;
            } else if (c == ')') {
                lo = Math.max(0, lo - 1);
                hi--;
                if (hi < 0) {
                    // 左括号不够
                    return false;
                }
            } else {
                lo = Math.max(0, lo - 1);
                // 可作为左括号
                hi++;
            }
        }
        return lo <= 0;
    }

    public static void main(String[] args) {
        System.out.println(checkValidString("()"));
        System.out.println(checkValidString("(*)"));
        System.out.println(checkValidString("(*))"));
    }
}
