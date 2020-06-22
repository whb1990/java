package main.java.com.study.leetCode.recursion;

/**
 * @author: whb
 * @date: 2020/6/20 15:16
 * @description: LeetCode-10-正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 */
public class IsMatch {
    /**
     * 第二个字符如果是*，第一个字符可以不匹配(因为*前面的数可以为0次)，如果第二个字符不是*，如果第一个字符不匹配就返回flase 所以分为第二个字符是不是*两种情况 ：
     * <p>
     * （1）第二个字符是*时： 如果第一个字符能匹配上，str向后移1位，pattern不动，继续向后匹配 如果第一个字符不能匹配，str不动， pattern向后移2位，继续向后匹配 ；
     * <p>
     * （2）第二个字符不是*时(或者pattern只剩下1个字符)： 如果第一个字符能匹配上，str向后移1位，pattern向后移1位 如果第一个字符不能匹配，返回false ；
     * <p>
     * 结束时，如果pattern为空，str不为空返回false；如果pattern为空，str为空返回true。
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        //注意if括号中的是判断p是否为空，而不是s是否为空，，因为如果s为空，p可以不为空，因为*前面那个字符可以是出现0次
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        //判断第一个字符是否能匹配上，做一个标记
        boolean first_match = (s.length() > 0) && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        //如果p的长度大于等于2，并且p的第二个字符是*。有两种情况：1.第一个字符匹配不上，s不动P向后移动2个位置，继续比较
        //第一个字符能匹配上(first_match),后移动1个位置,p不动，继续比较
        //否则，如果p的第二个字符不是*,是普通字符或者是.,先判断第一个字符是否能匹配上，再将s向后移1位，p向后移1位，继续比较
        if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p));
        } else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }
    public static boolean stringIsMac(String strMac)
    {
        // 这是真正的Mac地址，正则表达式
        String trueMacAddress = "([A-Fa-f0-9]{2}:){5}[A-Fa-f0-9]{2}";
        //不行的话可以试试下面这个
        //String trueMacAddress = "^[a-fA-F0-9]{2}+:[a-fA-F0-9]{2}+:[a-fA-F0-9]{2}+:[a-fA-F0-9]{2}+:[a-fA-F0-9]{2}+:[a-fA-F0-9]{2}$";
        if (strMac.matches(trueMacAddress))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("mississippi", "mis*is*p*."));
        String str = "86587DBEB8C6";
        String regex = "(.{2})";
        str = str.replaceAll(regex, "$1:");
        str = str.substring(0, str.length() - 1);
        System.out.println(str);
        System.out.println(str.indexOf(" "));
        System.out.println(stringIsMac("86:58:7D:BE:B8:C6"));
        System.out.println(stringIsMac("86587DBEB8C6"));
    }
}
