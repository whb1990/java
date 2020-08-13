package main.java.com.study.leetCode.dataStructure.string;

/**
 * @author: whb
 * @date: 2020/8/13 11:13
 * @description: LeetCode-43-字符串相乘
 * 难度：中等
 * 标签：数学、字符串
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * <p>
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class Multiply {
    public static String multiply(String num1, String num2) {
        //如果有一个为零，则乘积为零
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        //m位数乘以n位数，乘积最多m + n位数
        int[] resultArr = new int[num1.length() + num2.length()];
        //从后向前乘，模拟竖乘
        for (int i = num1.length() - 1; i >= 0; i--) {
            //字符转整数
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = resultArr[i + j + 1] + n1 * n2;
                resultArr[i + j + 1] = sum % 10;
                //将进位加到前一位
                resultArr[i + j] += sum / 10;
            }
        }
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < resultArr.length; i++) {
            //如果首位为0，则跳过
            if (i == 0 && resultArr[i] == 0) {
                continue;
            }
            result.append(resultArr[i]);
        }
        return result.toString();
    }

    /**
     * 令 m 和 n 分别表示 num1 和 num2 的长度，并且它们均不为 0，则 num1 和 num2 的乘积的长度为 m+n-1 或 m+n。
     * 由于 num1 和 num2 的乘积的最大长度为 m+n，因此创建长度为 m+n 的数组 resultArr 用于存储乘积。对于任意 0≤i<m 和 0≤j<n，num1[i]*num2[j]的结果位于resultArr[i+j+1]，
     * 如果 resultArr[i+j+1]≥10，则将进位部分加到 resultArr[i+j]。
     * 最后，将数组 resultArr 转成字符串，如果最高位是 0 则舍弃最高位。
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] resultArr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                resultArr[i + j + 1] += n1 * n2;
            }
        }
        for (int i = resultArr.length - 1; i > 0; i--) {
            resultArr[i - 1] += resultArr[i] / 10;
            resultArr[i] = resultArr[i] % 10;
        }
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < resultArr.length; i++) {
            if (i == 0 && resultArr[i] == 0) {
                continue;
            }
            result.append(resultArr[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("2", "3"));
        System.out.println(multiply("25", "25"));
        System.out.println(multiply("123", "456"));
        System.out.println(multiply2("2", "3"));
        System.out.println(multiply2("25", "25"));
        System.out.println(multiply2("123", "456"));
    }
}
