package main.java.com.study.leetCode.dataStructure.string;

/**
 * @author： whb
 * @description： LeetCode-8-字符串转整数
 * @date： 2020-10-13 15:55
 * 难度：中等
 * 标签：数学、字符串
 */
public class StrToInt {
    /**
     * 算法思路：
     * <p>
     * 1、去掉前导空格
     * 2、再是处理正负号
     * 3、识别数字，注意越界情况。
     * 这道题目如果只是简单地字符串转整数的话，就是简单地 ans = ans * 10 + digit。
     * 但是注意这道题目可能会超过integer的最大表示！
     * 也就是说会在某一步 ans * 10 + digit > Integer.MAX_VALUE。
     * *10 和 +digit 都有可能越界，那么只要把这些都移到右边去就可以了。
     * ans > (Integer.MAX_VALUE - digit) / 10 就是越界。
     *
     * @param str
     * @return
     */
    public static int strToInt(String str) {
        char[] ch = str.toCharArray();
        int len = ch.length;
        int index = 0;
        while (index < len && ch[index] == ' ') {
            // 去掉前导空格
            index++;
        }
        if (index == len) {
            //去掉前导空格以后到了末尾了，即极端情况"    "
            return 0;
        }
        boolean negative = false;
        if (ch[index] == '-') {
            //遇到负号
            negative = true;
            index++;
        } else if (ch[index] == '+') {
            // 遇到正号
            index++;
        } else if (ch[index] > '9' || ch[index] < '0') {
            // 其他符号
            return 0;
        }
        int result = 0;
        while (index < len && ch[index] >= '0' && ch[index] <= '9') {
            // 本来应该是 result * 10 + digit > Integer.MAX_VALUE
            // 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
            int digit = ch[index] - '0';
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + digit;
            index++;
        }
        return negative ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(strToInt("42"));
        System.out.println(strToInt("   -42"));
        System.out.println(strToInt("4193 with words"));
        System.out.println(strToInt("words and 987"));
        System.out.println(strToInt("-91283472332"));
    }
}
