package main.java.com.study.leetCode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: whb
 * @date: 2020/5/29 19:33
 * @description: LeetCode-118-杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class PascalTriangle {
    public static void main(String[] args) {
        List<List<Integer>> result = generate(5);
        for (List<Integer> tmp : result) {
            tmp.forEach(System.out::print);
            System.out.println(" ");
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows > 0) {
            //添加第一行作为起始条件
            result.add(Arrays.asList(1));
            for (int row = 1; row < numRows; row++) {
                List<Integer> tmp = new ArrayList<>();
                List<Integer> preRow = result.get(row - 1);
                for (int j = 0; j <= row; j++) {
                    if (j > 0 && j < row) {
                        tmp.add(preRow.get(j - 1) + preRow.get(j));
                    } else {
                        tmp.add(1);
                    }
                }
                result.add(tmp);
            }
        }
        return result;
    }
}
