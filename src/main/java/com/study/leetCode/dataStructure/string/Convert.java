package main.java.com.study.leetCode.dataStructure.string;

import java.util.Arrays;

/**
 * @author： whb
 * @description： LeetCode-6-Z字形变换
 * @date： 2020-10-16 10:40
 * 难度：中等
 * 标签：字符串
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class Convert {
    /**
     * 对于输入的字符串s，其下标 i / (numRows-1) 如果为偶数或零，则代表该下标代表的字符在Z字型中属于竖列。
     * 如果 i / (numRows-1) 如果为奇数，则代表该下标代表的字符在Z字型中属于斜列（Z字型的中间倾斜部分）。
     * 如果当前字符属于竖列，则按照正序依次保存在字符串数组 tmp 中；
     * 如果属于斜列，则逆序保存。
     * 最后将 tmp 数组依次按序输出就是最终答案。
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        String[] tmp = new String[numRows];
        Arrays.fill(tmp, "");
        if (s.isEmpty() || numRows < 1) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            int ans = i / (numRows - 1);
            int cur = i % (numRows - 1);
            if (ans % 2 == 0) {
                //结果为偶数或0，按余数正序保存
                tmp[cur] += s.charAt(i);
            }
            if (ans % 2 != 0) {
                //结果为奇数，按余数逆序保存
                tmp[numRows - cur - 1] += s.charAt(i);
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < tmp.length; i++) {
            res.append(tmp[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 3));
        System.out.println(convert("LEETCODEISHIRING", 4));
    }
}
