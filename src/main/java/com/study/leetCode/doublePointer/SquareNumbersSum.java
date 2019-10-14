package main.java.com.study.leetCode.doublePointer;

/**
 * @author: whb
 * @date: 2019/10/14 11:56
 * @description: 两数平方和
 * 题目描述：判断一个数是否为两个数的平方和。
 */
public class SquareNumbersSum {

    public static boolean judgeSquareSum(int c) {
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            int powSum = i * i + j * j;
            if (powSum == c) {
                System.out.println("c = " + i + " * " + i + " + " + j + " * " + j);
                return true;
            } else if (powSum > c) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(8));
    }
}


