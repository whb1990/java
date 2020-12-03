package main.java.com.study.leetCode.mathematics;

/**
 * @author： whb
 * @description： LeetCode-476-数字的补数
 * @date： 2020-12-03 11:54
 * 难度：简单
 * 标签：位运算
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 * 
 * 
 * 示例 1:
 * 
 * 输入: 5
 * 输出: 2
 * 解释: 5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 * 
 * 示例 2:
 * 
 * 输入: 1
 * 输出: 0
 * 解释: 1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 * 
 * 
 * 注意:
 * 
 * 给定的整数保证在 32 位带符号整数的范围内。
 * 你可以假定二进制数不包含前导零位。
 * 本题与 1009 https://leetcode-cn.com/problems/complement-of-base-10-integer/ 相同
 */
public class FindComplement {
    /**
     * 就是num转为二进制，并看看总共x位二进制，然后与这全部的x位都是1的二进制进行异或运算（相同为0，不同为1）。就得出结果。
     *
     * @param num
     * @return
     */
    public static int findComplement(int num) {
        if (num == 0) {
            return 1;
        }
        int tmp = num, res = 0;
        while (tmp > 0) {
            //根据判断条件
            //二进制右移并赋值给tmp，
            tmp >>= 1;
            //二进制左移之后结果+1 赋值给res
            res = (res << 1) + 1;
        }
        return res ^ num;
    }

    /**
     * 参考hashmap获得hash值实现
     *
     * @param num
     * @return
     */
    public static int findComplement2(int num) {
        if (num == 0) {
            return 1;
        }
        int n = num;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n ^ num;
    }

    /**
     * 反码的原理
     *
     * @param num
     * @return
     */
    public static int findComplement3(int num) {
        if (num == 0) {
            return 1;
        }
        int res = 1;
        while (res <= num) {
            res *= 2;
        }
        return res - num - 1;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(5));
        System.out.println(findComplement(1));
        System.out.println(findComplement2(5));
        System.out.println(findComplement2(1));
        System.out.println(findComplement3(5));
        System.out.println(findComplement3(1));
    }
}
